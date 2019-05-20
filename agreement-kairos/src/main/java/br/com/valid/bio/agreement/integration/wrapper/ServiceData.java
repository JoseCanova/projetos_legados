package br.com.valid.bio.agreement.integration.wrapper;


import java.util.Objects;

/**
 * @author rodrigo.msilva
 */
public class ServiceData {

    private String type;
    private String endpoint;
    private Long timeout;
    private Integer numberOfAttempts;
    private String operation;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public Long getTimeout() {
        return timeout;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }

    public Integer getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public void setNumberOfAttempts(Integer numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceData that = (ServiceData) o;
        return Objects.equals(type, that.type) &&
                Objects.equals(endpoint, that.endpoint) &&
                Objects.equals(timeout, that.timeout) &&
                Objects.equals(numberOfAttempts, that.numberOfAttempts) &&
                Objects.equals(operation, that.operation);
    }

    @Override
    public int hashCode() {

        return Objects.hash(type, endpoint, timeout, numberOfAttempts, operation);
    }
}
