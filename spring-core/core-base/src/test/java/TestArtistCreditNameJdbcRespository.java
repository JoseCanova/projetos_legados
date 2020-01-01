import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.nanotek.BaseConfiguration;
import org.nanotek.apachemq.ApacheMqConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK , classes = {BaseConfiguration.class , ApacheMqConfiguration.class})
@EnableAutoConfiguration(exclude={RabbitAutoConfiguration.class})
class TestArtistCreditNameJdbcRespository {

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
