
package br.com.valid.bio.agreement.model.rule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RuleRequest {

    @JsonProperty("id")
    private Id id;
    @JsonProperty("agreements")
    private List<Agreement> agreements = null;
    @JsonProperty("biometricServices")
    private List<BiometricService> biometricServices = null;
    @JsonProperty("config")
    private Config config;
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
    public List<Agreement> getAgreements() {
        return agreements;
    }

    @JsonProperty("agreements")
    public void setAgreements(List<Agreement> agreements) {
        this.agreements = agreements;
    }

    @JsonProperty("biometricServices")
    public List<BiometricService> getBiometricServices() {
        return biometricServices;
    }

    @JsonProperty("biometricServices")
    public void setBiometricServices(List<BiometricService> biometricServices) {
        this.biometricServices = biometricServices;
    }

    @JsonProperty("config")
    public Config getConfig() {
        return config;
    }

    @JsonProperty("config")
    public void setConfig(Config config) {
        this.config = config;
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
		return "RuleRequest [id=" + id + ", agreements=" + agreements + ", biometricServices=" + biometricServices
				+ ", config=" + config + ", additionalProperties=" + additionalProperties + "]";
	}

}
