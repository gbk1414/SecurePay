package com.example.securepay.auth.service.impl;


import org.springframework.stereotype.Service;

import com.example.securepay.auth.entity.TokenType;
import com.example.securepay.auth.entity.User;
import com.example.securepay.auth.jwt.JwtProvider;
import com.example.securepay.auth.repository.UserRepository;
import com.example.securepay.auth.service.AuthService;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;

    @Override
    public String refreshAccessToken(String refreshToken) {
        // refreshToken 유효성 검사
        if (!jwtProvider.validateToken(refreshToken)) {
           throw new RuntimeException("Invalid Token");
        }
        // Jwt Claims
        Claims info = jwtProvider.getUserInfoFromToken(refreshToken);

        // User 조회
        User user = userRepository.findByEmail(info.getSubject()).orElseThrow(
                () -> new RuntimeException("Not Found User By : " + info.getSubject())
        );

        return jwtProvider.createToken(jwtProvider.createTokenPayload(user.getEmail(), TokenType.ACCESS));
    }
}
