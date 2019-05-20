package org.nanotek.integration;

import java.util.HashSet;
import java.util.function.Consumer;

import org.nanotek.beans.musicbrainz.*;
import org.nanotek.ws.xml.Artist;
import org.nanotek.ws.xml.ArtistRelease;
import org.nanotek.ws.xml.Credit;
import org.nanotek.ws.xml.Record;
import org.nanotek.ws.xml.Track;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.stereotype.Component;

@Component(value="tuneTransformer")
@EnableIntegration
public class TuneTransformer implements Transformation<TuneArtist,Artist> {

	@Override
	@Transformer//(inputChannel="artistFilteredChannel" , outputChannel="artistTuneChannel")
	public TuneArtist transform(Artist info) {
		TuneArtist tuneArtist = new TuneArtist();
		tuneArtist.setId(info.getId());
		tuneArtist.setName(info.getName());
		tuneArtist.setTuneSChecked(false);
		
		if (tuneArtist.getReleases() == null)
			tuneArtist.setReleases(new HashSet<TuneRelease>());
		info.getReleases().forEach(new Consumer<ArtistRelease>(){

			@Override
			public void accept(ArtistRelease t) {
				TuneRelease release = new TuneRelease(t.getId() , t.getName());
				tuneArtist.getReleases().add(release);
			}
			
		});
		
		if (tuneArtist.getCredits() == null) 
			tuneArtist.setCredits(new HashSet<TuneCredit>());
		info.getCredits().forEach(new Consumer<Credit>(){

			@Override
			public void accept(Credit t) {
				tuneArtist.getCredits().add(new TuneCredit(t.getId() , t.getCreditName()));
			}
			
		});
		
		if (tuneArtist.getRecords() == null) 
			tuneArtist.setRecords(new HashSet<TuneRecord>());
		
		info.getRecords().forEach(new Consumer<Record>(){

			@Override
			public void accept(Record t) {
				TuneRecord tuneRecord = new TuneRecord(t.getId() , t.getRecordName());
				tuneArtist.getRecords().add(tuneRecord);
				
				if (tuneRecord.getTracks() == null)
					tuneRecord.setTracks(new HashSet<TuneTrack>());
				
				t.getTracks().forEach(new Consumer<Track>(){
					
					@Override
					public void accept(Track t) {
						tuneRecord.getTracks().add(new TuneTrack(t.getId() , t.getName()));
					} 
					
				});
			} 
			
		});
		
		return tuneArtist;
	}

}
