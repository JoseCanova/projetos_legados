package org.hubotek.test.document;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.tika.config.TikaConfig;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;
import org.junit.Test;

public class TestMediaTypeDetection {


	@Test
	public void should_detecte_media_type() throws Exception
	{ 
		TikaConfig tikaConfig = new TikaConfig();
		List<File> fileList = new ArrayList<File>();

		fileList.add(new File("C:/Java/git_repo/model/src/test/resources/xml/news_atom.xml"));
		fileList.add(new File("C:/Java/git_repo/model/src/test/resources/xml/news_atom.atom"));
		fileList.add(new File("C:/Java/git_repo/model/src/test/resources/xml/google_news_feed.rss"));
		fileList.add(new File("C:/Java/git_repo/model/src/test/resources/json/results_google.json"));
		fileList.add(new File("C:/Java/git_repo/model/src/test/resources/xml/google_news_feed1.xml"));

		for (File f : fileList) {
			Metadata metadata = new Metadata();
			metadata.set(Metadata.RESOURCE_NAME_KEY, f.toString());
			MediaType mimetype = tikaConfig.getDetector().detect(
					TikaInputStream.get(new FileInputStream(f)), metadata);
			System.out.println("File " + f + " is " + mimetype.getType() + "/" + mimetype.getSubtype());

			AutoDetectParser parser = new AutoDetectParser();
			BodyContentHandler handler = new BodyContentHandler();
			parser.parse(new FileInputStream(f), handler, metadata);
			System.out.println("Tike parsed " + handler.toString());
		}

		/*for (InputStream is : myListOfStreams) {
		   String mimetype = tika.getDetector().detect(
		        TikaInputStream.get(is), new Metadata());
		   System.out.println("Stream " + is + " is " + mimetype);
		}*/
	}

}
