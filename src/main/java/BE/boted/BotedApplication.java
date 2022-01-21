package BE.boted;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BotedApplication {

	public static void main(String[] args) {
		SpringApplication.run(BotedApplication.class, args);
	}

}
