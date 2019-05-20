package br.com.valid.bio.agreement.configuration.kairos;

import br.com.valid.bio.agreement.configuration.ChannelConfiguration;
import br.com.valid.bio.agreement.integration.KairosBaseService;
import br.com.valid.bio.agreement.integration.wrapper.AgreementRequestWrapper;
import br.com.valid.bio.agreement.model.ConveniadasHeaderValueEnum;
import br.com.valid.bio.agreement.model.partner.kairos.BaseResponse;
import br.com.valid.bio.agreement.model.partner.kairos.enroll.EnrollRequest;
import br.com.valid.bio.agreement.model.partner.kairos.recognize.RecognizeRequest;
import br.com.valid.bio.agreement.model.partner.kairos.verify.VerifyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Transformers;
import org.springframework.integration.http.inbound.HttpRequestHandlingMessagingGateway;
import org.springframework.integration.http.inbound.RequestMapping;
import org.springframework.integration.http.outbound.HttpRequestExecutingMessageHandler;
import org.springframework.integration.http.support.DefaultHttpHeaderMapper;
import org.springframework.messaging.MessageChannel;

import java.util.List;
/**
 * Proposito efetuar configuracao dos endpoints enroll e recognize Kairos Rest API.
 * TODO: Verificar metodo de configuracao da API ID e API KEY. 
 * TODO: Verificar como passar como parametro configuracao do servico HttpRequestFactory.
 * @author jose.canova
 */
@Configuration
public class KairosConfiguration {

	public static final String APP_ID = "app_id";
	public static final String APP_KEY = "app_key";
	public static final char KAIROS_WILDCARD = '*';

	@Autowired
	private KairosProperties kairosProperties;
	
	@Autowired
	private ChannelConfiguration channelConfiguration;
	
	@Autowired
	private List<HttpMessageConverter<?>> httpMessageConverters;

	@Autowired
	private DefaultHttpHeaderMapper defaultHeaderMapper;
	


	/**
	 * Mapping inicial para endpoint kairos
	 * @return
	 */
	@Bean
	public RequestMapping mappingKairos() {
		RequestMapping mapping = new RequestMapping();
		mapping.setMethods(new HttpMethod[] {HttpMethod.GET , HttpMethod.POST});
		mapping.setConsumes(MediaType.APPLICATION_JSON_VALUE);
		mapping.setProduces(MediaType.APPLICATION_JSON_VALUE);
		mapping.setPathPatterns("/kairos");
		return mapping;
	}




	@Bean
	public HttpRequestHandlingMessagingGateway httpGatewayKairos() {
		HttpRequestHandlingMessagingGateway gateway = new HttpRequestHandlingMessagingGateway(true);
		gateway.setRequestMapping(mappingKairos());
		gateway.setReplyTimeout(5000l);
		gateway.setRequestPayloadTypeClass(AgreementRequestWrapper.class);
		gateway.setRequestChannel(channelConfiguration.kairosHttpChannel());
		gateway.setReplyChannel(gatewayResponse());

		return gateway;
	}



	@Bean
	public MessageChannel gatewayResponse() {
		return new DirectChannel();
	}


	/**
	 * Proposito, Service Activator executar chamada Rest para API - Enroll Kairos (adicionar imagem a uma galeria especifica).
	 * TODO: verificar configuracao de timeout do HttpRequest Factory (tratamento da mensagem de erro em caso de timeout).
	 * TODO: verificar possibilidade de passar por parametro do bean na construcao do fluxo
	 * (deve ficar no mesmo arquivo de criacao do bean(Escopo "prototype").
	 * @return
	 */
	@Bean
	public HttpRequestExecutingMessageHandler httpEnrollHandlerKairos() {
		HttpRequestExecutingMessageHandler handler =  new HttpRequestExecutingMessageHandler(PARSER.parseExpression("headers.url"));
		handler.setOutputChannel(gatewayResponse());
		handler.setExpectReply(true);
		handler.setMessageConverters(httpMessageConverters);
		handler.setHttpMethod(HttpMethod.POST);
		handler.setExpectedResponseType(BaseResponse.class);
		handler.setHeaderMapper(defaultHeaderMapper);
		return handler;
	}


	private final static SpelExpressionParser PARSER = new SpelExpressionParser();
	@Bean
	public HttpRequestExecutingMessageHandler httpHandlerRecognizeKairos() {

		HttpRequestExecutingMessageHandler handler =  new HttpRequestExecutingMessageHandler(PARSER.parseExpression("headers.url"));

		handler.setOutputChannel(gatewayResponse());
		handler.setExpectReply(true);
		handler.setMessageConverters(httpMessageConverters);
		handler.setHttpMethod(HttpMethod.POST);
		handler.setExpectedResponseType(BaseResponse.class); 
		handler.setHeaderMapper(defaultHeaderMapper);
		return handler;
	}
	
	@Bean
	public HttpRequestExecutingMessageHandler httpHandlerVerifyKairos() {  
		HttpRequestExecutingMessageHandler handler =  new HttpRequestExecutingMessageHandler(PARSER.parseExpression("headers.url"));
		handler.setOutputChannel(gatewayResponse());
		handler.setExpectReply(true);
		handler.setMessageConverters(httpMessageConverters);
		handler.setHttpMethod(HttpMethod.POST);
		handler.setExpectedResponseType(BaseResponse.class); 
		handler.setHeaderMapper(defaultHeaderMapper);
		return handler;
	}


