package com.digitalharbor.myhospital.domain.dto;

public class AuthenticacionResponse {
    private String jwt;

    public AuthenticacionResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
