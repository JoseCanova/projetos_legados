package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.nanotek.MutableRecordingAliasIdEntity;

@Entity
@DiscriminatorValue(value = "RecordingAlias")
public class RecordingAlias<K extends RecordingAlias<K>> extends LongIdSortName<K> 
implements MutableRecordingAliasIdEntity<Long>{

	private static final long serialVersionUID = -1952011326249338518L;

	@NotNull
	@Column(name = "recording_alias_id")
	private Long recordingAliasId;
	
	@Column(name="locale", length=1000)
	private String locale; 
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "recording_id")
	private Recording<?> recording; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="recording_type_id")
	private RecordingAliasType<?> type;

    @Column(name="begin_date_year")
	private Integer beginDateYear ;
    
    @Column(name="begin_date_month")
	private Integer beginDateMonth    ;
	
    @Column(name="begin_date_day")
	private Integer beginDateDay      ;

    @Column(name="end_date_year")
	private Integer endDateYear       ;
    
    @Column(name="end_date_month")
	private Integer endDateMonth      ;
    
    @Column(name="end_date_day")
	private Integer endDateDay        ; 
	
	public RecordingAlias() {
	}

	public RecordingAlias(@NotNull Long id, @NotBlank @Size(min = 1, max = 1000) String name, String locale, @NotNull Recording<?> recording,
			RecordingAliasType type, @NotNull @Size(min = 0, max = 1000) String sortName, Integer beginDateYear,
			Integer beginDateMonth, Integer beginDateDay, Integer endDateYear, Integer endDateMonth,
			Integer endDateDay) {
		this.name = name;
		this.locale = locale;
		this.recording = recording;
		this.type = type;
		this.sortName = sortName;
		this.beginDateYear = beginDateYear;
		this.beginDateMonth = beginDateMonth;
		this.beginDateDay = beginDateDay;
		this.endDateYear = endDateYear;
		this.endDateMonth = endDateMonth;
		this.endDateDay = endDateDay;
	}

	@Override
	public Long getRecordingAliasId() {
		// TODO Auto-generated method stub
		return recordingAliasId;
	}

	@Override
	public void setRecordingAliasId(@NotNull Long id) {
		this.recordingAliasId = id;
	}

}
