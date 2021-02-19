package com.fstt.userservice.security;

public interface SecurityParameters {
    public static final String JWT_HEADER_NAME = "Authorization";
    public static final String SECRET = "yasserarraf011@gmail.com";
    public static final long EXPIRATION = 10*24*3600*1000;
    public static final String HEADER_PREFIX = "Bearer ";
}
