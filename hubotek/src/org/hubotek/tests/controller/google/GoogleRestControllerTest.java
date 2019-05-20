package org.hubotek.tests.controller.google;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hubotek.google.news.GoogleNewsUrlParametersEnum;
import org.hubotek.tests.TestException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration("/org/hubotek/tests/controller/google/hubotek-servlet.xml")
public class GoogleRestControllerTest {

	@Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
    	this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).alwaysExpect(status().isOk()).build();
//        this.mockMvc = MockMvcBuilders.standaloneSetup(new GoogleRestController()).build();
    }
    
	@Test
	public void testNewsEndPoint() {
		try {
			 MockHttpServletResponse ra = mockMvc.perform(get("/news").param(GoogleNewsUrlParametersEnum.CODE.getUrlParameter(), "en").param("cf", "all").param("pz" , "1").param("topic" , "tc").param("output", "rss").param("siidp", "3181f56d83fa79d45987ac941b28f6d0e885").param("key", "AIzaSyDh0Bmqa-9RQIpASA1tNATVsD_PZF3CJRQ").param("ict","ln").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
			 System.out.println(new String(ra.getContentAsByteArray()));
		} catch (Exception e) {
			throw new TestException(e);
		}
	}

	@Test
	public void testSearchEndPoint() {
		try {
			 MockHttpServletResponse ra = mockMvc.perform(get("/search").param(GoogleNewsUrlParametersEnum.CODE.getUrlParameter(), "en").param("cf", "all").param("pz" , "1").param("topic" , "tc").param("output", "rss").param("siidp", "3181f56d83fa79d45987ac941b28f6d0e885").param("key", "AIzaSyDh0Bmqa-9RQIpASA1tNATVsD_PZF3CJRQ").param("ict","ln").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
			 System.out.println(new String(ra.getContentAsByteArray()));
		} catch (Exception e) {
			throw new TestException(e);
		}
	}

	
}