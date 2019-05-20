package org.nanotek.web.spring;

import javax.annotation.PostConstruct;

@SuppressWarnings("serial")
public class InitializerController extends QuerySelector{

	@PostConstruct
	void init()
	{ 
		mountChoices();
	}
}
