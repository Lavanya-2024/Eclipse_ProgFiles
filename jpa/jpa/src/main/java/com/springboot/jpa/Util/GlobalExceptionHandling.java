package com.springboot.jpa.Util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springboot.jpa.model.EmployeeResponse;
import com.springboot.jpa.model.ErrorInfo;
import com.springboot.jpa.model.Response2;

@ControllerAdvice // which means that this class will be able to handle the exceptions occurred from any of the Controllers
public class GlobalExceptionHandling extends ResponseEntityExceptionHandler{
	

    @ExceptionHandler(EmployeenotfoundException.class) //annotation is required to handle the type of exceptions which are thrown 
    public ResponseEntity<Object> handleExceptions( EmployeenotfoundException employeenotfoundException) {
        Response2 response2 = new Response2();
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorinformation(employeenotfoundException.getMessage());
        
        List<ErrorInfo> errorslist = new ArrayList<ErrorInfo>();
        errorslist.add(errorInfo);   // the reason here adding errorInfo is , to get output like list type otherwise we can add directly to employeeResponse 
       
        response2.setErrors(errorslist);
        
        return new ResponseEntity<>(response2,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidEmailException.class) //annotation is required to handle the type of exceptions which are thrown 
    public ResponseEntity<Object> handleExceptions() {
        Response2 response2 = new Response2();
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorinformation("Invalid EmailId, Enter Correct Email Id");
        
        List<ErrorInfo> errorslist = new ArrayList<ErrorInfo>();
        errorslist.add(errorInfo);   // the reason here adding errorInfo is , to get output like list type otherwise we can add directly to employeeResponse 
       
        response2.setErrors(errorslist);
        
        return new ResponseEntity<>(response2,HttpStatus.INTERNAL_SERVER_ERROR);
    } 
}
