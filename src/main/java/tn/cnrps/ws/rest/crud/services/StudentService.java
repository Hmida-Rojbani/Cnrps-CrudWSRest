package tn.cnrps.ws.rest.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cnrps.ws.rest.crud.models.Student;
import tn.cnrps.ws.rest.crud.repos.StudentRepos;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepos repos;
	
	public Student getSutudentById(int id) {
		for (Student student : repos.getStudents()) {
			if(student.getId()==id)
				return student;
		}
		
		return null;
	}
	
	public Student addStudent(Student std) {
		List<Student> students = repos.getStudents();
		int id = students.get(students.size()-1).getId();
		
		std.setId(id+1);
		students.add(std);
		return std;
	}

}
