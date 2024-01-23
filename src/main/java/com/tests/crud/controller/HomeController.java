package com.tests.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tests.crud.Repo.StudentRepo;
import com.tests.crud.entity.Student;

@RestController
public class HomeController {

	@Autowired
	StudentRepo sr;
	@GetMapping("/")
	public String index() {
		return "hello";
	}
	
	@PostMapping("/add")
	public Student add(@RequestBody Student std) {
		Student u =sr.save(std);
		return u;
		
	}
	@GetMapping("/shoe")
	public List<Student> show(){
		List<Student> res=(List<Student>) sr.findAll();
		return res;
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		
		Student s1=sr.findById(id).get();
		if(s1!=null) {
			sr.deleteById(id);
			return "deleted";
		}
		return "not dele";
		
	}
	
	@PutMapping("/put")
	public Student update(@RequestBody Student std) {
		
		Student s1=sr.save(std);
		return s1;
		
	}
}
