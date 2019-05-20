package br.com.valid.bio.conveniadas.model;


import java.util.HashMap;
import java.util.Map;

import org.springframework.messaging.support.ErrorMessage;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.valid.bio.conveniadas.model.person.PersonData;

/**
 * @author jose.canova
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RuleMessage {

	private int status; 
	
	private String message; 
	
	private RuleRequest rule;
	
	@JsonProperty("personResponse")
	private PersonData personData; 
	
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

	public void setErrorMessage(ErrorMessage errorM) {
		this.errorMessage = errorM;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public PersonData getPersonData() {
		return personData;
	}

	public void setPersonData(PersonData personData) {
		this.personData = personData;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RuleMessage [status=");
		builder.append(status);
		builder.append(", message=");
		builder.append(message);
		builder.append(", rule=");
		builder.append(rule);
		builder.append(", personData=");
		builder.append(personData);
		builder.append(", errorMessage=");
		builder.append(errorMessage);
		builder.append("]");
		return builder.toString();
	}

}
