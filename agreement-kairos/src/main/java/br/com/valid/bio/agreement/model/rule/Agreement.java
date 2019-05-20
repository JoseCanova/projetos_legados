
package br.com.valid.bio.agreement.model.rule;


import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.valid.bio.agreement.model.partner.kairos.BaseResponse;
import br.com.valid.bio.agreement.model.Base;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Agreement implements Base<String>{

	private String id;	
	@JsonProperty("id")
    private Long idInternal;
    @JsonProperty("name")
    private String name;
    @JsonProperty("required")
    private Boolean required;
    @JsonProperty("scoreWeight")
    private Long scoreWeight;
    @JsonProperty("webServiceInfo")
    private WebServiceInfo webServiceInfo;
    @JsonProperty("cache")
    private Cache cache;
    
    @JsonProperty("imageMd5")
    private String imageMd5;
    
	@JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
    @JsonProperty("image")
    private String image;
    
    @JsonProperty("gallery")
    private String gallery;
    
    @JsonProperty("document_id")
    private String document; 
    
    @JsonProperty("face_id")
    private String faceId; 
    
    @JsonProperty("responseData")
    private BaseResponse responseData;
    
    private String documentType;
    
    
	public Agreement() {}
    
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

    @JsonProperty("id")
    public Long getIdInternal() {
        return idInternal;
    }

    @JsonProperty("id")
    public void setIdInternal(Long id) {
        this.idInternal = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("required")
    public Boolean getRequired() {
        return required;
    }

    @JsonProperty("required")
    public void setRequired(Boolean required) {
        this.required = required;
    }

    @JsonProperty("scoreWeight")
    public Long getScoreWeight() {
        return scoreWeight;
    }

    @JsonProperty("scoreWeight")
    public void setScoreWeight(Long scoreWeight) {
        this.scoreWeight = scoreWeight;
    }

    @JsonProperty("webServiceInfo")
    public WebServiceInfo getWebServiceInfo() {
        return webServiceInfo;
    }

    @JsonProperty("webServiceInfo")
    public void setWebServiceInfo(WebServiceInfo webServiceInfo) {
        this.webServiceInfo = webServiceInfo;
    }

    @JsonProperty("cache")
    public Cache getCache() {
        return cache;
    }

    @JsonProperty("cache")
    public void setCache(Cache cache) {
        this.cache = cache;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGallery() {
		return gallery;
	}

	public void setGallery(String gallery) {
		this.gallery = gallery;
	}
    
    public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getFaceId() {
		return faceId;
	}

	public void setFaceId(String faceId) {
		this.faceId = faceId;
	}
    
    
	public BaseResponse getResponseData() {
		return responseData;
	}

	public void setResponseData(BaseResponse responseData) {
		this.responseData = responseData;
	}

	public String getImageMd5() {
		return imageMd5;
	}

	public void setImageMd5(String imageMd5) {
		this.imageMd5 = imageMd5;
	}


	public String getDocumentType() {
		return documentType;
	}


	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Agreement [id=");
		builder.append(id);
		builder.append(", idInternal=");
		builder.append(idInternal);
		builder.append(", name=");
		builder.append(name);
		builder.append(", required=");
		builder.append(required);
		builder.append(", scoreWeight=");
		builder.append(scoreWeight);
		builder.append(", webServiceInfo=");
		builder.append(webServiceInfo);
		builder.append(", cache=");
		builder.append(cache);
		builder.append(", imageMd5=");
		builder.append(imageMd5);
		builder.append(", image=");
		builder.append(image);
		builder.append(", gallery=");
		builder.append(gallery);
		builder.append(", document=");
		builder.append(document);
		builder.append(", faceId=");
		builder.append(faceId);
		builder.append(", responseData=");
		builder.append(responseData);
		builder.append(", documentType=");
		builder.append(documentType);
		builder.append("]");
		return builder.toString();
	}
	
	
}
