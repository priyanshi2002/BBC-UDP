package com.bbc.ubp.BBCUBP.security;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.bbc.ubp.BBCUBP.entity.Customer;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class Security {
	private static final int EXPIRATION_TIME = 360000;
//	private static final String SECRET_KEY = "Priyanshi";
	SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

	public String generateToken(Customer employee) {
		// Set the JWT Claims
		return Jwts.builder().setSubject("user123").signWith(key).compact();
	}
}
