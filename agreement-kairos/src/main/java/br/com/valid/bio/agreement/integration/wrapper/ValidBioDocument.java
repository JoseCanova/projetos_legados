package br.com.valid.bio.agreement.integration.wrapper;


import java.util.Objects;

/**
 * @author rodrigo.msilva
 */
public class ValidBioDocument {


    private String docType;
    private String document;


    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValidBioDocument that = (ValidBioDocument) o;
        return Objects.equals(docType, that.docType) &&
                Objects.equals(document, that.document);
    }

    @Override
    public int hashCode() {

        return Objects.hash(docType, document);
    }
}
