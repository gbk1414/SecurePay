package com.example.securepay.auth.service;

public interface TokenBlackListService {
    /**
     * 로그아웃 시 AccessToken, RefreshToken Blacklist 등록
     * @param accessToken
     * @param refreshToken
     */
    void addToBlacklist(String accessToken, String refreshToken);

    /**
     * 해당 Token 이 Blacklist 에 존재하는지 확인
     * @param jti : JWT ID
     * @return boolean
     */
    boolean isTokenBlacklisted(String jti);

    /**
     * 현재 Date 기준으로 Expired 된 Token 들을 Blacklist 에서 제거
     */
    void removeExpiredTokens();
}
