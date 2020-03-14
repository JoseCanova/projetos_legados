package org.nanotek.beans.entity;

import java.io.Serializable;
import java.util.function.Consumer;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.nanotek.MutableCommentBase;

@MappedSuperclass
public class CommentBase<K extends Serializable> extends SequenceLongBase implements MutableCommentBase<K> {

	@NotNull
	@Column(name="comment", columnDefinition = "VARCHAR NOT NULL"  , nullable=false)
	protected K comment;

	public CommentBase() {
	}
	
	public CommentBase(@NotBlank K comment) {
		this.comment = comment;
	}

	public void setComment(K comment) {
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
	public void on(Consumer<K> k) {
		k.accept(comment);
	}
}
