package com.jm.studentsapi.tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.jm.studentsapi.student.Student;
import com.jm.studentsapi.student.StudentRepository;

@DataJpaTest
public class StudentRepositoryTest {
	@Autowired
	private StudentRepository underTest;
	
	@AfterEach 
	void tearDown() {
		underTest.deleteAll();
	}
	
	@Test
	void itShouldSelectExistsEmail() {
		Student student = new Student(
				"Celyn",
				"celyn@gmail.com",
				LocalDate.of(2000, 01,20));
		underTest.save(student);
		//when
		boolean expected = underTest.findStudentByEmail(student.getEmail());
		//then
		assertThat(expected).isTrue();
		
	}
	
	@Test
	void itShouldCheckWhenEmailDoesNotExist() {
		String email = "email.come";
		//when
		boolean expected = underTest.findStudentByEmail(email);
		//then
		assertThat(expected).isFalse();
		
	}

}
