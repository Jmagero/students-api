package com.jm.studentsapi.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	@Bean
	CommandLineRunner commandRunner(StudentRepository repository) {
		return args -> {
			Student mariam = new Student(
					"Mariam",
					"mariam@gmail.ome",
					LocalDate.of(2000, 01,20)
					);
			Student alex = new Student(
					"Alex",
					"alex@gmail.ome",
					LocalDate.of(2004, 01,20)
					);
			repository.saveAll(List.of(mariam,alex));
					
		};
	}

}
