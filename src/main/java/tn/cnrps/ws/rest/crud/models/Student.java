package tn.cnrps.ws.rest.crud.models;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Student {
	
	private int id;
	@NotBlank
	private String name;
	@NotNull@Positive
	private int age;

	private String classe;

}
