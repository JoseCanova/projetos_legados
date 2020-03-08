package org.nanotek.service.tranformer;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.nanotek.Base;
import org.nanotek.EntityBaseTransformer;
import org.nanotek.beans.csv.RecordingBean;
import org.nanotek.beans.entity.ArtistCredit;
import org.nanotek.beans.entity.Recording;
import org.nanotek.beans.entity.RecordingLength;
import org.nanotek.service.jpa.ArtistCreditJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component(value = "RecordingTransformerOld")
@Qualifier(value="RecordingTransformerOld")
public class RecordingTransformer implements EntityBaseTransformer<RecordingBean , Recording> {
	
	@Autowired 
	private ArtistCreditJpaService artistCreditJpaService;
	
	@Override
	public Recording transform(RecordingBean i) {
		Recording recording = new Recording();
		recording.setRecordingId(i.getId());
		recording.setGid(i.getGid());
		recording.setName(i.getName());
		Optional<ArtistCredit> ac = findArtistCredit(i.getArtistCredit());
		ArtistCredit artistCredit = ac.isPresent() ? ac.get() : null;
		recording.setArtistCredit(artistCredit);
		Optional<RecordingLength> optRl =  verifyRecordingLength(recording , i.getLength());
		if (optRl.isPresent()) recording.setRecordingLenght(optRl.get());
		return recording;
	}

	private Optional<RecordingLength> verifyRecordingLength(Recording recording , Long length) {
		return length !=null && length > 0 ? Optional.of(new RecordingLength(recording , length)) : Base.NULL_VALUE(RecordingLength.class);
	}

	private Optional<ArtistCredit> findArtistCredit(@Validated @NotNull Long artistCredit) {
		return artistCreditJpaService.findById(artistCredit);
	}

}