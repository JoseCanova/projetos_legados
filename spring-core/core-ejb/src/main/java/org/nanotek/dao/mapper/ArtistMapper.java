package org.nanotek.dao.mapper;

import javax.validation.constraints.NotNull;

import org.apache.commons.beanutils.BeanUtils;
import org.nanotek.beans.ArtistName;

public class ArtistMapper<T extends ArtistName> implements ProxyMapper<ArtistName, T> {

	@Override
	public T apply(@NotNull ArtistName t) {
		T instance = createProxy(t);
		try {
			/*BeanUtils.copyProperties(instance, t);*/
			BeanUtils.copyProperty(instance, "id", t.getId());
			BeanUtils.copyProperty(instance, "name", t.getName());
			BeanUtils.copyProperty(instance, "mbid", t.getMbid());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return instance;
	}

}
