package br.com.valid.bio.agreement.model.rule;

import br.com.valid.bio.agreement.exception.ErrorMessage;
import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RuleMessage {

	private int status; 
	
	private String message; 
	
	private RuleRequest rule;
	
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

	@Override
	public String toString() {
		return "RuleMessage [status=" + status + ", message=" + message + ", rule=" + rule + ", personResponse="
				+ ", errorMessage=" + errorMessage + ", additionalProperties=" + additionalProperties
				+ "]";
	}
	
}
