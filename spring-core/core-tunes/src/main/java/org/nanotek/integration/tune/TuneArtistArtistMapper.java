package org.nanotek.integration.tune;

import java.util.function.Function;

import javax.validation.constraints.NotNull;

import org.apache.commons.beanutils.BeanUtils;
import org.nanotek.beans.musicbrainz.TuneArtist;
import org.nanotek.ws.xml.Artist;


public class TuneArtistArtistMapper implements Function<Artist, TuneArtist > {

	public  Function<Artist, TuneArtist > transform = p -> apply(p);
	
	@Override
	public TuneArtist  apply(@NotNull Artist t) {
		TuneArtist instance = t.newType(TuneArtist::new);
		try {
			/*BeanUtils.copyProperties(instance, t);*/
			BeanUtils.copyProperty(instance, "id", t.getId());
			BeanUtils.copyProperty(instance, "name", t.getName());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return instance;
	}
	

}
