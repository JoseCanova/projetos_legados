package org.nanotek.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.nanotek.LongBase;

@Entity
@SuppressWarnings("serial")
@Table(name="artist")
@NamedQuery(name = "Artist.LoadAll", query ="Select a from Artist a order by a.name asc")
public class Artist implements LongBase{

//	@Id
//	@GeneratedValue(generator="artist_id_seq",strategy=GenerationType.IDENTITY)
//	@SequenceGenerator(name = "artist_id_seq", sequenceName = "artist_id_seq")
//	private Long id;
	
	@Id
	@NotNull
	@Column(name="id",nullable=false,unique=true)
	private Long id;
	
	@NotNull
	@Column(name="name",length=1000,nullable=false)
	private String name;
	
	@NotNull
	@Column(name="sort_name",length=1000,nullable=false)
	private String sortName;

	@ManyToMany(mappedBy = "artists",fetch=FetchType.LAZY)
	private List<ArtistCredit> artistCredits;

	@NotNull
	@Column(name="gid", nullable=false)
	private String gid;
	
	/*
	 * @Column(name="type", nullable=true) private Integer type;
	 * 
	 * @Column(name="country", nullable=true) private Integer country;
	 * 
	 * @Column(name="gender", nullable=true) private Integer gender;
	 */
	
	public Artist() {
	}

	public Artist(Long artistId , String name , String sortName , String gid) { 
		this.id = artistId; 
		this.name = name; 
		this.sortName = sortName; 
		this.gid = gid;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}


	public List<ArtistCredit> getArtistCredits() {
		return artistCredits != null ? artistCredits : (artistCredits = newAnyType(ArrayList::new));  //ofNullable(HashSet::new, artistCredits); //Optional.ofNullable(artistCredits).orElseGet(HashSet::new);
	}

	public void setArtistCredits(List<ArtistCredit> artistCredits) {
		this.artistCredits = artistCredits;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
}
