package org.nanotek.integration.tune.model;

import java.util.UUID;

import org.nanotek.Base;

@SuppressWarnings("serial")
public class TuneArtistWrapperType implements Base<UUID> {

	private UUID id; 
	
	private Long artistId; 
	
	private Long amgArtistId; 

	private String wrapperType; 
	
	private String artistType; 
	
	private String artistName; 
	
	private String artistLinkUrl; 
	
	private String primaryGenreName; 
	
	private Long primaryGenreId; 
	
	private String radioStationUrl; 
	
	public TuneArtistWrapperType() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getWrapperType() {
		return wrapperType;
	}

	public void setWrapperType(String wrapperType) {
		this.wrapperType = wrapperType;
	}

	public String getArtistType() {
		return artistType;
	}

	public void setArtistType(String artistType) {
		this.artistType = artistType;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getArtistLinkUrl() {
		return artistLinkUrl;
	}

	public void setArtistLinkUrl(String artistLinkUrl) {
		this.artistLinkUrl = artistLinkUrl;
	}

	public Long getArtistId() {
		return artistId;
	}

	public void setArtistId(Long artistId) {
		this.artistId = artistId;
	}

	public Long getAmgArtistId() {
		return amgArtistId;
	}

	public void setAmgArtistId(Long amgArtistId) {
		this.amgArtistId = amgArtistId;
	}

	public String getPrimaryGenreName() {
		return primaryGenreName;
	}

	public void setPrimaryGenreName(String primaryGenreName) {
		this.primaryGenreName = primaryGenreName;
	}

	public Long getPrimaryGenreId() {
		return primaryGenreId;
	}

	public void setPrimaryGenreId(Long primaryGenreId) {
		this.primaryGenreId = primaryGenreId;
	}

	public String getRadioStationUrl() {
		return radioStationUrl;
	}

	public void setRadioStationUrl(String radioStationUrl) {
		this.radioStationUrl = radioStationUrl;
	}

}

/*
 * 
{"wrapperType":"artist", "artistType":"Artist", "artistName":"╔tÚ 67", "artistLi
nkUrl":"https://itunes.apple.com/us/artist/ete-67/id209390729?uo=4", "artistId":
209390729, "amgArtistId":1023351, "primaryGenreName":"French Pop", "primaryGenre
Id":50000064, "radioStationUrl":"https://itunes.apple.com/station/idra.209390729
"}]
}
 */
