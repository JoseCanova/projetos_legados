package org.nanotek.beans.csv;

import javax.validation.constraints.NotNull;
import org.nanotek.LongBase;

public class ArtistNameBean implements LongBase{

	private static final long serialVersionUID = 2864330060600897052L;

	/**
	 *
	id                  SERIAL,
    gid                 UUID NOT NULL,
    name                VARCHAR NOT NULL,
    sort_name           VARCHAR NOT NULL,
    begin_date_year     SMALLINT,
    begin_date_month    SMALLINT,
    begin_date_day      SMALLINT,
    end_date_year       SMALLINT,
    end_date_month      SMALLINT,
    end_date_day        SMALLINT,
    type                INTEGER, -- references artist_type.id
    area                INTEGER, -- references area.id
    gender              INTEGER, -- references gender.id
    comment             VARCHAR(255) NOT NULL DEFAULT '',
    edits_pending       INTEGER NOT NULL DEFAULT 0 CHECK (edits_pending >= 0),
    last_updated        TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    ended               BOOLEAN NOT NULL DEFAULT FALSE
	 */

	@NotNull
	private Long id;
	@NotNull
	private String gid;
	@NotNull
	private String name;
	@NotNull
	private String sortName;

	private Integer beginDateYear;
	private Integer beginDateMonth;
	private Integer beginDateDay;
	private Integer endDateYear;
	private Integer endDateMonth;
	private Integer type;
	private Integer area;
	private Integer gender;
	private String comment;
	private Integer editsPending;
	private String lastUpdated;
	private String ended;


	public ArtistNameBean() {}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getArea() {
		return area;
	}
	public void setArea(Integer area) {
		this.area = area;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Integer getEditsPending() {
		return editsPending;
	}
	public void setEditsPending(Integer editsPending) {
		this.editsPending = editsPending;
	}
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public String getEnded() {
		return ended;
	}
	public void setEnded(String ended) {
		this.ended = ended;
	}

}
