package test.org.nanotek;

import java.util.Optional;

import org.nanotek.Base;
import org.nanotek.beans.entity.Artist;

public class TestBaseShit {

	public TestBaseShit() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Optional<Artist> artist = Base.newInstance(Artist.class);
		artist.ifPresent(a -> System.out.println("Artist is present"));
	}

}
