package com.albert.utils;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.albert.domain.RestEntity;

@ControllerAdvice
 public class GlobalExceptionHandler {
	 @ExceptionHandler//处理所有异常
     @ResponseBody 
     public RestEntity exceptionHandler(RuntimeException e, HttpServletResponse response) {
         return RestEntity.failed(e.getMessage(), "500");
     }
 }