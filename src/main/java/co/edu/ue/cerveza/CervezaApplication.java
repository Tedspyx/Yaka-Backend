package co.edu.ue.cerveza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan(basePackages = {"co.edu.ue.cerveza.model"})
@EnableJpaRepositories(basePackages = {"co.edu.ue.cerveza.repository"})
@ComponentScan(basePackages = {"co.edu.ue.cerveza.service","co.edu.ue.cerveza.controller","co.edu.ue.cerveza"})
public class CervezaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CervezaApplication.class, args);
	}

}
