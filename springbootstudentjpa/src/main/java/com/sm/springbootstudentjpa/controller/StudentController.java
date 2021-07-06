package com.sm.springbootstudentjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sm.springbootstudentjpa.service.StudentService;
import com.sm.springbootstudentjpa.student.Student;


@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/save")
	public String saveStudent(@RequestBody Student student) {
		studentService.saveStudent(student);
		return "Success";
	}
	
	@GetMapping("/getall")
	public List<Student> getAllStudent()
	{
		return (List<Student>)  studentService.getAllStudent();
	}
	
	@GetMapping("/{studentId}")
	public Student getStudentById(@PathVariable Long studentId) {
		return studentService.getStudentById(studentId);
	}
	
	@GetMapping("/nameSearch1")
	public List<Student> getStudentByName(@RequestParam String firstName,@RequestParam String lastName) {
		return studentService.getStudentByName(firstName,lastName);
	}
	
	@GetMapping("/nameSearch2")
	public List<Student> getStudentsByFirstName(@RequestParam String firstName){
		return studentService.getStudentsByFirstName(firstName);
	}
	
	@GetMapping("/namesearch3")
	public List<Student> getStudentsByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName){
		return studentService.getStudentsByFirstNameAndLastName(firstName, lastName);
	}
	
	@GetMapping("/namesearch4")
	public List<Student> getStudentsByFirstNameOrLastName(@RequestParam String firstName, @RequestParam String lastName){
		return studentService.getStudentsByFirstNameOrLastName(firstName, lastName);
	}
	
	@GetMapping("/namesearch5")
	public List<Student> getStudentsByFirstNameContainsOrLastNameContains(@RequestParam String firstName, @RequestParam String lastName){
		return studentService.getStudentsByFirstNameContainsOrLastNameContains(firstName, lastName);
	}
	
	@GetMapping("/addressSearch")
	public List<Student> getStudentsByAddress(@RequestParam String address){
		return studentService.getStudentsByAddress(address);
	}
	
	@GetMapping("/{age1}")
	public List<Student> getStudentsByAgeLessThan(@PathVariable int age){
		return studentService.getStudentsByAgeLessThan(age);
		
	}
	
	@GetMapping("/{age2}")
	public List<Student> getStudentsByAgeLessThanEqual(@PathVariable int age){
		return studentService.getStudentsByAgeLessThanEqual(age);
	}
	
	@GetMapping("/{age3}")
	public List<Student> getStudentsByAgeGreaterThan(@PathVariable int age){
		return studentService.getStudentsByAgeGreaterThan(age);
	}
    
	@GetMapping("/{age4}")
	public List<Student> getStudentsByAgeGreaterThanEqual(@PathVariable int age){
		return studentService.getStudentsByAgeGreaterThanEqual(age);
	}

}
