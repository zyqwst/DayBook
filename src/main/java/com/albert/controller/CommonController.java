/**
 * 
 */
package com.albert.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.albert.domain.RestEntity;

/**
 * @author Administrator
 *
 */
@RestController
public class CommonController extends BaseController implements ErrorController {
	@RequestMapping(value={"/","index"})
	public String index(HttpServletRequest request){
		System.out.println(request.getRequestURI());
		return "系统已成功启动";
	}
	private static final String ERROR_PATH = "/error";  
	   
	 @RequestMapping(value=ERROR_PATH)  
    public RestEntity error404(){  
        return RestEntity.failed("错误的资源路径", "404");  
    }

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}  
   
}
