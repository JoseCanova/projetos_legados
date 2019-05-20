
package br.com.valid.bio.conveniadas.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.valid.bio.conveniadas.model.agreement.Agreement;
import br.com.valid.bio.conveniadas.model.agreement.Id;
import br.com.valid.bio.conveniadas.model.person.PersonData;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RuleRequest {

    @JsonProperty("id")
    private Id id;
    @JsonProperty("agreements")
    private List<Agreement> agreements = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("personResponse")
	private PersonData personData; 
    
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


    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
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
		builder.append("RuleRequest [id=");
		builder.append(id);
		builder.append(", agreements=");
		builder.append(agreements);
		builder.append(", personData=");
		builder.append(personData);
		builder.append("]");
		return builder.toString();
	}

}
