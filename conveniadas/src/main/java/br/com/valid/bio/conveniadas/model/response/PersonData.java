package br.com.valid.bio.conveniadas.model.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonData {

    @JsonProperty("typeClass")
    private String typeClass;
    @JsonProperty("face_id")
    private String faceId;
    @JsonProperty("Errors")
    private Errors errors;
    @JsonProperty("images")
    private List<Image> images = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public PersonData() {}
    
    @JsonProperty("typeClass")
    public String getTypeClass() {
        return typeClass;
    }

    @JsonProperty("typeClass")
    public void setTypeClass(String typeClass) {
        this.typeClass = typeClass;
    }

    @JsonProperty("face_id")
    public String getFaceId() {
        return faceId;
    }

    @JsonProperty("face_id")
    public void setFaceId(String faceId) {
        this.faceId = faceId;
    }

    @JsonProperty("Errors")
    public Errors getErrors() {
        return errors;
    }

    @JsonProperty("Errors")
    public void setErrors(Errors errors) {
        this.errors = errors;
    }

    @JsonProperty("images")
    public List<Image> getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(List<Image> images) {
        this.images = images;
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
