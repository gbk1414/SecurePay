package com.example.securepay.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.securepay.auth.entity.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
}
