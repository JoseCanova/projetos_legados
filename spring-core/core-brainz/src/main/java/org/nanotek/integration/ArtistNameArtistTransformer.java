package org.nanotek.integration;

import java.io.UnsupportedEncodingException;

import org.nanotek.beans.ArtistName;
import org.nanotek.ws.xml.Artist;
import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

@Component(value="artistNameArtistTransformer")
public class ArtistNameArtistTransformer implements Transformation<Artist,ArtistName>{

	@Transformer
	public Artist transform(ArtistName artistName) 
	{ 
		Artist artist = new Artist();
		artist.setId(artistName.getMbid());
		try {
			artist.setName(new String(artistName.getName().getBytes(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return artist; 
	}
}
