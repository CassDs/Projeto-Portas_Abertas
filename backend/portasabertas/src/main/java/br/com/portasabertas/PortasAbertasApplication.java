package br.com.portasabertas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.com.portasabertas.dao")
public class PortasAbertasApplication {
	public static void main(String[] args) {
		SpringApplication.run(PortasAbertasApplication.class, args);
	}

}
