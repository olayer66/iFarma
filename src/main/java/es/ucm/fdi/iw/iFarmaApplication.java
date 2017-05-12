package es.ucm.fdi.iw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class iFarmaApplication {

	public static void main(String[] args) {
		SpringApplication.run(iFarmaApplication.class, args);
	}
}
