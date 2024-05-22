package auth.service;

import auth.dto.SignupRequestDto;
import auth.dto.SignupResponseDto;

public interface UserService {
// 	회원가입
	SignupResponseDto register(SignupRequestDto signupRequestDto);
}
