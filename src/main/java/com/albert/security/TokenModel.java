package com.albert.security;
/**
 * Token
 * @author Administrator
 *
 */
public class TokenModel {
    // 用户 id
    private long userId;
    // 随机生成的 uuid
    private String token;
    public TokenModel (long userId, String token) {
        this.userId = userId;
        this.token = token;
    }
    public long getUserId () {
        return userId;
    }
    public void setUserId (long userId) {
        this.userId = userId;
    }
    public String getToken () {
        return token;
    }
    public void setToken (String token) {
        this.token = token;
    }
}