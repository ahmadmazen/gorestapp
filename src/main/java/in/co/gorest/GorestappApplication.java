package in.co.gorest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class GorestappApplication {

	public static void main(String[] args) {

		SpringApplication.run(GorestappApplication.class, args);
	}

}
