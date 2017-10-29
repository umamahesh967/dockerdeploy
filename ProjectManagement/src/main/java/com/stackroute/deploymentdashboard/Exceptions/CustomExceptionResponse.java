
package com.stackroute.deploymentdashboard.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.stackroute.deploymentdashboard.Exceptions.*;



public class CustomExceptionResponse extends Exception{
    private int errorCode;
    private String errorMessage;
    
    public int getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
 
}
