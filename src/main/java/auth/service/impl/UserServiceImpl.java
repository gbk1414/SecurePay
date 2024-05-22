package auth.service.impl;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import auth.dto.SignupRequestDto;
import auth.dto.SignupResponseDto;
import auth.entity.User;
import auth.repository.UserRepository;
import auth.service.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public SignupResponseDto register(SignupRequestDto signupRequestDto) {

		Optional<User> user = userRepository.findByEmail(signupRequestDto.getEmail());
		if (user.isPresent()) {
			throw new RuntimeException("Email already in use");
		}

		User newUser = new User(signupRequestDto.getName(),
			signupRequestDto.getEmail(),
			passwordEncoder.encode(signupRequestDto.getPassword()),
			signupRequestDto.getPhone(),
			signupRequestDto.getUserRole());

		userRepository.save(newUser);

		return new SignupResponseDto(newUser.getId(), newUser.getName(), newUser.getEmail(), newUser.getPhone());
	}
}
