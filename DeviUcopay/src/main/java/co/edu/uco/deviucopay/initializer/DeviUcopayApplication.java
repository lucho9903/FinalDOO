package co.edu.uco.deviucopay.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.uco.deviucopay"})
public class DeviUcopayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeviUcopayApplication.class, args);
	}

}
