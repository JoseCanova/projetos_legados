
package br.com.valid.bio.agreement.model.rule;

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
public class WebServiceInfo {

    @JsonProperty("type")
    private String type;
    @JsonProperty("endpoint")
    private String endpoint;
    @JsonProperty("timeout")
    private Long timeout;
    @JsonProperty("numberOfAttempts")
    private Long numberOfAttempts;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("endpoint")
    public String getEndpoint() {
        return endpoint;
    }

    @JsonProperty("endpoint")
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    @JsonProperty("timeout")
    public Long getTimeout() {
        return timeout;
    }

    @JsonProperty("timeout")
    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }

    @JsonProperty("numberOfAttempts")
    public Long getNumberOfAttempts() {
        return numberOfAttempts;
    }

    @JsonProperty("numberOfAttempts")
    public void setNumberOfAttempts(Long numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
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
