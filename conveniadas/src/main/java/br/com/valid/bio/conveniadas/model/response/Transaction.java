package br.com.valid.bio.conveniadas.model.response;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Transaction {

    @JsonProperty("status")
    private String status;
    @JsonProperty("subject_id")
    private String subjectId;
    @JsonProperty("quality")
    private Double quality;
    @JsonProperty("width")
    private Integer width;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("topLeftX")
    private Integer topLeftX;
    @JsonProperty("topLeftY")
    private Integer topLeftY;
    @JsonProperty("confidence")
    private Integer confidence;
    @JsonProperty("gallery_name")
    private String galleryName;
    @JsonProperty("enrollment_timestamp")
    private String enrollmentTimestamp;
    @JsonProperty("roll")
    private Integer roll;
    @JsonProperty("face_id")
    private String faceId;
    @JsonProperty("eyeDistance")
    private Integer eyeDistance;
    @JsonProperty("pitch")
    private Integer pitch;
    @JsonProperty("yaw")
    private Integer yaw;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("subject_id")
    public String getSubjectId() {
        return subjectId;
    }

    @JsonProperty("subject_id")
    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    @JsonProperty("quality")
    public Double getQuality() {
        return quality;
    }

    @JsonProperty("quality")
    public void setQuality(Double quality) {
        this.quality = quality;
    }

    @JsonProperty("width")
    public Integer getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(Integer width) {
        this.width = width;
    }

    @JsonProperty("height")
    public Integer getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(Integer height) {
        this.height = height;
    }

    @JsonProperty("topLeftX")
    public Integer getTopLeftX() {
        return topLeftX;
    }

    @JsonProperty("topLeftX")
    public void setTopLeftX(Integer topLeftX) {
        this.topLeftX = topLeftX;
    }

    @JsonProperty("topLeftY")
    public Integer getTopLeftY() {
        return topLeftY;
    }

    @JsonProperty("topLeftY")
    public void setTopLeftY(Integer topLeftY) {
        this.topLeftY = topLeftY;
    }

    @JsonProperty("confidence")
    public Integer getConfidence() {
        return confidence;
    }

    @JsonProperty("confidence")
    public void setConfidence(Integer confidence) {
        this.confidence = confidence;
    }

    @JsonProperty("gallery_name")
    public String getGalleryName() {
        return galleryName;
    }

    @JsonProperty("gallery_name")
    public void setGalleryName(String galleryName) {
        this.galleryName = galleryName;
    }

    @JsonProperty("enrollment_timestamp")
    public String getEnrollmentTimestamp() {
        return enrollmentTimestamp;
    }

    @JsonProperty("enrollment_timestamp")
    public void setEnrollmentTimestamp(String enrollmentTimestamp) {
        this.enrollmentTimestamp = enrollmentTimestamp;
    }

    @JsonProperty("roll")
    public Integer getRoll() {
        return roll;
    }

    @JsonProperty("roll")
    public void setRoll(Integer roll) {
        this.roll = roll;
    }

    @JsonProperty("face_id")
    public String getFaceId() {
        return faceId;
    }

    @JsonProperty("face_id")
    public void setFaceId(String faceId) {
        this.faceId = faceId;
    }

    @JsonProperty("eyeDistance")
    public Integer getEyeDistance() {
        return eyeDistance;
    }

    @JsonProperty("eyeDistance")
    public void setEyeDistance(Integer eyeDistance) {
        this.eyeDistance = eyeDistance;
    }

    @JsonProperty("pitch")
    public Integer getPitch() {
        return pitch;
    }

    @JsonProperty("pitch")
    public void setPitch(Integer pitch) {
        this.pitch = pitch;
    }

    @JsonProperty("yaw")
    public Integer getYaw() {
        return yaw;
    }

    @JsonProperty("yaw")
    public void setYaw(Integer yaw) {
        this.yaw = yaw;
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
