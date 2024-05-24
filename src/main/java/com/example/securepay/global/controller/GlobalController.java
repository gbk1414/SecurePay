package com.example.securepay.global.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.v3.oas.annotations.Operation;

@Controller
public class GlobalController {

	@Operation(summary = "홈페이지")
	@GetMapping("/")
	public String mainPage(){
		return "homepage";
	}

	@Operation(summary = "로그인 페이지")
	@GetMapping("/auth/login-page")
	public String loginPage(){
		return "login";
	}

	@Operation(summary = "회원가입 페이지")
	@GetMapping("/auth/signup")
	public String signupPage(){
		return "signup";
	}
}
