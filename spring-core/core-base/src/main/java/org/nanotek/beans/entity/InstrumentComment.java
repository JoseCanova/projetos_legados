package org.nanotek.beans.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.nanotek.entities.MutableCommentEntity;
import org.nanotek.entities.MutableInstrumentEntity;

@Entity
@DiscriminatorValue("InstrumentComment")
public class InstrumentComment<E extends Serializable> extends CommentBase<String,E> implements MutableInstrumentEntity<Instrument> , MutableCommentEntity<String>{
	
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
