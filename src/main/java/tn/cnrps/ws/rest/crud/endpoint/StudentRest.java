package tn.cnrps.ws.rest.crud.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.cnrps.ws.rest.crud.models.Student;
import tn.cnrps.ws.rest.crud.services.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentRest {
	
	@Autowired
	private StudentService service;
	
	@GetMapping(path="/id/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
											 MediaType.APPLICATION_XML_VALUE})
	public Student getStudentWithId(@PathVariable("id")int id) {
		return service.getSutudentById(id);
	}
	
	@GetMapping()
	public List<Student> getStudents() {
		return service.getSutudents();
	}
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
			 MediaType.APPLICATION_XML_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE,
					 MediaType.APPLICATION_XML_VALUE})
	public Student createStudent(@RequestBody Student std) {
		return service.addStudent(std);
	}
	
	@PutMapping("/id/{id}")
	public Student updateStudent(@PathVariable("id")int id,@RequestBody Student newStd) {
		return service.updateStudent(id, newStd) ;
	}
	
	@DeleteMapping("/id/{id}")
	public Student deleteStudent(@PathVariable("id")int id) {
		return service.deleteStudent(id) ;
	}

}
