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

import org.nanotek.RecordingAliasIdBase;

@Entity
@DiscriminatorValue(value = "RecordingAlias")
public class RecordingAlias extends LongIdSortName<RecordingAlias> implements RecordingAliasIdBase<Long>{

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
	private RecordingAliasType type;

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

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}


	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public Integer getBeginDateYear() {
		return beginDateYear;
	}

	public void setBeginDateYear(Integer beginDateYear) {
		this.beginDateYear = beginDateYear;
	}

	public Integer getBeginDateMonth() {
		return beginDateMonth;
	}

	public void setBeginDateMonth(Integer beginDateMonth) {
		this.beginDateMonth = beginDateMonth;
	}

	public Integer getBeginDateDay() {
		return beginDateDay;
	}

	public void setBeginDateDay(Integer beginDateDay) {
		this.beginDateDay = beginDateDay;
	}

	public Integer getEndDateYear() {
		return endDateYear;
	}

	public void setEndDateYear(Integer endDateYear) {
		this.endDateYear = endDateYear;
	}

	public Integer getEndDateMonth() {
		return endDateMonth;
	}

	public void setEndDateMonth(Integer endDateMonth) {
		this.endDateMonth = endDateMonth;
	}

	public Integer getEndDateDay() {
		return endDateDay;
	}

	public void setEndDateDay(Integer endDateDay) {
		this.endDateDay = endDateDay;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((recording == null) ? 0 : recording.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecordingAlias other = (RecordingAlias) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (recording == null) {
			if (other.recording != null)
				return false;
		} else if (!recording.equals(other.recording))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReleaseAlias [name=" + name + ", locale=" + locale + ", release=" + recording + ", type=" + type
				+ ", sortName=" + sortName + ", beginDateYear=" + beginDateYear + ", beginDateMonth=" + beginDateMonth
				+ ", beginDateDay=" + beginDateDay + ", endDateYear=" + endDateYear + ", endDateMonth=" + endDateMonth
				+ ", endDateDay=" + endDateDay + ", id=" + id + "]";
	}

	public Recording getRecording() {
		return recording;
	}

	public void setRecording(Recording recording) {
		this.recording = recording;
	}

	public RecordingAliasType getType() {
		return type;
	}

	public void setType(RecordingAliasType type) {
		this.type = type;
	}

	@Override
	public Long getRecordingAliasId() {
		return recordingAliasId;
	}

	@Override
	public void setRecordingAliasId(Long id) {
		this.recordingAliasId = id;
	}
	
}
