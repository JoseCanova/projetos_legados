package org.nanotek.service.tranformer;

import org.nanotek.Transformer;
import org.nanotek.beans.Recording;
import org.nanotek.beans.csv.RecordingBean;
import org.springframework.stereotype.Component;

@Component
public class RecordingTransformer implements Transformer<RecordingBean , Recording> {

	@Override
	public Recording transform(RecordingBean i) {
		Recording recording = new Recording();
		recording.setRecordingId(i.getId());
		recording.setName(i.getName());
		recording.setArtistCredit(i.getArtistCredit());
		recording.setComment(i.getComment());
		recording.setLength(i.getLength());
		return recording;
	}

}
