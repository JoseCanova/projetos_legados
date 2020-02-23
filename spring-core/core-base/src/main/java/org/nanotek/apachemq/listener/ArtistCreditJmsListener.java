package org.nanotek.apachemq.listener;

import org.nanotek.Mediator;
import org.nanotek.beans.csv.ArtistCreditBean;

public class ArtistCreditJmsListener extends BaseBeanJmsListener<ArtistCreditBean>{
	
	public ArtistCreditJmsListener(Mediator<ArtistCreditBean> mediator) {
		super(mediator,ArtistCreditBean.class);
	}

}
