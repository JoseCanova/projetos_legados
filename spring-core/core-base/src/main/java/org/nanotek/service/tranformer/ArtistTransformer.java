package org.nanotek.service.tranformer;

import org.nanotek.beans.ArtistName;
import org.nanotek.beans.csv.ArtistNameBean;
import org.springframework.stereotype.Service;

@Service
public class ArtistNameTransformer implements Transformer<ArtistNameBean , ArtistName>{

	@Override
	public ArtistName transform(ArtistNameBean i) {
		ArtistName artistName = new ArtistName();
		artistName.setArtistId(i.getId());
		artistName.setName(i.getName());
		artistName.setGid(i.getGid());
		artistName.setSortName(i.getSortName());
		artistName.setType(i.getType());
		artistName.setGender(i.getGender());
		return artistName;
	}

}
