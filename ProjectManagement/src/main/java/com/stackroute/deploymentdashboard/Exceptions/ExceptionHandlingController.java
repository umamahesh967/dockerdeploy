package com.stackroute.deploymentdashboard.Exceptions;

	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.validation.BindingResult;
	import org.springframework.web.bind.MethodArgumentNotValidException;
	import org.springframework.web.bind.annotation.ControllerAdvice;
	import org.springframework.web.bind.annotation.ExceptionHandler;

	

@ControllerAdvice   
public class ExceptionHandlingController {
    
    @ExceptionHandler(ProjectNotFoundException.class)
    public ResponseEntity<CustomExceptionResponse> handleProjectNotFoundException(Exception ex) {
        CustomExceptionResponse errorResponse = new CustomExceptionResponse();

        errorResponse.setErrorCode(HttpStatus.NOT_FOUND.value());


        errorResponse.setErrorMessage("project not available");
        return new ResponseEntity<CustomExceptionResponse>(errorResponse, HttpStatus.OK);
    }


    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomExceptionResponse> handleGenericException(Exception ex) {
        CustomExceptionResponse errorResponse = new CustomExceptionResponse();
        errorResponse.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());

        errorResponse.setErrorMessage("There is some techncal issue");
        return new ResponseEntity<CustomExceptionResponse>(errorResponse, HttpStatus.OK);
    }
 
}
		

