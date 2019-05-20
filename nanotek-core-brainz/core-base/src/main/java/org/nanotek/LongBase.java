package org.nanotek;

import org.json.JSONObject;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public interface LongBase extends Base<Long>{
	
		default JSONObject toJson () 
		{ 
			return new JSONObject(getId());
		}
}
