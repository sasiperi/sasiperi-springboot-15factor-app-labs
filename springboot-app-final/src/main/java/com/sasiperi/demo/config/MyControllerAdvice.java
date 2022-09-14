package com.sasiperi.demo.config;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class MyControllerAdvice {
	
	
	/****
     * 
     * Following are the exceptions turning HTTP-500 server errors to HTTP-400 Bad Request
     * Invalid input
     */
    @ExceptionHandler({EntityNotFoundException.class,NoSuchElementException.class})
    @ResponseStatus(value=HttpStatus.NOT_FOUND,reason="SP-ERR001: No data available mathcing the criteria")
    public void handleNoDataAvailable(HttpServletRequest request, Exception ex)
    {
          log.warn("SP-ERR001: No data available mathcing the criteria UR L= "+request.getRequestURL(), ex);
    
    }

}
