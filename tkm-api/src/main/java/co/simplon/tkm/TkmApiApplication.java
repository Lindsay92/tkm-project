package co.simplon.tkm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
//a delete par la suite
public class TkmApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TkmApiApplication.class, args);
	}

}
