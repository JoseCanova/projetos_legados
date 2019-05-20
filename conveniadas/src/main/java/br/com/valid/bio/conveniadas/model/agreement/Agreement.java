package br.com.valid.bio.conveniadas.model.agreement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.valid.bio.conveniadas.model.Base;
import br.com.valid.bio.conveniadas.model.BaseResponse;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Agreement implements Base<String>{

	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("type")
	private String type;
	@JsonProperty("gallery")
	private String gallery;
	@JsonProperty("shared")
	private Boolean shared;
	@JsonProperty("required")
	private Boolean required;
	@JsonProperty("scoreWeight")
	private Long scoreWeight;
	@JsonProperty("services")
	@Valid
	private List<Service> services = null;
	@JsonProperty("cache")
	@Valid
	private Cache cache;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	
	@JsonProperty("image")
    private String image;
    
    @JsonProperty("document_id")
    private String document; 
    
    @JsonProperty("face_id")
    private String faceId; 
    
    @JsonProperty("responseData")
    private BaseResponse responseData;
	
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("gallery")
	public String getGallery() {
		return gallery;
	}

	@JsonProperty("gallery")
	public void setGallery(String gallery) {
		this.gallery = gallery;
	}

	@JsonProperty("shared")
	public Boolean getShared() {
		return shared;
	}

	@JsonProperty("shared")
	public void setShared(Boolean shared) {
		this.shared = shared;
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

	@JsonProperty("services")
	public List<Service> getServices() {
		return services;
	}

	@JsonProperty("services")
	public void setServices(List<Service> services) {
		this.services = services;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Agreement [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", type=");
		builder.append(type);
		builder.append(", gallery=");
		builder.append(gallery);
		builder.append(", shared=");
		builder.append(shared);
		builder.append(", required=");
		builder.append(required);
		builder.append(", scoreWeight=");
		builder.append(scoreWeight);
		builder.append(", services=");
		builder.append(services);
		builder.append(", cache=");
		builder.append(cache);
		builder.append(", image=");
		builder.append(image);
		builder.append(", document=");
		builder.append(document);
		builder.append(", faceId=");
		builder.append(faceId);
		builder.append(", responseData=");
		builder.append(responseData);
		builder.append("]");
		return builder.toString();
	}
}