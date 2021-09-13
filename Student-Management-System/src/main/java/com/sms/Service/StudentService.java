package com.sms.Service;

import java.util.List;

import com.sms.Entity.Student;

public interface StudentService {
	
	List<Student> getAllStudents();
	public Student getStudentById(Long id);
	public Student saveStudent(Student student);
	public Student updateStudent(Student student);
	public void deleteSTudent(Long id);

}
