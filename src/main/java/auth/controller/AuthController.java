package auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import auth.dto.SignupRequestDto;
import auth.dto.SignupResponseDto;
import auth.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
	private final UserService userService;

	@PostMapping("/signup")
	public ResponseEntity<SignupResponseDto> signup(@RequestBody SignupRequestDto signupRequestDto) {
		SignupResponseDto signupResponseDto = userService.register(signupRequestDto);
		return ResponseEntity.ok(signupResponseDto);
	}
}
