package org.nanotek.entities;

import java.util.stream.Stream;

import org.nanotek.BaseEntity;
import org.nanotek.beans.entity.Language;
import org.nanotek.stream.KongStream;

public interface MutableBaseLanguageEntity <K extends Language<?>> extends BaseEntity{

	default Stream<Language> setLanguage(Language<?> k) {
			return KongStream.of(Language.class).add(k).build();
	}
	
}
