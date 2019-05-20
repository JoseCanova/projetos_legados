package br.com.valid.bio.agreement.model.partner.kairos.recognize;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Candidate {

	@JsonAlias("subject_id")
	@JsonProperty("subject_id")
	private String subjectId; 

	private int confidence;
	
	@JsonProperty("enrollment_timestamp")
	@JsonAlias("enrollment_timestamp")
	private long enrollmentTimestamp;
	
	public Candidate() {}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public int getConfidence() {
		return confidence;
	}

	public void setConfidence(int confidence) {
		this.confidence = confidence;
	}

	public long getEnrollmentTimestamp() {
		return enrollmentTimestamp;
	}

	public void setEnrollmentTimestamp(long enrollmentTimestamp) {
		this.enrollmentTimestamp = enrollmentTimestamp;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Candidate [subjectId=");
		builder.append(subjectId);
		builder.append(", confidence=");
		builder.append(confidence);
		builder.append(", enrollmentTimestamp=");
		builder.append(enrollmentTimestamp);
		builder.append("]");
		return builder.toString();
	}
	
}
