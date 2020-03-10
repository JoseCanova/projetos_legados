package org.nanotek.beans.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="composite_dates",
				indexes= {
						@Index(unique = false , name = "date_year_idx" , columnList ="year")
					}
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
	    discriminatorType = DiscriminatorType.STRING,
	    name = "table_id",
	    columnDefinition = "VARCHAR NOT NULL"
	)
@Cacheable(value = true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DatableBase extends SequenceLongBase {

	private static final long serialVersionUID = -2752304170904238032L;

	@NotNull
	@Column(name="year", nullable = false)
	protected Integer year;
	
	@Column(name="month")
	protected Integer month;
	
	@Column(name="day")
	protected Integer day;

	public DatableBase() {
	}

	public DatableBase(@NotNull Integer year) {
		super();
		this.year = year;
	}
	
	public DatableBase(@NotNull  Integer year, Integer month) {
		super();
		this.year = year;
		this.month = month;
	}
	
	public DatableBase(@NotNull  Integer year, Integer month, Integer day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		DatableBase other = (DatableBase) obj;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DatableBase [year=" + year + ", month=" + month + ", day=" + day + ", id=" + id + "]";
	}
}