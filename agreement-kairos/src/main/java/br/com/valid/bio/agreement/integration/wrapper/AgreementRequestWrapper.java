package br.com.valid.bio.agreement.integration.wrapper;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.stream.Stream;

/**
 * @author rodrigo.msilva
 */
@JsonIgnoreProperties( ignoreUnknown = true)
public class AgreementRequestWrapper {

    private String id;
    private Long transaction;
    private String contract;
    private Long eventId;
    private String callbackUrl;
    private ValidBioDocument[] documents;
    private String name;
    private String birthDate;
    private String image;
    private String code;
    private String service;
    private AgreementData agreement;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public ValidBioDocument[] getDocuments() {
        return documents;
    }

    public void setDocuments(ValidBioDocument[] documents) {
        this.documents = documents;
    }

    public AgreementData getAgreement() {
        return agreement;
    }

    public void setAgreement(AgreementData agreement) {
        this.agreement = agreement;
    }

    public Long getTransaction() {
        return transaction;
    }

    public void setTransaction(Long transaction) {
        this.transaction = transaction;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }


    public ValidBioDocument getDocument(String docType) {
        return Stream.of(documents).filter(f -> f.getDocType().equals(docType)).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
