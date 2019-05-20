package br.com.valid.bio.abis.model.rule;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.valid.bio.abis.model.ErrorMessage;
import br.com.valid.bio.model.abis.biographic.PersonResponse;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RuleMessage {

	private int status; 
	
	private String message; 
	
	private RuleRequest rule;
	
	private PersonResponse personResponse; 
	
	private ErrorMessage errorMessage;
	
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	public RuleMessage() {
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public RuleRequest getRule() {
		return rule;
	}

	public void setRule(RuleRequest rule) {
		this.rule = rule;
	}

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	public PersonResponse getPersonResponse() {
		return personResponse;
	}

	public void setPersonResponse(PersonResponse personResponse) {
		this.personResponse = personResponse;
	}

	public void setErrorMessage(ErrorMessage errorM) {
		this.errorMessage = errorM;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	@Override
	public String toString() {
		return "RuleMessage [status=" + status + ", message=" + message + ", rule=" + rule + ", personResponse="
				+ personResponse + ", errorMessage=" + errorMessage + ", additionalProperties=" + additionalProperties
				+ "]";
	}
	
}
