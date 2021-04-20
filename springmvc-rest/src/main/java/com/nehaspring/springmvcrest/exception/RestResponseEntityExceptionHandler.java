package com.nehaspring.springmvcrest.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.nehaspring.springmvcrest.services.ResourceNotFoundException;
// Will be applied to all controolers
@ControllerAdvice
//why resController bcoz it privides a response back
@RestController
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	/*
	 * In following method when ever exception happens we want create instance of our specific Exception Response Bean
	 */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		
		ExceptionResponse expRes = new ExceptionResponse(new Date(), ex.getMessage(), 
								request.getDescription(false));
		return new ResponseEntity<>(expRes , HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//Now for Customized Exception we need to override the above method.
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleNotFoundException(ResourceNotFoundException ex, WebRequest request){
		
		ExceptionResponse expRes = new ExceptionResponse(new Date(), ex.getMessage(), 
				request.getDescription(false));
		return new ResponseEntity<>(expRes , HttpStatus.NOT_FOUND);
	}
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		//ExceptionResponse expRes = new ExceptionResponse(new Date(), ex.getMessage(), 
		//		ex.getBindingResult().toString());
		//ex.getMessage() gives too much details
		
		//Note Here in ExceptionResponse last argument is details for which we are providing the BindingResult which
		//will tell what went wrong.
		
		ExceptionResponse expRes = new ExceptionResponse(new Date(), "Validation Failed", 
				ex.getBindingResult().toString());
		
		return new ResponseEntity<>(expRes , HttpStatus.BAD_REQUEST);
	}

	
}
