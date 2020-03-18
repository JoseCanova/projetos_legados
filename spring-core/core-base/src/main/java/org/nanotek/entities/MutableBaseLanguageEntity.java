package org.nanotek.entities;

import org.nanotek.BaseEntity;
import org.nanotek.beans.entity.Language;

public interface MutableBaseLanguageEntity <K extends Language<?>> extends BaseEntity{

	void setLanguage(K k);
	
}
