package org.nanotek.beans.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.nanotek.BaseEntity;

@MappedSuperclass
public class CommentBase<K extends Serializable , E extends Serializable> extends SequenceLongBase<K> implements BaseEntity {

	private static final long serialVersionUID = -3239637365262870832L;
	
	@NotNull
	@Column(name="comment", columnDefinition = "VARCHAR NOT NULL"  , nullable=false)
	protected K comment;

	public CommentBase() {
	}
	
	public CommentBase(@NotBlank K comment) {
		this.comment = comment;
	}

	public K getComment() {
		return comment;
	}

	public void setComment(K k) {
		this.comment = k;
	}

}
