package com.javaguides.sms.controller;

import com.javaguides.sms.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.javaguides.sms.service.StudentService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudent());
		
		return "students";
	}

	@GetMapping("/students/new")
	public String createStudentForm(Model model){
		// create student object to hold student form data

		Student student = new Student();
		model.addAttribute("student", student);

		return "create_student";
	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
		return  "redirect:/students";
	}

	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model){
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model){
		//get existing student from database by Id
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());

		//save updated  student object
		studentService.updateStudent(existingStudent);

		return "redirect:/students";
	}
	//student handler to delete student request
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id){
      studentService.deleteStudentById(id);

      return "redirect:/students";
	}


}
