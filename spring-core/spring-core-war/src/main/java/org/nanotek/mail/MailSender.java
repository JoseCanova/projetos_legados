package org.nanotek.mail;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


/**
 * Classe respons�vel pelo envio de e-mails para usu�rios e 
 * grupos de usu�rios
 * @author Luis Filipe Benedy de Sousa
 * @date 04/12/2009
 * @version 1.0
 */
public class MailSender {

	private final String REMETENTE	= "saog@prodesp.sp.gov.br";

	public final void sendMail(List<String> destinatarioList, String subject, String body) throws EndPointException {

		Session mailSession			= null;
		Context initCtx				= null;
		MimeMessage message			= null;
		InternetAddress addressFrom = null;
		InternetAddress[] addressTo	= null;

		if( 0 == destinatarioList.size() ){
			throw new EndPointException( 
					"Nenhum destinat�rio de email foi informado");
		}

		try{
			initCtx = new InitialContext();
			mailSession = (javax.mail.Session)initCtx.lookup("java:jboss/mail/Default");

			//de
			/*addressFrom = new InternetAddress(this.REMETENTE);*/
			addressFrom = new InternetAddress("jose.carlos.canova@gmail.com");
			message = new MimeMessage(mailSession);
			message.setFrom( addressFrom );

			//para
			addressTo = new InternetAddress[ destinatarioList.size() ];			
			for (int i = 0; i < destinatarioList.size(); i++){
				addressTo[i] = new InternetAddress( destinatarioList.get(i) );
			}
			message.setRecipients(Message.RecipientType.TO, addressTo);

			message.setSentDate(new Date());

			message.setContent(body, "text/html; charset=UTF-8;");
			message.setSubject(MimeUtility.encodeText(subject, "utf-8", "B"));

			message.setHeader("Content-Type", "text/html; charset=UTF-8; format=flowed");

			Transport.send(message);

		}catch(NamingException exc){
			throw new EndPointException("Falha ao executar lookup contra o nome jndi de um session bean da aplica��o");
		}catch(AddressException exc){
			throw new EndPointException("Falha no envio de email" );
		}catch(MessagingException exc){
			throw new EndPointException("Falha no envio de email" );
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * M�todo respons�vel por enviar um e-mail para um destinat�rio
	 * @param String contendo o endere�o para onde o e-mail deve ser enviado
	 * @param String representando o assunto do e-mail
	 * @param String resprentando o conte�do do e-mail
	 * @throws EndPointException sempre que ocorrer uma falha no envio do e-mail 
	 */
	public final void sendMail(String destinatarioList, String subject, String body) throws EndPointException {		
		List<String> dest = new ArrayList<String>();

		dest.add(destinatarioList);
		sendMail(dest, subject, body);
	}

	public void sendMail(List<?> destinatarioList, String subject, String body,byte[] attachmentData) throws EndPointException {	
		Session mailSession			= null;
		Context initCtx				= null;
		MimeMessage message			= null;
		InternetAddress addressFrom = null;
		InternetAddress[] addressTo	= null;

		try {
			initCtx = new InitialContext();

			mailSession = (javax.mail.Session)initCtx.lookup("java:jboss/mail/Default");
			message = new MimeMessage(mailSession);
			//de
			/*addressFrom = new InternetAddress(this.REMETENTE);*/
			addressFrom = new InternetAddress("jose.carlos.canova@gmail.com");

			addressTo = new InternetAddress[ destinatarioList.size() ];			
			for (int i = 0; i < destinatarioList.size(); i++){
				addressTo[i] = new InternetAddress( (String) destinatarioList.get(i) );
			}
			message.setRecipients(Message.RecipientType.TO, addressTo);

			message.setSubject(MimeUtility.encodeText(subject, "utf-8", "B"));

			message.setHeader("Content-Type", "text/html; charset=UTF-8; format=flowed");
			
			message.setSentDate(new Date());
			
			Multipart mp = new MimeMultipart();

			MimeBodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent(body, "text/html");
			mp.addBodyPart(htmlPart);
			MimeBodyPart attachment = new MimeBodyPart();
			attachment.setFileName("relatorio.pdf");
			attachment.setContent(attachmentData, "application/pdf");
			mp.addBodyPart(attachment);

			message.setContent(mp);
			
			Transport.send(message);

		} catch (Exception e) {
			e.printStackTrace();
			throw new EndPointException(e);
		}
	}
}
