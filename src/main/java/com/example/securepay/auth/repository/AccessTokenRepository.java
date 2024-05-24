package com.example.securepay.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.securepay.auth.entity.AccessToken;

public interface AccessTokenRepository extends JpaRepository<AccessToken, Long> {
}
