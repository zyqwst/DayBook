/**
 * 
 */
package com.albert.controller;

import javax.annotation.Resource;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.albert.domain.RestEntity;
import com.albert.domain.table.User;
import com.albert.service.UserService;
import com.albert.utils.BookException;

/** 
* @ClassName: LoginController 
* @Description: 
* @author albert
* @date 2017年4月27日 下午1:24:19 
*  
*/
@RestController
@RequestMapping("/account")
public class LoginController extends BaseController {	
	@Resource
	private UserService userService;
	@RequestMapping("/login")
	public RestEntity login(String username ,String password){
		try {
			if(StringUtils.isEmpty(username)){
				throw new BookException("请输入用户名");
			}
			if(StringUtils.isEmpty(password)){
				throw new BookException("请输入密码");
			}
			User user = new User();
			user.setPassword(password);
			if(com.albert.utils.StringUtils.isNumeric(username)){
				user.setId(Long.parseLong(username));
			}else{
				user.setName(username);
			}
			userService.login(user);
			return RestEntity.success();
		} catch (BookException e) {
			e.printStackTrace();
			return RestEntity.failed(e.getMessage());
		}
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
