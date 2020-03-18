package org.nanotek.entities;

import java.io.Serializable;

import org.nanotek.beans.entity.GenderEntity;

public interface MutableGenderEntity<K extends Serializable> extends GenderEntity<K>{
			void setGender(K k);
}
