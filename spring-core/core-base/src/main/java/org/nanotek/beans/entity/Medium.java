package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.nanotek.NameBase;

@Entity
@Table(name="medium")
public class Medium extends EntityLongBase implements NameBase{

	private static final long serialVersionUID = 6669274101742169443L;
	
	/*
	 * @Id
	 * 
	 * @GeneratedValue(generator="medium_id_seq",strategy=GenerationType.SEQUENCE)
	 * 
	 * @SequenceGenerator(name="medium_id_seq" , sequenceName="medium_id_seq")
	 * private Long id;
	 */
	/*
	 * @Column(name="MEDIUM_ID") private Long mediumId;
	 */
	
	@NotBlank
	@Size(min=1 , max=2500)
	@Column(name="name" , length=2500 , nullable=false)
	private String name; 

	@Column(name="track_count")
	private Long trackCount; 

	@NotNull
	@Column(name="position",nullable=true)
	private Long position;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY , optional = false)
	@JoinColumn(name="release_id")
	private Release release;
	
	@ManyToOne
	@JoinColumn(name="medium_format_id")
	private MediumFormat format;

	public Medium() {}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTrackCount() {
		return trackCount;
	}

	public void setTrackCount(Long trackCount) {
		this.trackCount = trackCount;
	}

	public Long getPosition() {
		return position;
	}

	public void setPosition(Long position) {
		this.position = position;
	}

	public Release getRelease() {
		return release;
	}

	public void setRelease(Release release) {
		this.release = release;
	}

}
