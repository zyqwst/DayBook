/**
 * 
 */
package com.albert.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.albert.dao.CommonDao;
import com.albert.domain.table.User;
import com.albert.security.EhcacheTokenManager;
import com.albert.security.TokenModel;
import com.albert.service.UserService;
import com.albert.utils.BookException;
import com.albert.utils.MD5;
import com.albert.utils.Value;

/** 
* @ClassName: UserServiceImpl 
* @Description: 
* @author albert
* @date 2017年4月27日 下午1:59:09 
*  
*/
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Resource
	private CommonDao commonDao;
	@Resource 
	private EhcacheTokenManager tokenManager;
	@Override
	public void save(User user) throws BookException {
		commonDao.save(user);
	}

	@Override
	public void login(User user) throws BookException {
		User u = null;
		if(user.getId()!=null){
			u = commonDao.findEntity(User.class, " where id=? ", new Value().add(user.getId()).getParams());
		}else if(!StringUtils.isEmpty(user.getName())){
			u = commonDao.findEntity(User.class, " where name=? or alias=? ", new Value().add(user.getName()).add(user.getName()).getParams());
		}
		if(u==null) throw new BookException("用户名或密码不存在");
		if(!new MD5(u.getPassword()).compute().equals(user.getPassword().toUpperCase())){
			throw new BookException("用户名或密码不存在");
		}
		TokenModel token =tokenManager.createToken(u.getId());
		user.setId(u.getId());
		user.setToken(token.getToken());
	}
	@Override
	public void logout(User user) throws BookException {
		tokenManager.deleteToken(user.getId());
	}
	public CommonDao getCommonDao() {
		return commonDao;
	}

	public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}

	public EhcacheTokenManager getTokenManager() {
		return tokenManager;
	}

	public void setTokenManager(EhcacheTokenManager tokenManager) {
		this.tokenManager = tokenManager;
	}

}
