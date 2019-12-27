package ru.kpfu.icmit.Yakovlev.pharmancy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("ru.kpfu.icmit.Yakovlev.pharmancy.repository")
public class PharmancyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PharmancyApplication.class, args);
	}

}
