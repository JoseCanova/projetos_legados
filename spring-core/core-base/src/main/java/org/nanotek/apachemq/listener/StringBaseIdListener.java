package org.nanotek.apachemq.listener;

import java.util.Optional;

import javax.persistence.PrePersist;

import org.nanotek.StringBase;

public class StringBaseIdListener {

	    @PrePersist
	    public void prepareId(StringBase o) {
	    	if(Optional.ofNullable(o).isPresent()) 
	    			o.setId(o.md5Digest());
	    }

}
