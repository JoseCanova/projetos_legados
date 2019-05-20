package br.com.valid.bio.conveniadas.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.valid.bio.conveniadas.model.agreement.Agreement;
import br.com.valid.bio.conveniadas.model.person.PersonData;

@Document(collection="Agreements")
@JsonIgnoreProperties(ignoreUnknown=true)
public class AgreementRequest extends RequestBase {

	@Id
	private String mongoId;
	
	private String id; 
	
	private String jsonMessageId; 
	
	private String eventId;
	
	private String document;
	
	private String endPoint;
	
	private String method;
	
	private String imageBase;
	
	private String imageMd5;
	
	private Agreement agreement; 
	
	private PersonData personData;
	
	private String serviceName;
	
	private Integer transactionId;
	
	private Long waitTimeout;
	
	private String imageKey;
	
	private Long listSize; 
	
	private Float threshold;
	
	private String referenceImageToken;
	
	private String transactionKey; 
	
	@JsonProperty("gallery")
	private List<String> subjectTags = new ArrayList<>();

	private ErrorMessage errorMessage;
	
	private Long transactionStartTime;
	
	@JsonProperty("face_id")
	private String faceId;

	@JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	public AgreementRequest() {}

	public String getMongoId() {
		return mongoId;
	}

	public void setMongoId(String mongoId) {
		this.mongoId = mongoId;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJsonMessageId() {
		return jsonMessageId;
	}

	public void setJsonMessageId(String jsonMessageId) {
		this.jsonMessageId = jsonMessageId;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public Agreement getAgreement() {
		return agreement;
	}

	public void setAgreement(Agreement agreement) {
		this.agreement = agreement;
	}

	public PersonData getPersonData() {
		return personData;
	}

	public void setPersonData(PersonData personData) {
		this.personData = personData;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getImageBase() {
		return imageBase;
	}

	public void setImageBase(String imageBase) {
		this.imageBase = imageBase;
	}

	public String getImageMd5() {
		return imageMd5;
	}

	public void setImageMd5(String imageMd5) {
		this.imageMd5 = imageMd5;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Long getWaitTimeout() {
		return waitTimeout;
	}

	public void setWaitTimeout(Long waitTimeout) {
		this.waitTimeout = waitTimeout;
	}

	public String getImageKey() {
		return imageKey;
	}

	public void setImageKey(String imageKey) {
		this.imageKey = imageKey;
	}

	@JsonIgnore
	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonIgnore
	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public Long getListSize() {
		return listSize;
	}

	public void setListSize(Long listSize) {
		this.listSize = listSize;
	}

	public Float getThreshold() {
		return threshold;
	}

	public void setThreshold(Float threshold) {
		this.threshold = threshold;
	}

	public List<String> getSubjectTags() {
		return subjectTags;
	}

	public void setSubjectTags(List<String> subjectTags) {
		this.subjectTags = subjectTags;
	}

	public String getReferenceImageToken() {
		return referenceImageToken;
	}

	public void setReferenceImageToken(String referenceImageToken) {
		this.referenceImageToken = referenceImageToken;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getTransactionKey() {
		return transactionKey;
	}

	public void setTransactionKey(String transactionKey) {
		this.transactionKey = transactionKey;
	}

	public Long getTransactionStartTime() {
		return transactionStartTime;
	}

	public void setTransactionStartTime(Long transactionStartTime) {
		this.transactionStartTime = transactionStartTime;
	}

	public String getFaceId() {
		return faceId;
	}

	public void setFaceId(String faceId) {
		this.faceId = faceId;
	}

	@Override
	public String toString() {
		return "AgreementRequest [mongoId=" + mongoId + ", id=" + id + ", jsonMessageId=" + jsonMessageId + ", eventId="
				+ eventId + ", document=" + document + ", endPoint=" + endPoint + ", method=" + method + ", imageBase="
				+ imageBase + ", imageMd5=" + imageMd5 + ", agreement=" + agreement + ", personData=" + personData
				+ ", serviceName=" + serviceName + ", transactionId=" + transactionId + ", waitTimeout=" + waitTimeout
				+ ", imageKey=" + imageKey + ", listSize=" + listSize + ", threshold=" + threshold
				+ ", referenceImageToken=" + referenceImageToken + ", transactionKey=" + transactionKey
				+ ", subjectTags=" + subjectTags + ", errorMessage=" + errorMessage + ", transactionStartTime="
				+ transactionStartTime + ", faceId=" + faceId + ", additionalProperties=" + additionalProperties + "]";
	}

}
