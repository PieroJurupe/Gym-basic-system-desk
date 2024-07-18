package com.jc.gymbasicsystemfront.api;

import com.jc.gymbasicsystemfront.utils.TokenManager;

/**
 *
 * @author jcaritam
 */
public class ApiManager {

    private static ApiManager instance;
    private GymBasicSystemApi gymApi;
    private TokenManager tokenManager;

    private ApiManager() {
        this.tokenManager = new TokenManager();
        this.gymApi = new GymBasicSystemApi("http://localhost:8083/api/v1", tokenManager);
    }

    public static ApiManager getInstance() {
        if (instance == null) {
            instance = new ApiManager();
        }
        return instance;
    }

    public GymBasicSystemApi getGymApi() {
        return gymApi;
    }

    public TokenManager getTokenManager() {
        return tokenManager;
    }

}
