package tn.cnrps.ws.rest.crud.errors;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
	
	private String type;
	private String msg;

}
