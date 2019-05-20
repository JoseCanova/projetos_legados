package org.nanotek.dao.mapper;

import java.util.HashMap;
import java.util.Map;

import org.nanotek.beans.ArtistName;

public class ArtistNameMapMapper extends BaseMapMapper<ArtistName> {

	@Override
	public Map<String, Object> apply(ArtistName t) {
		Map<String,Object> artistNameMap = new HashMap<String,Object>();
		artistNameMap.put("id", t.getId());
		artistNameMap.put("name", t.getName());
		artistNameMap.put("sortName", t.getSortName());
		artistNameMap.put("mbid", t.getMbid());
		return artistNameMap;
	}

}
