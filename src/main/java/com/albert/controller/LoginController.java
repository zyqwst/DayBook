/**
 * 
 */
package com.albert.controller;

import javax.annotation.Resource;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
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
	public RestEntity login(@RequestBody User user){
		try {
			if(user==null){
				throw new BookException("用户名密码不可为空");
			}
			if(StringUtils.isEmpty(user.getName())){
				throw new BookException("请输入用户名");
			}
			if(StringUtils.isEmpty(user.getPassword())){
				throw new BookException("请输入密码");
			}
			if(com.albert.utils.StringUtils.isNumeric(user.getName())){
				user.setId(Long.parseLong(user.getName()));
			}else{
				user.setName(user.getName());
			}
			userService.login(user);
			return RestEntity.success(user);
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
