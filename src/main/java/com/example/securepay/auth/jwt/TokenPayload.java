package com.example.securepay.auth.jwt;

import java.util.Date;

import lombok.Getter;

@Getter
public class TokenPayload {
	private String sub;
	private String jti;
	private Date iat;
	private Date expiresAt;

	public TokenPayload(String sub, String jti, Date iat, Date expiresAt) {
		this.sub = sub;
		this.jti = jti;
		this.iat = iat;
		this.expiresAt = expiresAt;
	}
}
