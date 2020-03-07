package org.nanotek.beans.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="artist_type")
public class ArtistType extends BaseType{

	private static final long serialVersionUID = 962190613873549033L;

	public ArtistType() {
		super();
	}

	public ArtistType(Long id, String name, Long parent, Long childOrder, String description, String gid) {
		super(id, name, parent, childOrder, description, gid);
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
}
