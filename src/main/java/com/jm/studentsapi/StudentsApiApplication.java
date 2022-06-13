package com.jm.studentsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@RestController
public class StudentsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsApiApplication.class, args);
	}
	
//	@GetMapping
//	public List<Student> helo() {
//		return List.of(new Student(
//				1,
//				"Mariam",
//				"mariam@gmail.ome",
//				LocalDate.of(2000, 01,20),
//				21));
//	}
	
	
}
