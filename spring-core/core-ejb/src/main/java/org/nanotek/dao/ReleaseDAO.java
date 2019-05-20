package org.nanotek.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import org.nanotek.Base;
import org.nanotek.beans.Release;

@Local
public interface ReleaseDAO extends DAO<Release> {

	List<Release>  findReleases(List<Base<?>> artistCredits);
	
	List<Release>  findReleases(String artistCredits);
	
	
	default Release find (Release sample) 
	{ 
		return find(Release.class, sample.getId());
	}
	

	@Override
	default <I extends Serializable> Release find(I i) {
		return find(Release.class, i);
	}
	
}
