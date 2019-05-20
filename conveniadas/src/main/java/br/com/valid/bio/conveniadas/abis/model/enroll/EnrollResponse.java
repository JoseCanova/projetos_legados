package br.com.valid.bio.conveniadas.abis.model.enroll;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.valid.bio.conveniadas.abis.model.TransactionStateEnum;
import br.com.valid.bio.conveniadas.model.StateHistory;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollResponse {

	@JsonProperty("transactionKey")
	private String transactionKey;
	@JsonProperty("receivedAt")
	private String receivedAt;
	@JsonProperty("updatedAt")
	private String updatedAt;
	@JsonProperty("transactionState")
	private TransactionStateEnum transactionState;
	@JsonProperty("stateReason")
	private String stateReason;
	@JsonProperty("stateHistory")
	@Valid
	private List<StateHistory> stateHistory = null;
	@JsonProperty("subjectExisted")
	private Boolean subjectExisted;
	@JsonProperty("subjectKey")
	private String subjectKey;
	@JsonProperty("imageKey")
	private String imageKey;
	@JsonProperty("imageType")
	private String imageType;
	@JsonProperty("imageData")
	private String imageData;
	@JsonProperty("imageHash")
	private String imageHash;
	@JsonProperty("imageBehavior")
	private String imageBehavior;
	@JsonProperty("data")
	@Valid
	private Data data;
	
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public EnrollResponse() {}
	
	@JsonProperty("transactionKey")
	public String getTransactionKey() {
		return transactionKey;
	}

	@JsonProperty("transactionKey")
	public void setTransactionKey(String transactionKey) {
		this.transactionKey = transactionKey;
	}

	@JsonProperty("receivedAt")
	public String getReceivedAt() {
		return receivedAt;
	}

	@JsonProperty("receivedAt")
	public void setReceivedAt(String receivedAt) {
		this.receivedAt = receivedAt;
	}

	@JsonProperty("updatedAt")
	public String getUpdatedAt() {
		return updatedAt;
	}

	@JsonProperty("updatedAt")
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	@JsonProperty("transactionState")
	public TransactionStateEnum getTransactionState() {
		return transactionState;
	}

	@JsonProperty("transactionState")
	public void setTransactionState(TransactionStateEnum transactionState) {
		this.transactionState = transactionState;
	}

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

	@JsonProperty("subjectExisted")
	public Boolean getSubjectExisted() {
		return subjectExisted;
	}

	@JsonProperty("subjectExisted")
	public void setSubjectExisted(Boolean subjectExisted) {
		this.subjectExisted = subjectExisted;
	}

	@JsonProperty("subjectKey")
	public String getSubjectKey() {
		return subjectKey;
	}

	@JsonProperty("subjectKey")
	public void setSubjectKey(String subjectKey) {
		this.subjectKey = subjectKey;
	}

	@JsonProperty("imageKey")
	public String getImageKey() {
		return imageKey;
	}

	@JsonProperty("imageKey")
	public void setImageKey(String imageKey) {
		this.imageKey = imageKey;
	}

	@JsonProperty("imageType")
	public String getImageType() {
		return imageType;
	}

	@JsonProperty("imageType")
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	@JsonProperty("imageData")
	public String getImageData() {
		return imageData;
	}

	@JsonProperty("imageData")
	public void setImageData(String imageData) {
		this.imageData = imageData;
	}

	@JsonProperty("imageHash")
	public String getImageHash() {
		return imageHash;
	}

	@JsonProperty("imageHash")
	public void setImageHash(String imageHash) {
		this.imageHash = imageHash;
	}

	@JsonProperty("imageBehavior")
	public String getImageBehavior() {
		return imageBehavior;
	}

	@JsonProperty("imageBehavior")
	public void setImageBehavior(String imageBehavior) {
		this.imageBehavior = imageBehavior;
	}

	@JsonProperty("data")
	public Data getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(Data data) {
		this.data = data;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		return "EnrollResponse [transactionKey=" + transactionKey + ", receivedAt=" + receivedAt + ", updatedAt="
				+ updatedAt + ", transactionState=" + transactionState + ", stateReason=" + stateReason
				+ ", stateHistory=" + stateHistory + ", subjectExisted=" + subjectExisted + ", subjectKey=" + subjectKey
				+ ", imageKey=" + imageKey + ", imageType=" + imageType + ", imageData=" + imageData + ", imageHash="
				+ imageHash + ", imageBehavior=" + imageBehavior + ", data=" + data + ", additionalProperties="
				+ additionalProperties + "]";
	}
}

