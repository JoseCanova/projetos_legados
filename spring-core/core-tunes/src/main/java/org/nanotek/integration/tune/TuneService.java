package org.nanotek.integration.tune;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.nanotek.beans.ArtistName;
import org.nanotek.beans.musicbrainz.TuneArtist;
import org.nanotek.beans.musicbrainz.TuneCredit;
import org.nanotek.beans.musicbrainz.TuneRecord;
import org.nanotek.beans.musicbrainz.TuneRelease;
import org.nanotek.beans.musicbrainz.TuneTrack;
import org.nanotek.integration.Transformation;
import org.nanotek.repository.tune.TuneArtistRepository;
import org.nanotek.ws.xml.Artist;
import org.nanotek.ws.xml.ArtistRelease;
import org.nanotek.ws.xml.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Splitter;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Optional;

@MessageEndpoint(value="tuneService")
public class TuneService extends TuneArtistArtistMapper implements Transformation<TuneArtist,Artist> {

	private static  Logger logger = org.apache.log4j.Logger.getLogger(TuneService.class);

	@Autowired
	TuneArtistRepository tuneArtistRepository;

	@Override
	@Transformer//(inputChannel="artistFilteredChannel" , outputChannel="artistTuneChannel")
	public TuneArtist transform(Artist info) {

		logger.debug("Incoming Results " );
		
		TuneArtist tuneArtist = Optional.ofNullable(this.apply(info)).get();

		/*tuneArtist.setReleases(new HashSet<TuneRelease>());*/
		tuneArtist.setReleases(TuneReleaseTransferable.transferElements(info.getReleases() , HashSet::new));//from java8 samples.
		/*info.getReleases().forEach(p -> tuneArtist.getReleases().add(new TuneRelease(p)));*/
		info.getCredits().forEach(p->tuneArtist.getCredits().add(new TuneCredit(p.getId() , p.getCreditName())));
		info.getRecords().forEach(new Consumer<Record>(){

			@Override
			public void accept(Record t) {
				TuneRecord tuneRecord = new TuneRecord(t.getId() , t.getRecordName());
				tuneArtist.getRecords().add(tuneRecord);
				t.getTracks().forEach(p -> tuneRecord.getTracks().add(new TuneTrack(p.getId() , p.getName())));
			} 
		});

		logger.debug("Finished Transformation ");

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
		System.out.println("convertItunesResponseJson");
		JSONObject jsonObject = new JSONObject (itunesMessageReponse);
		return jsonObject;
	}

	@Filter
	public Boolean filterByTuneArtistId(Message<JSONObject> message)
	{ 
		System.out.println("filterByTuneArtistId" + message.getPayload().getJSONArray("results").getJSONObject(0).has("artistId"));
		return message.getPayload().getJSONArray("results").getJSONObject(0).has("artistId");
	}

	@Transformer 
	public TuneArtist  transformJSONtoTuneArtist(Message<JSONObject> message) 
	{ 
		System.out.println("transformJSONtoTuneArtist");
		JSONObject object = message.getPayload(); 
		return new TuneArtist(object.getLong("artistId") , object.getString("artistName"));
	}

	@Filter 
	public boolean filterJSONBjectMessageResult(JSONObject jsonObject) 
	{ 
		System.out.println("filterJSONBjectMessageResult" +  jsonObject.getLong("resultCount") );
		return jsonObject.getLong("resultCount") > 0;
	}

	@Splitter
	public List<?> splitItunesSearch (Message<JSONObject> jsonMessage)
	{ 
		List<JSONObject> results = new ArrayList<JSONObject>();
		logger.debug("Incoming Results " );
		int i = 0;
		while (i <  (jsonMessage.getPayload().getJSONArray("results")).length())
		{ 
			results.add(jsonMessage.getPayload().getJSONArray("results").getJSONObject(i++));
		}
		logger.debug("Finished Splitting");
		return results;
	}

	@Filter
	public boolean selectArtistBeforeUpdate(TuneArtist tuneArtist)
	{ 
		return !tuneArtistRepository.exists(tuneArtist.getId());
	}

	@ServiceActivator
	public Message<TuneArtist> saveArtistRecord(TuneArtist tuneArtist) 
	{ 
		return MessageBuilder.withPayload(tuneArtistRepository.save(tuneArtist)).build();
	}
	
}
