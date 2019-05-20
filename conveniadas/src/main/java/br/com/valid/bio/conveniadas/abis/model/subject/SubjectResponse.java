package br.com.valid.bio.conveniadas.abis.model.subject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.valid.bio.conveniadas.abis.model.response.AbstractResponse;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubjectResponse extends AbstractResponse {

	public static final String TAGS = "tags"; 
	public static final String FINGERPRINTS = "fingerprints";
	public static final String FACES = "faces";
	
    @JsonProperty("key")
    private String key;
    @JsonProperty("faces")
    private List<Face> faces = null;
    @JsonProperty("fingerprints")
    private List<Fingerprint> fingerprints = null;
    @JsonProperty("tags")
    private List<String> tags = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    @JsonProperty("faces")
    public List<Face> getFaces() {
        return faces;
    }

    @JsonProperty("faces")
    public void setFaces(List<Face> faces) {
        this.faces = faces;
    }

    @JsonProperty("fingerprints")
    public List<Fingerprint> getFingerprints() {
        return fingerprints;
    }

    @JsonProperty("fingerprints")
    public void setFingerprints(List<Fingerprint> fingerprints) {
        this.fingerprints = fingerprints;
    }

    @JsonProperty("tags")
    public List<String> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
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
