package org.nanotek.beans.csv;

import org.nanotek.LongBase;

public class ArtistCreditNameBean implements LongBase {

	private static final long serialVersionUID = -625201514069517695L;

	private Long artistCreditId;
	
	private Long position;
	
	private Long artistId; 
	
	private String name; 
	
	private String joinPhrase;

	public Long getArtistCreditId() {
		return artistCreditId;
	}

	public void setArtistCreditId(Long artistCreditId) {
		this.artistCreditId = artistCreditId;
	}

	public Long getPosition() {
		return position;
	}

	public void setPosition(Long position) {
		this.position = position;
	}

	public Long getArtistId() {
		return artistId;
	}

	public void setArtistId(Long artistId) {
		this.artistId = artistId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJoinPhrase() {
		return joinPhrase;
	}

	public void setJoinPhrase(String joinPhrase) {
		this.joinPhrase = joinPhrase;
	}

	@Override
	public Long getId() {
		return 0l;
	}

	public void setId(Long id) {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artistCreditId == null) ? 0 : artistCreditId.hashCode());
		result = prime * result + ((artistId == null) ? 0 : artistId.hashCode());
		result = prime * result + ((joinPhrase == null) ? 0 : joinPhrase.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArtistCreditNameBean other = (ArtistCreditNameBean) obj;
		if (artistCreditId == null) {
			if (other.artistCreditId != null)
				return false;
		} else if (!artistCreditId.equals(other.artistCreditId))
			return false;
		if (artistId == null) {
			if (other.artistId != null)
				return false;
		} else if (!artistId.equals(other.artistId))
			return false;
		if (joinPhrase == null) {
			if (other.joinPhrase != null)
				return false;
		} else if (!joinPhrase.equals(other.joinPhrase))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ArtistCreditNameBean [artistCreditId=" + artistCreditId + ", position=" + position + ", artistId="
				+ artistId + ", name=" + name + ", joinPhrase=" + joinPhrase + "]";
	}
	
	
}
