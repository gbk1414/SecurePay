package auth.dto;

import auth.entity.UserRole;
import lombok.Getter;

@Getter
public class SignupRequestDto {
	private String name;
	private String email;
	private String password;
	private String phone;
	private UserRole userRole = UserRole.USER;
}
