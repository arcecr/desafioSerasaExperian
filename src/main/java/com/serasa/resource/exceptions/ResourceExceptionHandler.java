package com.serasa.resource.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.serasa.service.exception.DataIntegrationViolationException;
import com.serasa.service.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException ex, 
			                                                     HttpServletRequest request){
		StandardError error = new StandardError(System.currentTimeMillis(), 
				                                HttpStatus.NO_CONTENT.value(),
				                                "No Content", 
				                                ex.getMessage(), 
				                                request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}

	@ExceptionHandler(DataIntegrationViolationException.class)
	public ResponseEntity<StandardError> dataIntegrationViolationException(DataIntegrationViolationException ex, 
			                                                     HttpServletRequest request){
		StandardError error = new StandardError(System.currentTimeMillis(), 
				                                HttpStatus.BAD_REQUEST.value(),
				                                "Violação de Dados", 
				                                ex.getMessage(), 
				                                request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validationErrors(MethodArgumentNotValidException ex, 
			                                                     HttpServletRequest request){
		ValidationError errors = new ValidationError(System.currentTimeMillis(), 
				                                HttpStatus.BAD_REQUEST.value(),
				                                "Validation Error", 
				                                "Erro na validação dos campos", 
				                                request.getRequestURI());
		for(FieldError x: ex.getBindingResult().getFieldErrors()) {
			errors.addErrors(x.getField(), x.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
		
	}	
}

