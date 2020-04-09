package com.lisovskiy.kinogluk;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.lisovskiy.kinogluk.repository")
@EntityScan("com.lisovskiy.kinogluk.entity")
@SpringBootApplication
public class KinoglukApplication {

	public static void main(String[] args) {
		SpringApplication.run(KinoglukApplication.class, args);
	}

}
