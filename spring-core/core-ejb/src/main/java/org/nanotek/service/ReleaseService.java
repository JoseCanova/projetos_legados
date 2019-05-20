package org.nanotek.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Singleton;
import javax.interceptor.Interceptors;

import org.nanotek.Nameable;
import org.nanotek.beans.Release;
import org.nanotek.repository.ReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

@SuppressWarnings("serial")
@Singleton
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class ReleaseService  implements Nameable<Release> , Serializable {

	@Autowired 
	ReleaseRepository releaseRepository; 
	
	Release findById(Long code)
	{ 
		return null;
	}

	@Override
	public List<Release> findByNameLike(String name) {
		return null;
	}

	@Override
	public List<Release> findByNameIgnoreCase(String name) {
		return null;
	}

	@Override
	public List<Release> findByNameLikeIgnoreCase(String name) {
		return null;
	}
}
