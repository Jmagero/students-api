package com.jm.studentsapi.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/students")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
    	 this.studentService = studentService;
    }
    @GetMapping
	public List<Student> getStudents(){
		return studentService.getStudents();
	}
    @PostMapping
    public void addStudent(@RequestBody Student student) {
    	studentService.addStudent(student);	
    }
    
    @PutMapping(path="{id}")
    public void updateStudent(
    		@PathVariable Long id,
    		@RequestParam(required = false) String email,
    		@RequestParam(required = false) String name
    		) {
    	studentService.updateStudent(id,email, name);
    }
    
    @DeleteMapping(path="{id}")
    public void deleteStudent(@PathVariable Long id){
    	 studentService.deleteStudent(id);
    }

}
