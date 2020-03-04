package org.nanotek.beans.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.nanotek.NameBase;

@Entity
@Table(name="instrument_type")
public class InstrumentType extends BaseType implements NameBase{

	
	private static final long serialVersionUID = 1526958848784766177L;

	@OneToMany(fetch = FetchType.LAZY)
	private Set<Instrument> instruments;
	
	public InstrumentType() {
	}

	public InstrumentType(Long id, String name, Long parent, Long childOrder, String description, String gid) {
		super(id , name , parent  , childOrder , description , gid);
	}

	@Override
	public String toString() {
		return "InstrumentType [name=" + name + ", description=" + description + ", gid=" + gid + ", id=" + id + "]";
	}

	public Set<Instrument> getInstruments() {
		return instruments;
	}


	public void setInstruments(Set<Instrument> instruments) {
		this.instruments = instruments;
	}

}
