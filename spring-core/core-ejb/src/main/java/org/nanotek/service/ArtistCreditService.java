package org.nanotek.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Singleton;
import javax.interceptor.Interceptors;

import org.nanotek.LongIdBaseRepository;
import org.nanotek.Nameable;
import org.nanotek.beans.ArtistCredit;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

@SuppressWarnings("serial")
@Singleton
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class ArtistCreditService implements Nameable<ArtistCredit> , LongIdBaseRepository<ArtistCredit> , Serializable {

	@Override
	public ArtistCredit findById(Long id) {
		return null;
	}

	@Override
	public List<ArtistCredit> findByNameLike(String name) {
		return null;
	}

	@Override
	public List<ArtistCredit> findByNameIgnoreCase(String name) {
		return null;
	}

	@Override
	public List<ArtistCredit> findByNameLikeIgnoreCase(String name) {
		return null;
	}
}
