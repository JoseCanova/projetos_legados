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

import org.nanotek.Locale;
import org.nanotek.LocaleEntityBase;

@Entity
@Table(name="locale_base",
					indexes= {
							@Index(unique = false , name = "locale_table_idx" , columnList ="locale")
						})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
	    discriminatorType = DiscriminatorType.STRING,
	    name = "table_id",
	    columnDefinition = "VARCHAR NOT NULL"
	)
public class LocaleBase extends SequenceLongBase implements LocaleEntityBase<String> {

	private static final long serialVersionUID = -6664969453930737424L;

	@NotBlank
	@Column(name="locale", columnDefinition="VARCHAR NOT NULL")
	protected String locale; 
	
	public LocaleBase() {
	}
	
	public LocaleBase(@NotBlank String locale) {
		super();
		this.locale = locale;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
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
		LocaleBase other = (LocaleBase) obj;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		return true;
	}

	@Override
	public void on(Consumer<Long> k) {
		k.accept(getId());
	}
}
