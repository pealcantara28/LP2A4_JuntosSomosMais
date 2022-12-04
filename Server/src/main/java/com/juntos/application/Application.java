package com.juntos.application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.juntos.api", "com.juntos.services", "com.juntos.infra"} )
@EntityScan("com.juntos.domain.entities")
@EnableJpaRepositories("com.juntos.infra")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
