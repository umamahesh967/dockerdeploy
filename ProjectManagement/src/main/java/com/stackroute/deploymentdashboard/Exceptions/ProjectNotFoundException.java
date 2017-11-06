

package com.stackroute.deploymentdashboard.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.stackroute.deploymentdashboard.Exceptions.*;


public class ProjectNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;
    private String errorMessage;
 
//    public ProjectNotFoundException() {
//        super();
//    }
 
    public ProjectNotFoundException(String errorMessage) {
        super(errorMessage);
    }
 
//    public String getErrorMessage() {
//        return errorMessage;	
//    }
// 
}
