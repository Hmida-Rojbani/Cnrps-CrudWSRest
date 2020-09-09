package tn.cnrps.ws.rest.crud.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cnrps.ws.rest.crud.errors.StudentNotFoundException;
import tn.cnrps.ws.rest.crud.models.Student;
import tn.cnrps.ws.rest.crud.repos.StudentEntity;
import tn.cnrps.ws.rest.crud.repos.StudentRepository;

@Service
public class StudentServiceBD implements StudentServiceInter {
	
	@Autowired
	private StudentRepository repos;
	@Autowired
	private ModelMapper mapper;

	@Override
	public Student getSutudentById(int id) {
		StudentEntity std = repos.findById(id).orElseThrow(()->new StudentNotFoundException("This id is not found"));
		return mapper.map(std,Student.class);
	}

	@Override
	public List<Student> getSutudents() {
		List<StudentEntity> stds = (List<StudentEntity>) repos.findAll();
		List<Student> students = stds.stream()
									.map((StudentEntity std)-> {
										return mapper.map(std,Student.class);
									}).collect(Collectors.toList());
		return students;
	}

	@Override
	public Student addStudent(Student student) {
		StudentEntity std = mapper.map(student, StudentEntity.class);
		Student newStudent = mapper.map(repos.save(std),Student.class);
		return newStudent;
	}

	@Override
	public Student updateStudent(int id, Student newStudent) {
		StudentEntity std = repos.findById(id).orElseThrow(()->new StudentNotFoundException("This id is not found"));
		if(std !=null) {
			if(newStudent.getAge()>0)
				std.setAge(newStudent.getAge());
			if(newStudent.getName()!=null)
				std.setName(newStudent.getName());
			if(newStudent.getClasse()!=null)
				std.setClasse(newStudent.getClasse());
		}
		return mapper.map(repos.save(std),Student.class);
	}

	@Override
	public Student deleteStudent(int id) {
		StudentEntity std = repos.findById(id).orElseThrow(()->new StudentNotFoundException("This id is not found"));
		repos.delete(std);
		return mapper.map(std,Student.class);
	}

}
