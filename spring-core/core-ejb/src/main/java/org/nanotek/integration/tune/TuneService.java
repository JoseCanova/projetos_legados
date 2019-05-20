package org.nanotek.integration.tune;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Consumer;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.nanotek.beans.musicbrainz.TuneArtist;
import org.nanotek.beans.musicbrainz.TuneCredit;
import org.nanotek.beans.musicbrainz.TuneRecord;
import org.nanotek.beans.musicbrainz.TuneRelease;
import org.nanotek.beans.musicbrainz.TuneTrack;
import org.nanotek.integration.Transformation;
import org.nanotek.ws.xml.Artist;
import org.nanotek.ws.xml.Record;
import org.springframework.integration.annotation.Splitter;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component(value="tuneTransformer")
@EnableIntegration
public class TuneService implements Transformation<TuneArtist,Artist> {

	private static  Logger logger = org.apache.log4j.Logger.getLogger(TuneService.class);

	@Override
	@Transformer//(inputChannel="artistFilteredChannel" , outputChannel="artistTuneChannel")
	public TuneArtist transform(Artist info) {
		
		TuneArtist tuneArtist = new TuneArtist();
		tuneArtist.setId(info.getId());
		tuneArtist.setName(info.getName());
		tuneArtist.setTuneSChecked(false);
		
		info.getReleases().forEach(p -> tuneArtist.getReleases().add(new TuneRelease(p.getId() , p.getName())));
		
		info.getCredits().forEach(p->tuneArtist.getCredits().add(new TuneCredit(p.getId() , p.getCreditName())));
		
		info.getRecords().forEach(new Consumer<Record>(){

			@Override
			public void accept(Record t) {
				TuneRecord tuneRecord = new TuneRecord(t.getId() , t.getRecordName());
				tuneArtist.getRecords().add(tuneRecord);
				t.getTracks().forEach(p -> tuneRecord.getTracks().add(new TuneTrack(p.getId() , p.getName())));
			} 
		});

		return tuneArtist;
	}

	@Transformer//(inputChannel="artistFilteredChannel" , outputChannel="artistTuneChannel")
	public String nameEncoder(org.nanotek.ws.xml.Artist tuneArtist) 
	{ 	
		logger.debug("Entering name ecoder " + tuneArtist.getName());
		return tuneArtist.getName();
	}

	@Transformer//(inputChannel="artistFilteredChannel" , outputChannel="artistTuneChannel")
	public JSONObject convertItunesResponseJson(String itunesMessageReponse) 
	{ 
		JSONObject jsonObject = new JSONObject (itunesMessageReponse);
		return jsonObject;
	}

	@Splitter
	public List<?> splitItunesSearch (Message<JSONObject> jsonMessage)
	{ 
		List<JSONObject> results = new ArrayList<JSONObject>();
		int i = 0;
		while (i < jsonMessage.getPayload().getJSONArray("results").length())
		{ 
			results.add(jsonMessage.getPayload().getJSONArray("results").getJSONObject(i));
		};
		return results;
	}
}
