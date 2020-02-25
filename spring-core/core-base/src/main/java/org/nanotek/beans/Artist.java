package org.nanotek.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.nanotek.MutableBase;

@Entity
@Table(name="artist")
@NamedQuery(name = "Artist.LoadAll", query ="Select a from Artist a order by a.name asc")
public class Artist extends EntityLongBase implements MutableBase<Long>{

//	@Id
//	@GeneratedValue(generator="artist_id_seq",strategy=GenerationType.IDENTITY)
//	@SequenceGenerator(name = "artist_id_seq", sequenceName = "artist_id_seq")
//	private Long id;
	private static final long serialVersionUID = -932806802235346847L;

	@NotNull
	@Length(min = 1 , max = 1000)
	@Column(name="name",length=1000,nullable=false)
	private String name;
	
	@NotNull
	@Length(min = 1 , max = 1000)
	@Column(name="sort_name",length=1000,nullable=false)
	private String sortName;

	@ManyToMany(mappedBy = "artists",fetch=FetchType.LAZY)
	private List<ArtistCredit> artistCredits;

	@NotNull
	@Length(min = 1 , max = 40)
	@Column(name="gid", nullable=false)
	private String gid;
	
	@OneToOne(mappedBy = "artist" , fetch = FetchType.LAZY)
	private ArtistComment artistComment;
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
	
	public void setId(Long id) {
		this.id = id;
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

	public ArtistComment getArtistComment() {
		return artistComment;
	}

	public void setArtistComment(ArtistComment artistComment) {
		this.artistComment = artistComment;
	}
	
}
