/**
 * 
 */
package com.albert.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
* @ClassName: IndexController 
* @Description: 
* @author albert
* @date 2017年4月20日 下午12:56:40 
*  
*/
@RestController
@RequestMapping("/")
public class IndexController  extends BaseController implements ErrorController {

//	@RequestMapping(value={"","index"})
//	public String index(HttpServletRequest request){
//		System.out.println(request.getRequestURI());
//		return "系统成功启动";
//	}
	@Override
	public String getErrorPath() {
		return null;
	}

}
