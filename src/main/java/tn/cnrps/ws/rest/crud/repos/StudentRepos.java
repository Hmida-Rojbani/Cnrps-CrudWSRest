package tn.cnrps.ws.rest.crud.repos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import tn.cnrps.ws.rest.crud.models.Student;

@Repository
@Getter
public class StudentRepos {
	
	private List<Student> students;
	
	{
		students = new ArrayList<Student>();
		students.add(new Student(1,"std1", 25, "cl1"));
		students.add(new Student(2,"std2", 28, "cl2"));
		students.add(new Student(3,"std3", 26, "cl1"));
		
	}

}
