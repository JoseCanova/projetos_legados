package org.nanotek.beans.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="artist_alias_type")
public class ArtistAliasType extends BaseType{

	private static final long serialVersionUID = 430998067473248669L;

	public ArtistAliasType() {
	}

	public ArtistAliasType(Long id, String name, Long parent, Long childOrder, String description, String gid) {
		super(id, name, parent, childOrder, description, gid);
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "ArtistAliasType [name=" + name + ", parent=" + parent + ", childOrder=" + childOrder + ", description="
				+ description + ", gid=" + gid + ", id=" + id + "]";
	}	
}
