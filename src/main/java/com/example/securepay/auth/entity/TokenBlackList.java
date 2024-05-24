package com.example.securepay.auth.entity;

import java.util.Date;

import com.example.securepay.global.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class TokenBlackList extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String token;

    @Column
    private String jti;

    @Column
    @Enumerated(value = EnumType.STRING)
    private TokenType tokenType;

    @Column
    private Date expiresAt;

    public TokenBlackList() {}

    public TokenBlackList(String token, String jti, TokenType tokenType, Date expiresAt) {
        this.token = token;
        this.jti = jti;
        this.tokenType = tokenType;
        this.expiresAt = expiresAt;
    }
}