	@Autowired
	@Qualifier("errorChannel")
	private PublishSubscribeChannel errorChannel;

	@Autowired
	private KairosBaseService kairosBaseService;

	@Bean
	public IntegrationFlow kairosFlow() {
		return IntegrationFlows
				.from(channelConfiguration.kairosHttpChannel())
				.enrichHeaders(m -> m.headerExpressions(h -> h.put("transaction", "payload.transaction")))
				.enrichHeaders(m -> m.headerExpressions(h -> h.put("idAgreement", "payload.agreement.id")))
				.<AgreementRequestWrapper, String> route(p -> p.getService(),
						m -> m.channelMapping  ("ENROLL", "enrollChannel").
							   channelMapping  ("VERIFY", "verifyChannel").
							   channelMapping  ("RECOGNIZE", "recognizeChannel"))
				.get();
	}

	@Bean
	public IntegrationFlow verifyFlow() {
		return IntegrationFlows.from("verifyChannel")
				.<AgreementRequestWrapper , VerifyRequest>transform(p -> transformAgreementVerifyRequest(p))
				.enrichHeaders(m -> m.headerExpressions(h -> h.put("url", "payload.url")))
				.transform(Transformers.toJson())
				.headerFilter(httpRequestHeaderFilters())
				.enrichHeaders(m -> m.header(APP_ID, kairosProperties.getAppId()))
				.enrichHeaders(m -> m.header(APP_KEY, kairosProperties.getAppKey()))
				.handle(httpHandlerVerifyKairos())
				.handle(this.kairosBaseService, "formatResponse")
				.get();
	}


	@Bean
	public IntegrationFlow kairosEnrollFlow() {
		return IntegrationFlows
				.from("enrollChannel")
				.<AgreementRequestWrapper , EnrollRequest>transform(p -> transformJsonMessageEnrollRequest(p))
				.enrichHeaders(m -> m.headerExpressions(h -> h.put("url", "payload.url")))
				.transform(Transformers.toJson())
				.headerFilter(httpRequestHeaderFilters())
				.enrichHeaders(m -> m.header(APP_ID, kairosProperties.getAppId()))
				.enrichHeaders(m -> m.header(APP_KEY, kairosProperties.getAppKey()))
				.handle(httpEnrollHandlerKairos())
				.handle(this.kairosBaseService, "formatResponse")
				.get();
	}

	@Bean
	public MessageChannel formatResponseChannel() {
		return new DirectChannel();
	}


	/**
	 * Fluxo de requisicao regra recognize Kairos.
	 * @return
	 */
	@Bean
	public IntegrationFlow kairosRecognizeFlow() {
		return IntegrationFlows
				.from("recognizeChannel")
				.<AgreementRequestWrapper , RecognizeRequest>transform(p -> transformAgreementRecognizeRequest(p))
				.enrichHeaders(m -> m.headerExpressions(h -> h.put("url", "payload.url")))
				.transform(Transformers.toJson())
				.headerFilter(httpRequestHeaderFilters())
				.enrichHeaders(m -> m.header(APP_ID, kairosProperties.getAppId()))
				.enrichHeaders(m -> m.header(APP_KEY, kairosProperties.getAppKey()))
				.handle(httpHandlerRecognizeKairos())
				.handle(this.kairosBaseService, "formatResponse")
				.get();
	}


	@Transformer
	public EnrollRequest transformJsonMessageEnrollRequest(final AgreementRequestWrapper message) {
		EnrollRequest enrollRequest = new EnrollRequest();
		enrollRequest.setImage(message.getImage());
		enrollRequest.setGalleryName(message.getAgreement().getGallery());
		String subjectId = new StringBuilder().append(message.getDocument(message.getAgreement().getDocumentType()).getDocument()).append(KAIROS_WILDCARD).append(message.getAgreement().getDocumentType()).toString();
		enrollRequest.setUrl(message.getAgreement().getServiceUrl(ConveniadasHeaderValueEnum.ENROLL));
		enrollRequest.setSubjectId(subjectId);
		return enrollRequest;
	}


	public RecognizeRequest transformAgreementRecognizeRequest(AgreementRequestWrapper agreement) {
		RecognizeRequest recognizeRequest = new RecognizeRequest();
		recognizeRequest.setImage(agreement.getImage());
		recognizeRequest.setUrl(agreement.getAgreement().getServiceUrl(ConveniadasHeaderValueEnum.RECOGNIZE));
		recognizeRequest.setGallery(agreement.getAgreement().getGallery());
		return recognizeRequest;
	}


	public VerifyRequest transformAgreementVerifyRequest(final AgreementRequestWrapper agreementRequest) {
		VerifyRequest verifyRequest = new VerifyRequest();
		verifyRequest.setImage(agreementRequest.getImage());
		verifyRequest.setUrl(agreementRequest.getAgreement().getServiceUrl(ConveniadasHeaderValueEnum.VERIFY));
		String subjectId = new StringBuilder().append(agreementRequest.getDocument("CPF").getDocument()).append(KAIROS_WILDCARD).append(agreementRequest.getAgreement().getDocumentType()).toString();
		verifyRequest.setSubjectId(subjectId);
		verifyRequest.setGalleryName(agreementRequest.getAgreement().getGallery());
		return verifyRequest;
	}

	@Bean
	public String[] httpRequestHeaderFilters() {
		return new String[] {"accept-encoding","user-agent","http_requestMethod","http_requestUrl"};
	}

}
