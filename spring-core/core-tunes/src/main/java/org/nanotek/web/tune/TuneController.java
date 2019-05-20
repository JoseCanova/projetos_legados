package org.nanotek.web.tune;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TuneController {

	public TuneController() {
	}

	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}

}
