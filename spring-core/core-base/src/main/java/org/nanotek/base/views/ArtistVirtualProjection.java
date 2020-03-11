package org.nanotek.base.views;

import org.nanotek.Base;
import org.nanotek.repository.jpa.projections.Projection;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonProperty;

@Projection		
public interface ArtistVirtualProjection extends Base{

		public String getGid();
		
		public String getName();
		
		@JsonProperty(value = "gender")
		@Value("#{target.gender.name}")
		public String getGenderName();
		
		@JsonProperty(value = "area")
		@Value("#{target.area.name}")
		public String getArea();
		
		@JsonProperty(value = "beginDate")
		@Value("#{target.artistBeginDate}")
		public String getBeginDate();
		
		@JsonProperty(value = "endDate")
		@Value("#{target.artistEndDate}")
		public String getEndDate();
	
}
