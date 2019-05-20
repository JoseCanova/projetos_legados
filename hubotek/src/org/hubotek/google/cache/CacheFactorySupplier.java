package org.hubotek.google.cache;

import javax.cache.CacheException;
import javax.cache.CacheFactory;
import javax.cache.CacheManager;

import org.hubotek.HubotekException;

import com.google.common.base.Supplier;

public class CacheFactorySupplier implements Supplier<CacheFactory>{

	@Override
	public CacheFactory get() {
		try {
			return CacheManager.getInstance().getCacheFactory();
		} catch (CacheException e) {
			throw new HubotekException(e);
		}
	}
}
