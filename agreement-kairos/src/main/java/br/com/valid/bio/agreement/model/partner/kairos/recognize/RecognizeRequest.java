package br.com.valid.bio.agreement.model.partner.kairos.recognize;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class RecognizeRequest {

	private String image; 
	
	@JsonAlias("gallery_name")
	@JsonProperty("gallery_name")
	private String gallery;
	
	private Double minHeadScale; 
	
	private Double threshold;
	
	@JsonAlias("max_num_results")
	@JsonProperty("max_num_results")
	private Integer maxNumResults; 

	@JsonIgnore
	private String url;

	public RecognizeRequest() {}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getMinHeadScale() {
		return minHeadScale;
	}

	public void setMinHeadScale(Double minHeadScale) {
		this.minHeadScale = minHeadScale;
	}

	public Double getThreshold() {
		return threshold;
	}

	public void setThreshold(Double threshold) {
		this.threshold = threshold;
	}

	public Integer getMaxNumResults() {
		return maxNumResults;
	}

	public void setMaxNumResults(Integer maxNumResults) {
		this.maxNumResults = maxNumResults;
	}

	public String getGallery() {
		return gallery;
	}

	public void setGallery(String gallery) {
		this.gallery = gallery;
	}
	
}
