package co.simplon.tkm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@SpringBootApplication
public class TkmApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TkmApiApplication.class, args);
	}

}
