package org.nanotek.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Singleton;
import javax.interceptor.Interceptors;

import org.nanotek.Nameable;
import org.nanotek.beans.Recording;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

@SuppressWarnings("serial")
@Singleton
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class RecordingService implements Nameable<Recording> , Serializable {
	
	Recording findById(Long id)
	{ 
		return null;
	}

	@Override
	public List<Recording> findByNameLike(String name) {
		return null;
	}

	@Override
	public List<Recording> findByNameIgnoreCase(String name) {
		return null;
	}

	@Override
	public List<Recording> findByNameLikeIgnoreCase(String name) {
		return null;
	}
	
}
