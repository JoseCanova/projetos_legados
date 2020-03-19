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
		
		return null;
	}

	private Optional<RecordingLength> verifyRecordingLength(Recording recording , Long length) {
		return length !=null && length > 0 ? Optional.of(new RecordingLength(recording , length)) : Base.NULL_VALUE(RecordingLength.class);
	}

	private Optional<ArtistCredit> findArtistCredit(@Validated @NotNull Long artistCredit) {
		return artistCreditJpaService.findById(artistCredit);
	}

}