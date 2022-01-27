package com.javaguides.sms.service;

import java.util.List;

import com.javaguides.sms.entity.Student;

public interface StudentService {
	List<Student> getAllStudent();

	Student saveStudent(Student student);

	Student getStudentById(Long id);

	Student updateStudent(Student student);

	void deleteStudentById(Long id);

}
