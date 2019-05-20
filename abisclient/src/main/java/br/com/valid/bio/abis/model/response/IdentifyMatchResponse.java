package br.com.valid.bio.abis.model.response;

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

import br.com.valid.bio.abis.model.StateHistory;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IdentifyMatchResponse {

	@JsonProperty("transactionKey")
	private String transactionKey;
	@JsonProperty("receivedAt")
	private String receivedAt;
	@JsonProperty("updatedAt")
	private String updatedAt;
	@JsonProperty("transactionState")
	private String transactionState;
	@JsonProperty("stateReason")
	private String stateReason;
	@JsonProperty("stateHistory")
	@Valid
	private List<StateHistory> stateHistory = null;
	@JsonProperty("matches")
	@Valid
	private List<Match> matches = null;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
	public String getTransactionState() {
		return transactionState;
	}

	@JsonProperty("transactionState")
	public void setTransactionState(String transactionState) {
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

}

