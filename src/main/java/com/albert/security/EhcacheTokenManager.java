package com.albert.security;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;
@Component
public class EhcacheTokenManager implements TokenManager {
	@Autowired  
	private CacheManager cacheManager;  
	private static String CACHE_NAME = "user_token";
    public TokenModel createToken(Long userId) {
        //使用uuid作为源token
        String token = UUID.randomUUID().toString().replace("-", "");
        TokenModel model = new TokenModel(userId, token);
        //存储到redis并设置过期时间
        cacheManager.getCache(CACHE_NAME).put(userId, token);
        return model;
    }

    public TokenModel getToken(String authentication) {
        if (authentication == null || authentication.length() == 0) {
            return null;
        }
        String[] param = authentication.split("_");
        if (param.length != 2) {
            return null;
        }
        //使用userId和源token简单拼接成的token，可以增加加密措施
        long userId = Long.parseLong(param[0]);
        String token = param[1];
        return new TokenModel(userId, token);
    }

    public boolean checkToken(TokenModel model) {
        if (model == null) {
            return false;
        }
        ValueWrapper token = cacheManager.getCache(CACHE_NAME).get(model.getUserId());
        if(token==null) return false;
        if (token.get() == null || !token.get().equals(model.getToken())) {
            return false;
        }
        return true;
    }

    public void deleteToken(Long userId) {
        cacheManager.getCache(CACHE_NAME).evict(userId);
    }
}