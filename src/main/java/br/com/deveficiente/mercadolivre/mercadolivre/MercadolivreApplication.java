package br.com.deveficiente.mercadolivre.mercadolivre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class MercadolivreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MercadolivreApplication.class, args);
	}
}
