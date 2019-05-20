package test.org.nanotek.artist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nanotek.integration.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@ContextConfiguration("classpath:META-INF/spring/music_brainz_artist_integration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestIntegrationContext {

	@Autowired 
	ApplicationContext applicationContext;


	@Test
	public void test() throws InterruptedException 
	{ 
		int i =0; 
		while (i < 10){
			Thread.sleep(10000);
			i++;
		}
	}

	public static void main(String[] args)
	{ 
		ClassPathXmlApplicationContext applicationContext  = new ClassPathXmlApplicationContext(new String[] {"META-INF/spring/music_brainz_artist_integration.xml"});
	}
}
