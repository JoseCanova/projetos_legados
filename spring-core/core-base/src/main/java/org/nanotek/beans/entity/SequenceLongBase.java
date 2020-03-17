package org.nanotek.beans.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.nanotek.Base;
import org.nanotek.BaseId;
import org.nanotek.IdBase;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Table(name="sequence_long_base")
@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator.class)
@Inheritance(strategy = InheritanceType.JOINED)
public class SequenceLongBase<K extends Serializable> implements IdBase<SequenceLongBase<Long>, Long>{

	private static final long serialVersionUID = 1932266128563675834L;
	
	@Id
	@NotNull
	@Column(name="id",nullable=false,unique=true)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="sequence_id_seq")
	@SequenceGenerator(name = "sequence_id_seq", sequenceName = "sequence_id_seq")
	protected Long id;

	public SequenceLongBase() {}
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "SequenceLongBase [id=" + id + "]";
	}

}
