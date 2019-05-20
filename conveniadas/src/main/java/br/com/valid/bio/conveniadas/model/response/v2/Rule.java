package br.com.valid.bio.conveniadas.model.response.v2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @deprecated
 * @author jose.canova
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Rule {

    @JsonProperty("id")
    private Id id;
    @JsonProperty("agreements")
    private List<AgreementResult> agreements = new ArrayList<>();
    @JsonProperty("biometricServices")
    private List<Object> biometricServices = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Id getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Id id) {
        this.id = id;
    }

    @JsonProperty("agreements")
    public List<AgreementResult> getAgreements() {
        return agreements;
    }

    @JsonProperty("agreements")
    public void setAgreements(List<AgreementResult> agreements) {
        this.agreements = agreements;
    }

    @JsonProperty("biometricServices")
    public List<Object> getBiometricServices() {
        return biometricServices;
    }

    @JsonProperty("biometricServices")
    public void setBiometricServices(List<Object> biometricServices) {
        this.biometricServices = biometricServices;
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
