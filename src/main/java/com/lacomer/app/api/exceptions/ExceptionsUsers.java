package com.lacomer.app.api.exceptions;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsUsers {

	 @ExceptionHandler(Exception.class)
	    public ProblemDetail handleSecurityException(Exception ex) {
		 ProblemDetail errorDetail = null;
		 
	        if (ex instanceof NoSuchElementException) {
	            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403), ex.getMessage());
	            errorDetail.setProperty("message_error", "Usuario no existe");
	            errorDetail.setProperty("code_error", "100");
	        }
	        
	        return errorDetail;
	        
	 	}
}
