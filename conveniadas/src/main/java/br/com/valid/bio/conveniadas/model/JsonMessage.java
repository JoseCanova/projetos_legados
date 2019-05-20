package br.com.valid.bio.conveniadas.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonMessage implements Base<String>{
	
	@Id
	@JsonProperty("mongoDocumentId")
	private String id;
	
	@JsonProperty(value="id")
	private String idMessage; 
	
	private Long transaction; 
	
	private String document;

	@JsonProperty(value="birthDate")
	private String birthDate;
	
	private Long eventId;
	
	private String image;
	
	private RuleRequest data;
	
	private String gallery; 
	
	@JsonProperty("callbackUrl")
	private String callbackUrl;
	
	@JsonProperty("service")
	private String service; 
	
	@JsonProperty("imageMd5")
	private String imageMd5;
	
	@JsonProperty(value="docType")
	private String documentType;
	
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	public JsonMessage() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(String idMessage) {
		this.idMessage = idMessage;
	}

	public Long getTransaction() {
		return transaction;
	}

	public void setTransaction(Long transaction) {
		this.transaction = transaction;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGallery() {
		return gallery;
	}

	public void setGallery(String gallery) {
		this.gallery = gallery;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getImageMd5() {
		return imageMd5;
	}

	public void setImageMd5(String imageMd5) {
		this.imageMd5 = imageMd5;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JsonMessage [id=");
		builder.append(id);
		builder.append(", idMessage=");
		builder.append(idMessage);
		builder.append(", transaction=");
		builder.append(transaction);
		builder.append(", document=");
		builder.append(document);
		builder.append(", birthDate=");
		builder.append(birthDate);
		builder.append(", eventId=");
		builder.append(eventId);
		builder.append(", image=");
		builder.append(image);
		builder.append(", data=");
		builder.append(data);
		builder.append(", gallery=");
		builder.append(gallery);
		builder.append(", callbackUrl=");
		builder.append(callbackUrl);
		builder.append(", service=");
		builder.append(service);
		builder.append(", imageMd5=");
		builder.append(imageMd5);
		builder.append(", documentType=");
		builder.append(documentType);
		builder.append("]");
		return builder.toString();
	}

	public RuleRequest getData() {
		return data;
	}

	public void setData(RuleRequest data) {
		this.data = data;
	}

}
