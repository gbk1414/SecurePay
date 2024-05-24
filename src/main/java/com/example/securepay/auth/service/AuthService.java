package com.example.securepay.auth.service;

public interface AuthService {
    /**
     * Refresh Token 의 유효성을 체크한 후 Access Token 을 발급
     * @param refreshToken : Http Header 에서 추출한 Refresh Token
     * @return Access Token
     */
    String refreshAccessToken(String refreshToken);
}
