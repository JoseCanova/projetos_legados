package org.nanotek.beans.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("InstrumentDescription")
public class InstrumentDescription extends DescriptionBase{

	private static final long serialVersionUID = 8312961172730412162L;

	@OneToOne(mappedBy = "description")
	private Instrument instrument;

	public InstrumentDescription() {
		super();
	}

	public InstrumentDescription(@NotNull String description) {
		super(description);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((instrument == null) ? 0 : instrument.hashCode());
		return result;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "IntrumentDescription [instrument=" + instrument + "]";
	}

}
