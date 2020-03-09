package org.nanotek.beans.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue(value="ReleaseComment")
public class ReleaseComment extends CommentBase {

	private static final long serialVersionUID = 4978743759627354208L;
	
	@NotNull
	@OneToOne(mappedBy = "comment" , optional = false , fetch = FetchType.LAZY)
	private Release release;
	
	public ReleaseComment() {
	}

	public ReleaseComment(@NotBlank String comment) {
		super(comment);
	}

	public ReleaseComment(@NotBlank String comment , @NotNull Release release) {
		super();
		this.release = release;
	}

	public Release getRelease() {
		return release;
	}

	public void setRelease(Release release) {
		this.release = release;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((release == null) ? 0 : release.hashCode());
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
		ReleaseComment other = (ReleaseComment) obj;
		if (release == null) {
			if (other.release != null)
				return false;
		} else if (!release.equals(other.release))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReleaseComment [comment=" + comment + ", id=" + id + "]";
	}
	
}
