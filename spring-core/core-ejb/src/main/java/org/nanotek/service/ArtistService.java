package org.nanotek.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Singleton;
import javax.interceptor.Interceptors;

import org.nanotek.Nameable;
import org.nanotek.beans.ArtistName;
import org.nanotek.service.interceptor.SpringBeanNotekInterceptor;

@SuppressWarnings("serial")
@Singleton
@Interceptors(SpringBeanNotekInterceptor.class)
public class ArtistService implements Nameable<ArtistName> , Serializable{

	ArtistName findById(Long code){
		return null;
	}

	List<ArtistName> loadArtistPage(Integer startRecord , Integer numRecords)
	{ 
		return null;
	}

	@Override
	public List<ArtistName> findByNameLike(String name) {
		return null;
	}

	@Override
	public List<ArtistName> findByNameIgnoreCase(String name) {
		return null;
	}

	@Override
	public List<ArtistName> findByNameLikeIgnoreCase(String name) {
		return null;
	}

}
