package tn.cnrps.ws.rest.crud.services;

import java.util.List;

import tn.cnrps.ws.rest.crud.models.Student;

public interface StudentServiceInter {
	Student getSutudentById(int id);
	List<Student> getSutudents();
	Student addStudent(Student std);
	Student updateStudent(int id, Student newStudent);
	Student deleteStudent(int id);
}
