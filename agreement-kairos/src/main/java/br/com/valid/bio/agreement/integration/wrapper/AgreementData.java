package br.com.valid.bio.agreement.integration.wrapper;


import br.com.valid.bio.agreement.model.ConveniadasHeaderValueEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author rodrigo.msilva
 */
@JsonIgnoreProperties( ignoreUnknown = true)
public class AgreementData {

    private String id;
    private String name;
    private String type;
    private String gallery;
    private String operation;
    private String documentType;
    private ServiceData[] services;

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGallery() {
        return gallery;
    }

    public void setGallery(String gallery) {
        this.gallery = gallery;
    }

    public ServiceData [] getServices() {
        return services;
    }

    public void setServices(ServiceData [] services) {
        this.services = services;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgreementData that = (AgreementData) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(type, that.type) &&
                Objects.equals(gallery, that.gallery) &&
                Objects.equals(services, that.services);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, type, gallery, services);
    }


    public String getServiceUrl(ConveniadasHeaderValueEnum serviceName) {
        final ServiceData serviceData = Stream.of(services).filter(p -> p.getOperation().equals(serviceName.name())).findFirst().orElseThrow(IllegalArgumentException::new);
        return serviceData.getEndpoint();
    }

}
