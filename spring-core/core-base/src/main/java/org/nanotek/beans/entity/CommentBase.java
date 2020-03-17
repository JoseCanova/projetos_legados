package org.nanotek.beans.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.nanotek.MutableCommentEntity;

@MappedSuperclass
public class CommentBase<K extends Serializable> extends SequenceLongBase<K> implements  MutableCommentEntity<K>{

	private static final long serialVersionUID = -3239637365262870832L;
	
	@NotNull
	@Column(name="comment", columnDefinition = "VARCHAR NOT NULL"  , nullable=false)
	protected K comment;

	public CommentBase() {
	}
	
	public CommentBase(@NotBlank K comment) {
		this.comment = comment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		return result;
	}

	@Override
	public K getComment() {
		return comment;
	}

	@Override
	public void setComment(K k) {
		this.comment = k;
	}

}
