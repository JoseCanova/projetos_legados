package br.com.valid.bio.conveniadas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.valid.bio.conveniadas.model.agreement.Agreement;
import br.com.valid.bio.conveniadas.model.person.PersonData;

/**
 * @deprecated
 * @author jose.canova
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class AgreementResponse extends BaseResponse implements Base<String> {

	private String id; 
	
	private String jsonMessageId; 
	
	private String eventId;
	
	private String document;
	
	private String gallery;
	
	private String endPoint;
	
	private Agreement agreement; 
	
	private PersonData personData;
	
	public AgreementResponse() {}

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

	public String getGallery() {
		return gallery;
	}

	public void setGallery(String gallery) {
		this.gallery = gallery;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AgreementRequest [id=");
		builder.append(id);
		builder.append(", jsonMessageId=");
		builder.append(jsonMessageId);
		builder.append(", eventId=");
		builder.append(eventId);
		builder.append(", document=");
		builder.append(document);
		builder.append(", gallery=");
		builder.append(gallery);
		builder.append(", endPoint=");
		builder.append(endPoint);
		builder.append(", agreement=");
		builder.append(agreement);
		builder.append(", personData=");
		builder.append(personData);
		builder.append("]");
		return builder.toString();
	}
	
}
