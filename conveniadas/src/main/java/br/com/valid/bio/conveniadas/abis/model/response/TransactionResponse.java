package br.com.valid.bio.conveniadas.abis.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.valid.bio.conveniadas.abis.model.TransactionStateEnum;

public class TransactionResponse extends AbstractResponse {
	
	@JsonProperty("transactionKey")
	protected String transactionKey;
	
	@JsonProperty("receivedAt")
	protected String receivedAt;
	
	@JsonProperty("updatedAt")
	protected String updatedAt;
	
	@JsonProperty("transactionState")
	protected TransactionStateEnum transactionState;

	public TransactionResponse() {}
	
	
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
}
