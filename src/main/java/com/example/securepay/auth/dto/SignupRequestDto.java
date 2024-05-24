package com.example.securepay.auth.dto;

import com.example.securepay.auth.entity.UserRole;

import lombok.Getter;

@Getter
public class SignupRequestDto {
	private String name;
	private String email;
	private String password;
	private String phone;
	private UserRole userRole = UserRole.USER;
}
