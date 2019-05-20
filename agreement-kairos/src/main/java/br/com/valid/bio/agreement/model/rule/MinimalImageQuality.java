
package br.com.valid.bio.agreement.model.rule;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MinimalImageQuality {

    @JsonProperty("size")
    private String size;
    @JsonProperty("dpi")
    private String dpi;
    @JsonProperty("colorDepth")
    private String colorDepth;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("size")
    public String getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(String size) {
        this.size = size;
    }

    @JsonProperty("dpi")
    public String getDpi() {
        return dpi;
    }

    @JsonProperty("dpi")
    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    @JsonProperty("colorDepth")
    public String getColorDepth() {
        return colorDepth;
    }

    @JsonProperty("colorDepth")
    public void setColorDepth(String colorDepth) {
        this.colorDepth = colorDepth;
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
