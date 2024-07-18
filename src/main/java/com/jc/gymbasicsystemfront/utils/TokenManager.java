package com.jc.gymbasicsystemfront.utils;

public class TokenManager {

    private String accessToken;

    public String getAccessToken () {
        return accessToken;
    }    
    
    public void setAccessToken (String accessToken){
        this.accessToken = accessToken;
    }
    
    public void removeAccessToken () {
        this.accessToken = null;
    }
}
