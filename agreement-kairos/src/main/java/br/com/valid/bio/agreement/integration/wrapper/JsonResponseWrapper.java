package br.com.valid.bio.agreement.integration.wrapper;

import br.com.valid.bio.agreement.model.partner.kairos.BaseResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;


/**
 * @author rodrigo.msilva
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonResponseWrapper {
    private String id;
    private Long transaction;
    private Long eventId;
    private BaseResponse responseData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getTransaction() {
        return transaction;
    }

    public void setTransaction(Long transaction) {
        this.transaction = transaction;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public BaseResponse getResponseData() {
        return responseData;
    }

    public void setResponseData(BaseResponse responseData) {
        this.responseData = responseData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonResponseWrapper that = (JsonResponseWrapper) o;
        return Objects.equals(transaction, that.transaction) &&
                Objects.equals(eventId, that.eventId) &&
                Objects.equals(responseData, that.responseData);
    }

    @Override
    public int hashCode() {

        return Objects.hash(transaction, eventId, responseData);
    }


}
