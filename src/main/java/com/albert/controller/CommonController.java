/**
 * 
 */
package com.albert.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 *
 */
@RestController
public class CommonController {
	@RequestMapping(value={"/","index"})
	public String index(){
		return "系统已成功启动";
	}
	@RequestMapping("fuck")
	public String fuck(){
		return "系统已成功启ddd动";
	}
}
