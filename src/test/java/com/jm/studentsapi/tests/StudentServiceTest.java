package com.jm.studentsapi.tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jm.studentsapi.student.Student;
import com.jm.studentsapi.student.StudentRepository;
import com.jm.studentsapi.student.StudentService;


@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
	@Mock
	private StudentRepository studentRepository;
	private StudentService underTest;
	
	@BeforeEach
	void SetUp(){
		underTest = new StudentService(studentRepository);
	}
	
	@Test
	void canGetAllStudents() {
		//given
		 underTest.getStudents();
		//when
		 verify(studentRepository).findAll();
	}
	@Test
	void canAddStudent() {
		//given
		Student student = new Student(
				"Arnold",
				"arnold@gmail.com",
				LocalDate.of(2000, 01,20));
		//when
		 underTest.addStudent(student);
		//given
		 ArgumentCaptor<Student> studentArgumentCaptor = 
				 ArgumentCaptor.forClass(Student.class);
		 
		 verify(studentRepository).save(studentArgumentCaptor.capture());
		 Student capturedStudent =studentArgumentCaptor.getValue();
		 assertThat(capturedStudent).isEqualTo(student);
		 
	}

}
