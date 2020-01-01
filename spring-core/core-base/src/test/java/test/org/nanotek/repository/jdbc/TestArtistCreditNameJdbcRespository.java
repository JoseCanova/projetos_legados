package test.org.nanotek.repository.jdbc;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.nanotek.repository.jdbc.ArtistCreditNameJdbcRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;

import test.org.nanotek.TestConfiguration;

@ContextConfiguration(classes = {TestConfiguration.class})
@SpringBootTest(webEnvironment = WebEnvironment.MOCK , classes= {ArtistCreditNameJdbcRepository.class})
class TestArtistCreditNameJdbcRespository {

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
