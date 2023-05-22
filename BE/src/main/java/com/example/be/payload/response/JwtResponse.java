package com.example.be.payload.response;

import java.util.List;

/**
 * Created by: Phạm Tiến
 * Date: 29/03/2023
 * Class: JwtResponse
 */
public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private String username;
    private List<String> roles;
    private String name;
    private Long accountId;



    public JwtResponse(String accessToken, String username, String name,Long accountId, List<String> roles) {
        this.token = accessToken;
        this.username = username;
        this.roles = roles;
        this.name = name;
        this.accountId = accountId;
    }

    public JwtResponse() {
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public String getToken() {
        return token;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
