package br.com.valid.bio.conveniadas.abis.model.enroll;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.valid.bio.conveniadas.abis.model.ImageBehaviorEnum;
import br.com.valid.bio.conveniadas.abis.model.ImageHolder;
import br.com.valid.bio.conveniadas.abis.model.ImageTypeEnum;
import br.com.valid.bio.conveniadas.abis.model.SubjectBehaviorEnum;
import br.com.valid.bio.conveniadas.model.Base;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollRequest implements Base<String> , ImageHolder{

	@JsonProperty("waitTimeout")
	private Long waitTimeout = 0L;
	@JsonProperty("subjectBehavior")
	private SubjectBehaviorEnum subjectBehavior;
	@JsonProperty("subjectKey")
	private String subjectKey;
	@JsonProperty("imageKey")
	private String imageKey;
	@JsonProperty("imageType")
	private ImageTypeEnum imageType;
	@JsonProperty("imageData")
	private String imageData;
	@JsonProperty("imageBehaviour")
	private ImageBehaviorEnum imageBehaviour;
	
	private List<String> subjectTags = new ArrayList<>();
	
	public EnrollRequest() {}
	
	@JsonProperty("waitTimeout")
	public Long getWaitTimeout() {
		return waitTimeout;
	}

	@JsonProperty("waitTimeout")
	public void setWaitTimeout(Long waitTimeout) {
		this.waitTimeout = waitTimeout;
	}

	@JsonProperty("subjectBehavior")
	public SubjectBehaviorEnum getSubjectBehavior() {
		return subjectBehavior;
	}

	@JsonProperty("subjectBehavior")
	public void setSubjectBehavior(SubjectBehaviorEnum subjectBehavior) {
		this.subjectBehavior = subjectBehavior;
	}

	@JsonProperty("subjectKey")
	public String getSubjectKey() {
		return subjectKey;
	}

	@JsonProperty("subjectKey")
	public void setSubjectKey(String subjectKey) {
		this.subjectKey = subjectKey;
	}

	@JsonProperty("imageKey")
	public String getImageKey() {
		return imageKey;
	}

	@JsonProperty("imageKey")
	public void setImageKey(String imageKey) {
		this.imageKey = imageKey;
	}

	@JsonProperty("imageType")
	public ImageTypeEnum getImageType() {
		return imageType;
	}

	@JsonProperty("imageType")
	public void setImageType(ImageTypeEnum imageType) {
		this.imageType = imageType;
	}

	@JsonProperty("imageData")
	public String getImageData() {
		return imageData;
	}

	@JsonProperty("imageData")
	public void setImageData(String imageData) {
		this.imageData = imageData;
	}

	//Identity
	@JsonIgnore
	@Override
	public String getId() {
		return this.getClass().getName();
	}

	public ImageBehaviorEnum getImageBehaviour() {
		return imageBehaviour;
	}

	public void setImageBehaviour(ImageBehaviorEnum imageBehaviour) {
		this.imageBehaviour = imageBehaviour;
	}

	public List<String> getSubjectTags() {
		return subjectTags;
	}

	public void setSubjectTags(List<String> subjectTags) {
		this.subjectTags = subjectTags;
	}

	@Override
	public String toString() {
		return "EnrollRequest [waitTimeout=" + waitTimeout + ", subjectBehavior=" + subjectBehavior + ", subjectKey="
				+ subjectKey + ", imageKey=" + imageKey + ", imageType=" + imageType + ", imageData=" + imageData
				+ ", imageBehaviour=" + imageBehaviour + ", subjectTags=" + subjectTags + "]";
	}

}