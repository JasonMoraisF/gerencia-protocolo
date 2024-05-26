package br.com.gerenciaprotocolo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GerenciaProtocoloApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciaProtocoloApplication.class, args);
	}

}
