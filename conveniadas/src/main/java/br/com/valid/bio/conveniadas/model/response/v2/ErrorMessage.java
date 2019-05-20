package br.com.valid.bio.conveniadas.model.response.v2;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {

    @JsonProperty("ErrCode")
    private Integer errCode;
    @JsonProperty("Message")
    private String message;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public ErrorMessage() {}
    
    
    public ErrorMessage(Integer errCode, String message) {
		super();
		this.errCode = errCode;
		this.message = message;
	}

	@JsonProperty("ErrCode")
    public Integer getErrCode() {
        return errCode;
    }

    @JsonProperty("ErrCode")
    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    @JsonProperty("Message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("Message")
    public void setMessage(String message) {
        this.message = message;
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
