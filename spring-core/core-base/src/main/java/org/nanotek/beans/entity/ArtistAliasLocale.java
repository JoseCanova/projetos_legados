package org.nanotek.beans.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
@DiscriminatorValue(value="ArtistAliasLocale")
public class ArtistAliasLocale extends LocaleBase{

	private static final long serialVersionUID = -6819342630275200151L;

	@OneToOne(mappedBy="artistAliasLocale")
	private ArtistAlias artistAlias;
	
	public ArtistAliasLocale() {
	}

	public ArtistAliasLocale(@NotBlank String locale) {
		super(locale);
	}

	public ArtistAlias getArtistAlias() {
		return artistAlias;
	}

	public void setArtistAlias(ArtistAlias artistAlias) {
		this.artistAlias = artistAlias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((artistAlias == null) ? 0 : artistAlias.hashCode());
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
		ArtistAliasLocale other = (ArtistAliasLocale) obj;
		if (artistAlias == null) {
			if (other.artistAlias != null)
				return false;
		} else if (!artistAlias.equals(other.artistAlias))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ArtistAliasLocale [artistAlias=" + artistAlias + ", locale=" + locale + ", id=" + id + "]";
	}
	
}
