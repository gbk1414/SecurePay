package com.example.securepay.auth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.securepay.auth.dto.SignupRequestDto;
import com.example.securepay.auth.dto.SignupResponseDto;
import com.example.securepay.auth.entity.TokenType;
import com.example.securepay.auth.jwt.JwtProvider;
import com.example.securepay.auth.service.AuthService;
import com.example.securepay.auth.service.TokenBlackListService;
import com.example.securepay.auth.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

	private final JwtProvider jwtProvider;
	private final AuthService authService;
	private final UserService userService;
	private final TokenBlackListService tokenBlackListService;

	@Operation(summary = "회원가입")
	@PostMapping("/signup")
	public ResponseEntity<SignupResponseDto> signup(@RequestBody SignupRequestDto signupRequestDto) {
		SignupResponseDto signupResponseDto = userService.register(signupRequestDto);
		return ResponseEntity.ok(signupResponseDto);
	}

	@Operation(summary = "로그아웃")
	@GetMapping("/logout")
	public ResponseEntity<Void> logout(HttpServletRequest request) {
		tokenBlackListService.addToBlacklist(
			jwtProvider.getJwtFromHeader(request, TokenType.ACCESS),
			jwtProvider.getJwtFromHeader(request, TokenType.REFRESH)
		);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@Operation(summary = "Token Refresh")
	@GetMapping("/refresh")
	public ResponseEntity<String> refresh(HttpServletRequest request) {
		String accessToken = authService.refreshAccessToken(jwtProvider.getJwtFromHeader(request, TokenType.REFRESH));
		return ResponseEntity.ok(accessToken);
	}

	@Operation(summary = "Token Blacklist (Batch) : Batch 서버에서 주기적으로 Expired 된 토큰 제거")
	@DeleteMapping("/blacklist")
	public ResponseEntity<Void> resetBlacklist() {
		tokenBlackListService.removeExpiredTokens();
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
