package org.nanotek;

import javax.persistence.MappedSuperclass;

import org.json.JSONObject;

@MappedSuperclass
public interface LongBase extends Base<Long>{
	
		default JSONObject toJson () 
		{ 
			return new JSONObject(getId());
		}
}
