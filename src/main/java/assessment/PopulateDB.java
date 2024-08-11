package assessment;

import assessment.dto.AccountDto;
import assessment.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.Currency;

@Configuration
public class PopulateDB {

	private static final Logger log = LoggerFactory.getLogger(PopulateDB.class);

	@Bean
	CommandLineRunner initDatabase(AccountRepository repository) {

		return args -> {
			log.info("Loading new account " + repository.save(new AccountDto("Test", Currency.getInstance("EUR"), new BigDecimal("100.00"), true)));
			log.info("Loading new account " + repository.save(new AccountDto("Test 2", Currency.getInstance("EUR"), new BigDecimal("100.00"), false)));
		};
	}
}
