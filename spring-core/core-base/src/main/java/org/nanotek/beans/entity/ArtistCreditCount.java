package org.nanotek.beans.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue(value = "ArtistCreditCount")
public class ArtistCreditCount extends LongCountBase{

	private static final long serialVersionUID = 2246716928420528795L;

	@NotNull
	@OneToOne(optional = false , mappedBy = "artistCount")
	private ArtistCredit artistCredit;
	
	public ArtistCreditCount() {
	}

	public ArtistCreditCount(@NotNull Long count) {
		super(count);
	}

	public ArtistCredit getArtistCredit() {
		return artistCredit;
	}

	public void setArtistCredit(ArtistCredit artistCredit) {
		this.artistCredit = artistCredit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((artistCredit == null) ? 0 : artistCredit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArtistCreditCount other = (ArtistCreditCount) obj;
		if (artistCredit == null) {
			if (other.artistCredit != null)
				return false;
		} else if (!artistCredit.equals(other.artistCredit))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ArtistCreditCountBase [artistCredit=" + artistCredit + ", count=" + count + ", id=" + id + "]";
	}
	
}
