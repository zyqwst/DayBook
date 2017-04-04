/**
 * 
 */
package com.albert.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 *
 */
@RestController
public class CommonController extends BaseController{
	@RequestMapping(value={"/","index"})
	public String index(HttpServletRequest request){
		System.out.println(request.getRequestURI());
		return "系统已成功启动";
	}
}
