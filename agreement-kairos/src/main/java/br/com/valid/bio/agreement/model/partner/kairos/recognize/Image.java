package br.com.valid.bio.agreement.model.partner.kairos.recognize;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Image {

	private Transaction transaction; 
	
	private List<Candidate> candidates;
	
	public Image() {}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Image [transaction=");
		builder.append(transaction);
		builder.append(", candidates=");
		builder.append(candidates);
		builder.append("]");
		return builder.toString();
	} 
	
}
