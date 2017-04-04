package com.albert.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public abstract class BaseController {
	
	@Autowired
	private  
	ApplicationContext context;  
	
	protected HttpSession getSession(HttpServletRequest request){
		return request.getSession();
	}
	protected ServletContext getServletContext(HttpServletRequest request){
		return request.getServletContext();
	}
	
	public ApplicationContext getContext() {
		return context;
	}
	public void setContext(ApplicationContext context) {
		this.context = context;
	}
}
