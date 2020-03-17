package org.nanotek.beans.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.nanotek.BaseEntity;

@MappedSuperclass
public class JoinPhraseBase<K extends Serializable> extends SequenceLongBase<K> implements BaseEntity{

	private static final long serialVersionUID = -5786425355982517472L;

	@NotNull
	@Column(name="join_phrase", columnDefinition = "VARCHAR NOT NULL"  , nullable=false)
	protected K joinPhrase;
	
	public JoinPhraseBase() {
	}

	public JoinPhraseBase(@NotNull K joinPhrase) {
		super();
		this.joinPhrase = joinPhrase;
	}

}
