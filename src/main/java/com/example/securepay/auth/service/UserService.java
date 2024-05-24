package com.example.securepay.auth.service;

import com.example.securepay.auth.dto.SignupResponseDto;
import com.example.securepay.auth.dto.SignupRequestDto;

public interface UserService {
	/**
	 * 회원가입
	 * @param signupRequestDto : email, password
	 * @return SignupResponseDto
	 */
	SignupResponseDto register(SignupRequestDto signupRequestDto);
}
