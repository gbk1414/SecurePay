package com.example.securepay.auth.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;

	@Column
	private String email;

	@Column
	private String password;

	@Column(length = 20)
	private String phone;

	@Column
	@Enumerated(value = EnumType.STRING)
	private UserRole role;

	@Column
	private String regNo;

	@Column(columnDefinition = "boolean default false")
	private boolean isPersonalInfoVerified;

	@OneToMany(mappedBy = "user")
	private List<AccessToken> accessTokens;

	@OneToMany(mappedBy = "user")
	private List<RefreshToken> refreshTokens;

	@OneToMany(mappedBy = "user")
	private List<AccessLog> accessLogs;

	public User() {}

	public User(String name, String email, String password, String phone, UserRole role) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.role = role;
	}
}
