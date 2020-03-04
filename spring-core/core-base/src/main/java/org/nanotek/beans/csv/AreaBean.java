package org.nanotek.beans.csv;

public class AreaBean {

	/**
	 *  
	id                  SERIAL, -- PK
    gid                 uuid NOT NULL,
    name                VARCHAR NOT NULL,
    type                INTEGER, -- references area_type.id
    edits_pending       INTEGER NOT NULL DEFAULT 0 CHECK (edits_pending >=0),
    last_updated        TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    begin_date_year     SMALLINT,
    begin_date_month    SMALLINT,
    begin_date_day      SMALLINT,
    end_date_year       SMALLINT,
    end_date_month      SMALLINT,
    end_date_day        SMALLINT,
    ended               BOOLEAN NOT NULL DEFAULT FALSE
      CHECK (
        (
          -- If any end date fields are not null, then ended must be true
          (end_date_year IS NOT NULL OR
           end_date_month IS NOT NULL OR
           end_date_day IS NOT NULL) AND
          ended = TRUE
        ) OR (
          -- Otherwise, all end date fields must be null
          (end_date_year IS NULL AND
           end_date_month IS NULL AND
           end_date_day IS NULL)
        )
      ),
    comment             VARCHAR(255) NOT NULL DEFAULT ''
	 */
	
	private Long id; 
	private String gid; 
	private String name; 
	private Long type; 
	private Integer editsPending; 
	private String lastUpdated; 
	private Integer beginDateYear; 
	private Integer beginDateMonth; 
	private Integer beginDateDay; 
	private Integer endDateYead; 
	private Integer endDateMonth; 
	private Integer endDateDay;
	private String ended; 
	private String comment; 
	
	
	public AreaBean() {
	}

}
