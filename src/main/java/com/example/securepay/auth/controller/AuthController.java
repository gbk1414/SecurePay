package com.example.securepay.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.securepay.auth.dto.SignupRequestDto;
import com.example.securepay.auth.dto.SignupResponseDto;
import com.example.securepay.auth.jwt.JwtProvider;
import com.example.securepay.auth.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

	private final JwtProvider jwtProvider;
	private final UserService userService;

	@Operation(summary = "회원가입")
	@PostMapping("/signup")
	public ResponseEntity<SignupResponseDto> signup(@RequestBody SignupRequestDto signupRequestDto) {
		SignupResponseDto signupResponseDto = userService.register(signupRequestDto);
		return ResponseEntity.ok(signupResponseDto);
	}
}
