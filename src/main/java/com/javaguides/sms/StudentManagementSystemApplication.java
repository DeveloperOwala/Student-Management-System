package com.javaguides.sms;

import com.javaguides.sms.entity.Student;
import com.javaguides.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
//		Student student2 = new Student("Erick", "Okumu", "otienoerick@gmail.com");
//		studentRepository.save(student2);
//
//		Student student3 = new Student("Denis", "Opondo", "opndodenis@gmail.com");
//		studentRepository.save(student3);
	}
}
