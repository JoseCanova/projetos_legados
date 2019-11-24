package org.nanotek.apachemq;

import org.nanotek.beans.csv.ReleaseBean;
import org.springframework.stereotype.Component;

@Component
public class ReleaseBeanMessageSender extends JmsMessageSender<ReleaseBean> {

	public ReleaseBeanMessageSender() { 
		super();
	}
	
}
