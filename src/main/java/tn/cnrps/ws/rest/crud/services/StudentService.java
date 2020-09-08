package tn.cnrps.ws.rest.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cnrps.ws.rest.crud.errors.StudentNotFoundException;
import tn.cnrps.ws.rest.crud.models.Student;
import tn.cnrps.ws.rest.crud.repos.StudentRepos;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepos repos;
	
	public Student getSutudentById(int id) {
		if(id==0) throw new NullPointerException();
		for (Student student : repos.getStudents()) {
			if(student.getId()==id)
				return student;
		}
		throw new StudentNotFoundException("The given id not found in the system");
	}
	
	public List<Student> getSutudents() {
	
		return repos.getStudents();
	}
	
	public Student addStudent(Student std) {
		List<Student> students = repos.getStudents(); 
		int id = students.get(students.size()-1).getId();
		
		std.setId(id+1);
		students.add(std);
		return std;
	}
	
	public Student updateStudent(int id, Student newStudent) {
				
		Student std = repos.getStudents().stream().filter(student -> student.getId()==id)
													.findAny().orElse(null);
		if(std !=null) {
			if(newStudent.getAge()>0)
				std.setAge(newStudent.getAge());
			if(newStudent.getName()!=null)
				std.setName(newStudent.getName());
			if(newStudent.getClasse()!=null)
				std.setClasse(newStudent.getClasse());
		}
		
		return std;
	}

	public Student deleteStudent(int id) {
		Student std = repos.getStudents().stream().filter(student -> student.getId()==id)
				.findAny().orElse(null);
		
		repos.getStudents().remove(std);
		return std;
	}

}
