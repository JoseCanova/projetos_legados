package br.com.valid.bio.conveniadas.model.response;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgreementResponse {

    @JsonProperty("id")
    private String id;
    @JsonProperty("transaction")
    private Integer transaction;
    @JsonProperty("eventId")
    private Object eventId;
    @JsonProperty("personData")
    private PersonData personData;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public AgreementResponse() {}
    
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("transaction")
    public Integer getTransaction() {
        return transaction;
    }

    @JsonProperty("transaction")
    public void setTransaction(Integer transaction) {
        this.transaction = transaction;
    }

    @JsonProperty("eventId")
    public Object getEventId() {
        return eventId;
    }

    @JsonProperty("eventId")
    public void setEventId(Object eventId) {
        this.eventId = eventId;
    }

    @JsonProperty("personData")
    public PersonData getPersonData() {
        return personData;
    }

    @JsonProperty("personData")
    public void setPersonData(PersonData personData) {
        this.personData = personData;
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
