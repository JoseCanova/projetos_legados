package org.hubotek.tests.search.adapter;

import java.util.HashMap;
import java.util.Map;

import org.hubotek.google.search.CustomSearchAdapter;
import org.hubotek.google.search.SearchParameterEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration("/org/hubotek/tests/controller/google/hubotek-servlet.xml")
public class CustomSearchAdapterTest extends TestCase{

	@Deprecated
	@Test
	public void testQueryStringBuildingOutput()
	{ 
		CustomSearchAdapter csa = new CustomSearchAdapter();
		Map<SearchParameterEnum,String> parameters = new HashMap<SearchParameterEnum,String>();
		parameters.put(SearchParameterEnum.QUERY, "spring+framework");
		parameters.put(SearchParameterEnum.OUTPUT, "atom");
		parameters.put(SearchParameterEnum.USER_LANGUAGE, "en");
	}
	
}
