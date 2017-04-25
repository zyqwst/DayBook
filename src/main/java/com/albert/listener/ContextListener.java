package com.albert.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class ContextListener implements ServletContextListener, HttpSessionListener {

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		System.out.println(" *** ContextListener 初始化");
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.out.println(" *** ContextListener 销毁");
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println(" *** ContextListener.  session创建!");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println(" *** ContextListener. session销毁");
	}
}