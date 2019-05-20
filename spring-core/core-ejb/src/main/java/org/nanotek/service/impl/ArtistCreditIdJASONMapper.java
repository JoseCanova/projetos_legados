package org.nanotek.service.impl;

import java.util.function.Function;

import org.json.JSONObject;
import org.nanotek.beans.ArtistCredit;

public class ArtistCreditIdJASONMapper implements Function<ArtistCredit,JSONObject> {

	@Override
	public JSONObject apply(ArtistCredit t) {
		JSONObject json = new JSONObject();
		json.append("id", t.getId());
		return json;
	}

}
