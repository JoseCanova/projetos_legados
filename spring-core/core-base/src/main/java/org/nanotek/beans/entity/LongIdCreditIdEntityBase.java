package org.nanotek.beans.entity;

import java.io.Serializable;

import org.nanotek.LongIdEntityBase;

public interface LongIdCreditIdEntityBase<K extends Serializable> extends LongIdEntityBase{

	K getArtistCreditId();
	
}
