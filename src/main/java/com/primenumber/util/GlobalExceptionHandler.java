package com.primenumber.util;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.HandlerMethod;

import com.primenumber.bean.ExceptionBean;

@ControllerAdvice
public class GlobalExceptionHandler {

	Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	
	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<?> exceptionNullPointer(Exception ex , HandlerMethod handlerMethod ,HttpServletRequest request){
		ExceptionBean eb=new ExceptionBean();
		eb.setStatusCode(500);
		eb.setControllerName((handlerMethod.getMethod().getDeclaringClass()).toString());
		eb.setServicePath(request.getRequestURL().toString());
		eb.setLogTime(new Date(System.currentTimeMillis()));
		eb.setMessage(ex.toString());
		eb.setMethodName(handlerMethod.getMethod().getName());
		logger.error(" {} ",eb);
		return new ResponseEntity<>("{\"message\":\""+ex.getMessage()+"\"}", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
