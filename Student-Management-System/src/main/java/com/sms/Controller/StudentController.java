package com.sms.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.sms.Entity.Student;
import com.sms.Service.StudentService;

@Controller
public class StudentController {
	
	private StudentService service;
	public StudentController(StudentService service) {
		super();
		this.service = service;
	}
	
	//handler method to handle listStudents and return model and view
	@GetMapping("/students")
	public String listSTudents(Model model) {
		
		model.addAttribute("students",service.getAllStudents());
		return "students";		
	}
	
	@GetMapping("/students/new")
	public String addStudent(Model model) {
		Student student= new Student();
		model.addAttribute("student",student);
		return "student_form";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		service.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable Long id,Model model) {
	model.addAttribute("student",service.getStudentById(id));
	return "edit_student";
		
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,@ModelAttribute("student") Student student) {
		
		Student exiStudent=service.getStudentById(id);
		exiStudent.setId(id);
		exiStudent.setFirstName(student.getFirstName());
		exiStudent.setLastName(student.getLastName());
		exiStudent.setEmail(student.getEmail());
		service.saveStudent(exiStudent);
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudentById(@PathVariable Long id) {
		service.deleteSTudent(id);
		return "redirect:/students";
	}
	
	
}
