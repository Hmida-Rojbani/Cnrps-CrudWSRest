package tn.cnrps.ws.rest.crud.services;

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

}
