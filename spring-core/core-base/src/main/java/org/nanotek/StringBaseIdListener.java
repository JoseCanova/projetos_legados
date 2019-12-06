package org.nanotek;

import java.util.Optional;

import javax.persistence.PrePersist;

public class StringBaseIdListener {

	    @PrePersist
	    public void prepareId(StringBase o) {
	    	if(Optional.ofNullable(o).isPresent()) 
	    			o.setId(o.md5Digest());
	    }

}
