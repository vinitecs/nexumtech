package br.com.nexum.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JWTUtil {

	@Value("${jwt.secret}")
	public String secret;
	
	@Value("${jwt.expiration}")
	public Long expiration;
}
