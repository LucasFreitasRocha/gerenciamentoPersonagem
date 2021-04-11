package com.gp.exceptions;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest req) {
		StandardError error = new StandardError(HttpStatus.NOT_FOUND, "Não encontrado", e.getMessage(),
				req.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<StandardError> badException(BadRequestException e, HttpServletRequest req) {
		StandardError error = new StandardError(HttpStatus.BAD_REQUEST, "Bad Request", e.getMessage(),
				req.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<StandardError> constraintViolation(ConstraintViolationException e, HttpServletRequest req) {

		e.getConstraintViolations().forEach(cv -> {
			System.out.println(cv);
		});
		StandardError error = new StandardError(HttpStatus.BAD_REQUEST, "Bad Request", e.getMessage(),
				req.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	 public ResponseEntity<StandardError> constraintViolation( MethodArgumentNotValidException e , HttpServletRequest req){
		
		
		 StandardError error = new StandardError( HttpStatus.BAD_REQUEST, "Bad Request","campos Invalidos ou Faltando", req.getRequestURI());
		 e.getFieldErrors().forEach( validError ->
		 {
			 error.getFieldsErros().add(new FieldsErros(validError.getField(), validError.getDefaultMessage()) ); 
		});
		 
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	 }
	@ExceptionHandler(HttpMessageNotReadableException.class)
	 public ResponseEntity<StandardError> constraintViolation( HttpMessageNotReadableException e , HttpServletRequest req){
		String texto;
		int numero1 = e.getMessage().toLowerCase().indexOf("string".toLowerCase());
		texto = e.getMessage().substring(numero1 + 8);
		int numero2 = texto.toLowerCase().indexOf(";".toLowerCase());
		texto = texto.substring(0, numero2);
		System.out.println(texto);
		 StandardError error = new StandardError( HttpStatus.BAD_REQUEST, "Bad Request , Enum Incorreto",texto, req.getRequestURI());
		
		 
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	 }
	

}
