package com.albert.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;

import com.albert.domain.RestEntity;
import com.albert.utils.RequestMap;

public abstract class BaseController implements ErrorController{
	
	@Autowired
	private ApplicationContext context;  
	protected static final String ERROR_PATH = "/error";  
	
	protected HttpSession getSession(HttpServletRequest request){
		return request.getSession();
	}
	protected ServletContext getServletContext(HttpServletRequest request){
		return request.getServletContext();
	}
	
	@RequestMapping(value=ERROR_PATH)  
    public RestEntity error404(){  
        return RestEntity.failed("错误的资源路径", "404");  
    }
	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}
	public ApplicationContext getContext() {
		return context;
	}
	public void setContext(ApplicationContext context) {
		this.context = context;
	}
	
	public RequestMap getRequestMap(HttpServletRequest request){
		return new RequestMap(request);
	}
}
