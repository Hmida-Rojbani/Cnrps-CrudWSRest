package tn.cnrps.ws.rest.crud.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentExpHandler {
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ErrorResponse>   StudentNotFoundHandler(StudentNotFoundException e) {
		return new ResponseEntity<>(new ErrorResponse("StudentNotFoundException",e.getMessage()), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<ErrorResponse>   StudentNumberFormatExceptionHandler(NumberFormatException e) {
		return new ResponseEntity<>(new ErrorResponse("Cannot convert to ID (int)",e.getMessage()), HttpStatus.BAD_REQUEST);
	}

}
