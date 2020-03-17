package org.nanotek.beans.entity;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import org.nanotek.BaseEntity;

@MappedSuperclass
public class JoinPhraseBase extends SequenceLongBase<Serializable> implements BaseEntity{

	private static final long serialVersionUID = -5786425355982517472L;

	public JoinPhraseBase() {
	}

}
