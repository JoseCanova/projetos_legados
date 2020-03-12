package org.nanotek.beans.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("InstrumentComment")
public class InstrumentComment extends CommentBase{
	
	@NotNull
	@OneToOne(optional=false ,  mappedBy = "comment")
	private Instrument instrument;

	private static final long serialVersionUID = -4917697368647426796L;

	public InstrumentComment() {
	}

	public InstrumentComment(@NotBlank String comment) {
		this.comment = comment;
	}
	
	public InstrumentComment(@NotNull Instrument instrument, @NotBlank String comment) {
		this.instrument = instrument;
		this.comment = comment;
	}

	public Instrument getInstrument() {
		return instrument;
	}
	
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	@Override
	public String toString() {
		return "InstrumentComment [instrument=" + instrument + ", comment=" + comment + ", id=" + id + "]";
	}

}
