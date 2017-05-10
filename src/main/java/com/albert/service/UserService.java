/**
 * 
 */
package com.albert.service;

import com.albert.domain.table.User;
import com.albert.utils.BookException;

/** 
* @ClassName: UserService 
* @Description: 
* @author albert
* @date 2017年4月27日 下午1:55:16 
*  
*/
public interface UserService {
	public void save(User user) throws BookException;
	public void login(User user) throws BookException;
}
