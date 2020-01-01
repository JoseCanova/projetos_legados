package test.org.nanotek.repository.jdbc;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK , classes = {org.springframework.boot.test.context.TestConfiguration.class})
@EnableAutoConfiguration(exclude={RabbitAutoConfiguration.class})
class TestArtistCreditNameJdbcRespository {

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
