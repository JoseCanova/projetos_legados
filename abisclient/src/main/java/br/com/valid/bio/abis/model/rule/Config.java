
package br.com.valid.bio.abis.model.rule;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Config {

    @JsonProperty("operation")
    private String operation;
    @JsonProperty("biometricType")
    private String biometricType;
    @JsonProperty("minimalImageQuality")
    private MinimalImageQuality minimalImageQuality;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("operation")
    public String getOperation() {
        return operation;
    }

    @JsonProperty("operation")
    public void setOperation(String operation) {
        this.operation = operation;
    }

    @JsonProperty("biometricType")
    public String getBiometricType() {
        return biometricType;
    }

    @JsonProperty("biometricType")
    public void setBiometricType(String biometricType) {
        this.biometricType = biometricType;
    }

    @JsonProperty("minimalImageQuality")
    public MinimalImageQuality getMinimalImageQuality() {
        return minimalImageQuality;
    }

    @JsonProperty("minimalImageQuality")
    public void setMinimalImageQuality(MinimalImageQuality minimalImageQuality) {
        this.minimalImageQuality = minimalImageQuality;
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
