package org.nanotek.service.tranformer;

import org.mapstruct.Mapper;
import org.nanotek.EntityBaseTransformer;
import org.nanotek.beans.ArtistCredit;
import org.nanotek.beans.csv.ArtistCreditBean;

@Mapper(componentModel = "spring")
public interface ArtistCreditBeanTransformer extends EntityBaseTransformer<ArtistCreditBean,ArtistCredit>{

	@Override
	ArtistCredit transform(ArtistCreditBean i);
}
