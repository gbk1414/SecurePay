package com.example.securepay.global.utils;

import java.util.Objects;

import jakarta.servlet.http.HttpServletRequest;

public class HttpRequestUtils {
    public static String getUserAgent(HttpServletRequest request){
        return Objects.nonNull(request.getHeader("user-agent")) ? request.getHeader("user-agent") : "";
    }

    public static String getRemoteAddr(HttpServletRequest request){
        return Objects.nonNull(request.getHeader("X-FORWARDED-FOR")) ? request.getHeader("X-FORWARDED-FOR") : request.getRemoteAddr();
    }
}
