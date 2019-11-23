package org.nanotek.base.maps;

import org.nanotek.beans.csv.ArtistCreditNameBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Qualifier(value = "ArtistCreditNameBeanBaseMap")
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "artistcreditnamebean")
public class ArtistCreditNameBeanBaseMap extends BaseMapColumnStrategy<ArtistCreditNameBean> {

	public ArtistCreditNameBeanBaseMap() {
		super();
	}
}
