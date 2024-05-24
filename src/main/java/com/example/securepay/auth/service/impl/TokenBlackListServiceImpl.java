package com.example.securepay.auth.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.securepay.auth.entity.TokenBlackList;
import com.example.securepay.auth.entity.TokenType;
import com.example.securepay.auth.jwt.JwtProvider;
import com.example.securepay.auth.repository.TokenBlackListRepository;
import com.example.securepay.auth.service.TokenBlackListService;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TokenBlackListServiceImpl implements TokenBlackListService {

    private final JwtProvider jwtProvider;
    private final TokenBlackListRepository tokenBlackListRepository;

    @Override
    public void addToBlacklist(String accessToken, String refreshToken) {
        Claims accessClaims = jwtProvider.getUserInfoFromToken(accessToken);
        Claims refreshClaims = jwtProvider.getUserInfoFromToken(refreshToken);

        tokenBlackListRepository.save(new TokenBlackList(
                accessToken,
                accessClaims.getId(),
                TokenType.ACCESS,
                accessClaims.getExpiration()
        ));

        tokenBlackListRepository.save(new TokenBlackList(
                refreshToken,
                refreshClaims.getId(),
                TokenType.REFRESH,
                refreshClaims.getExpiration()
        ));
    }

    @Override
    public boolean isTokenBlacklisted(String jti) {
        Optional<TokenBlackList> tokenByJti = tokenBlackListRepository.findByJti(jti);
        return tokenByJti.isPresent();
    }

    @Override
    public void removeExpiredTokens() {
        List<TokenBlackList> expiredList = tokenBlackListRepository.findAllByExpiresAtLessThan(new Date());
        tokenBlackListRepository.deleteAllInBatch(expiredList);
    }
}
