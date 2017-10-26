package com.Project.Management.Exceptions;

	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.validation.BindingResult;
	import org.springframework.web.bind.MethodArgumentNotValidException;
	import org.springframework.web.bind.annotation.ControllerAdvice;
	import org.springframework.web.bind.annotation.ExceptionHandler;

	@ControllerAdvice
	public class ExceptionHandlingController extends Exception {
		
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<CustomExceptionResponse> invalidInput(MethodArgumentNotValidException exception) {
			
			BindingResult result = exception.getBindingResult();
	        CustomExceptionResponse exceptionresponse = new CustomExceptionResponse();
	        
	        exceptionresponse.setErrorMessage("Invalid Inputs.");
	        exceptionresponse.setErrors(result.getFieldErrors().get(0).getDefaultMessage());
	        
	        return new ResponseEntity<CustomExceptionResponse>(exceptionresponse, HttpStatus.BAD_REQUEST);
		}
		
		
		
		
	}
