package com.lisovskiy.kinogluk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories("com.lisovskiy.kinogluk")
//@EntityScan("com.lisovskiy.kinogluk")
@SpringBootApplication
public class KinoglukApplication {

	public static void main(String[] args) {
		SpringApplication.run(KinoglukApplication.class, args);
	}

}
