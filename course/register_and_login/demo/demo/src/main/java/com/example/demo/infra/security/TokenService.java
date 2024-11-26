package com.example.demo.infra.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
	
	@Value("${api.security.token.secret}")
	private String secret;
}
