package br.com.valid.bio.conveniadas.abis.model.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.valid.bio.conveniadas.abis.model.enroll.Data;
import br.com.valid.bio.conveniadas.model.StateHistory;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse extends ImageResponse {

	@JsonProperty("stateReason")
	private String stateReason;
	
	@JsonProperty("stateHistory")
	@Valid
	private List<StateHistory> stateHistory = null;
	
	@JsonProperty("matches")
	@Valid
	private List<Match> matches = null;
	
	@JsonProperty("controlId")
	private String controlId;
	
	@JsonProperty("subjectExisted")
	private Boolean subjectExisted;
	
	@JsonProperty("subjectKey")
	private String subjectKey;
	
	@JsonProperty("score")
	private Float score;
	
	@JsonProperty("data")
	@Valid
	protected Data data;
	
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public BaseResponse() {}
	

	@JsonProperty("stateReason")
	public String getStateReason() {
		return stateReason;
	}

	@JsonProperty("stateReason")
	public void setStateReason(String stateReason) {
		this.stateReason = stateReason;
	}

	@JsonProperty("stateHistory")
	public List<StateHistory> getStateHistory() {
		return stateHistory;
	}

	@JsonProperty("stateHistory")
	public void setStateHistory(List<StateHistory> stateHistory) {
		this.stateHistory = stateHistory;
	}

	@JsonProperty("matches")
	public List<Match> getMatches() {
		return matches;
	}

	@JsonProperty("matches")
	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public String getControlId() {
		return controlId;
	}

	public void setControlId(String controlId) {
		this.controlId = controlId;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}

	public Boolean getSubjectExisted() {
		return subjectExisted;
	}

	public void setSubjectExisted(Boolean subjectExisted) {
		this.subjectExisted = subjectExisted;
	}

	public String getSubjectKey() {
		return subjectKey;
	}

	public void setSubjectKey(String subjectKey) {
		this.subjectKey = subjectKey;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "BaseResponse [transactionKey=" + transactionKey + ", receivedAt=" + receivedAt + ", updatedAt="
				+ updatedAt + ", transactionState=" + transactionState + ", stateReason=" + stateReason
				+ ", stateHistory=" + stateHistory + ", matches=" + matches + ", controlId=" + controlId
				+ ", errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", errorDetails=" + errorDetails
				+ ", subjectExisted=" + subjectExisted + ", subjectKey=" + subjectKey + ", imageKey=" + imageKey
				+ ", imageType=" + imageType + ", imageData=" + imageData + ", imageHash=" + imageHash
				+ ", imageBehavior=" + imageBehavior + ", score=" + score + ", data=" + data + ", additionalProperties="
				+ additionalProperties + "]";
	}
	
}

