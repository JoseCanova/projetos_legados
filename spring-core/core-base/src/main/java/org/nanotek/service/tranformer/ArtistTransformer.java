package org.nanotek.service.tranformer;

import org.nanotek.Transformer;
import org.nanotek.beans.csv.ArtistBean;
import org.nanotek.beans.entity.Artist;
import org.nanotek.beans.entity.ArtistSortName;
import org.springframework.stereotype.Service;

@Service
public class ArtistTransformer implements Transformer<ArtistBean , Artist>{

	@Override
	public Artist transform(ArtistBean i) {
		Artist artistName = new Artist();
		artistName.setArtistId(i.getId());
		artistName.setName(i.getName());
		artistName.setGid(i.getGid());
		artistName.setSortName(new ArtistSortName(i.getSortName()));
		return artistName;
	}

}
