package br.com.valid.bio.conveniadas.model.response.v2;

import java.util.HashMap;
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
public class AgreementResponse implements ResponseBase {

    @JsonProperty("transaction")
    private Integer transaction;
//    @JsonProperty("eventId")
//    private Integer eventId;
    @JsonProperty("url")
    private String url;
    @JsonProperty("callbackUrl")
    private String callbackUrl;
    @JsonProperty("contract")
    private String contract;
    @JsonProperty("product")
    private String product;
    @JsonProperty("service")
    private String service;
    @JsonProperty("data")
    private Data data;
    @JsonProperty("gallery")
    private String gallery;
    @JsonProperty("document")
    private String document;
    @JsonProperty("imageMd5")
    private String imageMd5;
    @JsonProperty("birthDate")
    private String birthDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("transaction")
    public Integer getTransaction() {
        return transaction;
    }

    @JsonProperty("transaction")
    public void setTransaction(Integer transaction) {
        this.transaction = transaction;
    }

//    @JsonProperty("eventId")
//    public Integer getEventId() {
//        return eventId;
//    }
//
//    @JsonProperty("eventId")
//    public void setEventId(Integer eventId) {
//        this.eventId = eventId;
//    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("callbackUrl")
    public String getCallbackUrl() {
        return callbackUrl;
    }

    @JsonProperty("callbackUrl")
    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    @JsonProperty("contract")
    public String getContract() {
        return contract;
    }

    @JsonProperty("contract")
    public void setContract(String contract) {
        this.contract = contract;
    }

    @JsonProperty("product")
    public String getProduct() {
        return product;
    }

    @JsonProperty("product")
    public void setProduct(String product) {
        this.product = product;
    }

    @JsonProperty("service")
    public String getService() {
        return service;
    }

    @JsonProperty("service")
    public void setService(String service) {
        this.service = service;
    }

    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data data) {
        this.data = data;
    }

    @JsonProperty("gallery")
    public String getGallery() {
        return gallery;
    }

    @JsonProperty("gallery")
    public void setGallery(String gallery) {
        this.gallery = gallery;
    }

    @JsonProperty("document")
    public String getDocument() {
        return document;
    }

    @JsonProperty("document")
    public void setDocument(String document) {
        this.document = document;
    }

    @JsonProperty("imageMd5")
    public String getImageMd5() {
        return imageMd5;
    }

    @JsonProperty("imageMd5")
    public void setImageMd5(String imageMd5) {
        this.imageMd5 = imageMd5;
    }

    @JsonProperty("birthDate")
    public String getBirthDate() {
        return birthDate;
    }

    @JsonProperty("birthDate")
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
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
		return "AgreementResponse [transaction=" + transaction + ", url=" + url + ", callbackUrl=" + callbackUrl
				+ ", contract=" + contract + ", product=" + product + ", service=" + service + ", data=" + data
				+ ", gallery=" + gallery + ", document=" + document + ", imageMd5=" + imageMd5 + ", birthDate="
				+ birthDate + ", additionalProperties=" + additionalProperties + "]";
	}

}
