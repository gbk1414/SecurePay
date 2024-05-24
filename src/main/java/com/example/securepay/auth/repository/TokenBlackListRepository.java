package com.example.securepay.auth.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.securepay.auth.entity.TokenBlackList;

public interface TokenBlackListRepository extends JpaRepository<TokenBlackList, Long> {
    Optional<TokenBlackList> findByJti(String jti);
    List<TokenBlackList> findAllByExpiresAtLessThan(Date now);
}
