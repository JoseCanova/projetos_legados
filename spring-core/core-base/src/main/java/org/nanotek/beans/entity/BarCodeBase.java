package org.nanotek.beans.entity;

import java.util.function.Consumer;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.nanotek.BarCodeEntityBase;

@Entity
@Table(name="bar_code_base", 
indexes= {
		@Index(unique = false , name = "bar_code_idx" , columnList ="bar_code")
	})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
	    discriminatorType = DiscriminatorType.STRING,
	    name = "table_id",
	    columnDefinition = "VARCHAR NOT NULL"
	)
public abstract class BarCodeBase extends SequenceLongBase implements BarCodeEntityBase<String,Long>{

	private static final long serialVersionUID = 3988946185099694426L;

	@NotBlank
	@Column(name="bar_code" , length=255 , nullable=false)
	protected String barCode;
	
	public BarCodeBase() {
	}
	
	public BarCodeBase(@NotBlank String barCode) {
		super();
		this.barCode = barCode;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((barCode == null) ? 0 : barCode.hashCode());
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
		BarCodeBase other = (BarCodeBase) obj;
		if (barCode == null) {
			if (other.barCode != null)
				return false;
		} else if (!barCode.equals(other.barCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BarCodeBase [barCode=" + barCode + ", id=" + id + "]";
	}
	
}
