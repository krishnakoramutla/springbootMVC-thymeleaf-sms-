package com.sms.Service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sms.Entity.Student;
import com.sms.Repository.StudentRepository;
import com.sms.Service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	private StudentRepository repository;
	
	public StudentServiceImpl(StudentRepository repository) {
		super();
		this.repository = repository;
	}


	@Override
	public List<Student> getAllStudents() {
		
		return repository.findAll();
	}


	@Override
	public Student saveStudent(Student student) {
		
		return repository.save(student);
	}


	@Override
	public Student updateStudent(Student student) {
		return repository.save(student);
	}


	@Override
	public void deleteSTudent(Long id) {
		repository.deleteById(id);
		
	}


	@Override
	public Student getStudentById(Long id) {
		
		return repository.findById(id).get();
	}

}
