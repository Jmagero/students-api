package com.jm.studentsapi.student;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	@Autowired
	public StudentService(StudentRepository studentRepository) {
       this.studentRepository = studentRepository;
	}
	
	public List<Student> getStudents(){
		return studentRepository.findAll();
	}
	
	public void addStudent(Student student) {
		Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
		if(studentByEmail.isPresent()) {
			throw new IllegalStateException("Email taken");
		}
		studentRepository.save(student);
	}
	@Transactional
	public void updateStudent(Long id, String email, String name) {
		Optional<Student> student = studentRepository.findById(id);
		if(!student.isPresent()) {
			throw new IllegalStateException("Student not found");
		}
		student.get().setEmail(email);
		student.get().setName(name);
		
	}
	
	public void deleteStudent(Long id) {
		boolean exits = studentRepository.existsById(id);
		if(!exits) {
			throw new IllegalStateException("Student doesn't exits");
		}
		studentRepository.deleteById(id);
	}
	
	
}
