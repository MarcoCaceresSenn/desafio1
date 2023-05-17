package ufro.isoft.desafio1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ufro.isoft.desafio1.respository.CamionetaRepository;

@SpringBootApplication
public class Desafio1Application {
	public static void main(String[] args) {
		SpringApplication.run(Desafio1Application.class, args);
		System.out.println("***************Hola mundo*****************");
	}
	@Bean
	CommandLineRunner commandLineRunner(CamionetaRepository camionetaRepository, CamionetaRepository sedanRepository, CamionetaRepository suvRepository) {
		return args -> {
		};
	}
}
