package org.nanotek.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Singleton;
import javax.interceptor.Interceptors;

import org.nanotek.Nameable;
import org.nanotek.beans.Track;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

@SuppressWarnings("serial")
@Singleton
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class TrackService  implements Nameable<Track> , Serializable {

		Track findById(Long code){
			return null;
		}

		@Override
		public List<Track> findByNameLike(String name) {
			return null;
		}

		@Override
		public List<Track> findByNameIgnoreCase(String name) {
			return null;
		}

		@Override
		public List<Track> findByNameLikeIgnoreCase(String name) {
			return null;
		}
}
