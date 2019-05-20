package br.com.valid.bio.agreement.model.partner.kairos.verify;


import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"transaction"
})
public class Image {

	@JsonProperty("transaction")
	@Valid
	private Transaction transaction;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("transaction")
	public Transaction getTransaction() {
		return transaction;
	}

	@JsonProperty("transaction")
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
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
		StringBuilder builder = new StringBuilder();
		builder.append("Image [transaction=");
		builder.append(transaction);
		builder.append(", additionalProperties=");
		builder.append(additionalProperties);
		builder.append("]");
		return builder.toString();
	}

}
