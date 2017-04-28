/**
 * 
 */
package com.albert;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import com.albert.security.TokenManager;
import com.albert.security.TokenModel;

/** 
* @ClassName: EhcacheTest 
* @Description: 
* @author albert
* @date 2017年4月28日 下午3:16:42 
*  
*/
public class EhcacheTest extends AppTest{
	@Autowired
    private TokenManager manager;
	@org.junit.Test
	public void test(){
		TokenModel token = manager.createToken(1234578l);
		System.out.println("加入缓存前："+token);
		boolean b = manager.checkToken(token);
		System.out.println(b);
		manager.deleteToken(token.getUserId());
		System.out.println(manager.checkToken(token));
	}
}
