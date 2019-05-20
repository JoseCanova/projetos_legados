package br.com.valid.bio.conveniadas.model.response.v2;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Candidate {

    @JsonProperty("confidence")
    private Float confidence;
    @JsonProperty("enrollment_timestamp")
    private String enrollmentTimestamp;
    @JsonProperty("face_id")
    private String faceId;
    @JsonProperty("subject_id")
    private String subjectId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("confidence")
    public Float getConfidence() {
        return confidence;
    }

    @JsonProperty("confidence")
    public void setConfidence(Float confidence) {
        this.confidence = confidence;
    }

    @JsonProperty("enrollment_timestamp")
    public String getEnrollmentTimestamp() {
        return enrollmentTimestamp;
    }

    @JsonProperty("enrollment_timestamp")
    public void setEnrollmentTimestamp(String enrollmentTimestamp) {
        this.enrollmentTimestamp = enrollmentTimestamp;
    }

    @JsonProperty("face_id")
    public String getFaceId() {
        return faceId;
    }

    @JsonProperty("face_id")
    public void setFaceId(String faceId) {
        this.faceId = faceId;
    }

    @JsonProperty("subject_id")
    public String getSubjectId() {
        return subjectId;
    }

    @JsonProperty("subject_id")
    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
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
