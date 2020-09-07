package tn.cnrps.ws.rest.crud.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
	
	private int id;
	private String name;
	private int age;
	private String classe;

}
