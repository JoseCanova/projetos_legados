package org.nanotek.beans.entity;

import java.io.Serializable;

public interface MutableGenderEntity<K extends Serializable> extends GenderEntity<K>{
			void setGender(K k);
}
