package org.nanotek.web.spring;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

@SuppressWarnings("serial")
public class QuerySelector implements Serializable{


	List<SelectItem> choices = new ArrayList<SelectItem>(); 

	public void mountChoices (){ 
		if (choices.size() == 0)
		for (QueryChoice choice : QueryChoice.values())
		{ 
			choices.add(new SelectItem(choice , choice.getType()));
		}
	}

}
