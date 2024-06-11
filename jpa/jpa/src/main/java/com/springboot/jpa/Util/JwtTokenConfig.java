package com.springboot.jpa.Util;

import java.security.Key;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.crypto.spec.SecretKeySpec;

import com.springboot.jpa.model.Register;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.xml.bind.DatatypeConverter;


public class JwtTokenConfig {
	private static String SECRET_KEY = "avatar";
	
	public static Claims decodeJWT(String jwt) throws Exception {
		
		try {
			Claims claims = Jwts.parser()
		            .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
		            .parseClaimsJws(jwt).getBody();
		    return claims;
		} catch (Exception e) {
			// TODO: handle exception
			
			throw new Exception("Invalid token"+e);
		}
	    
	}

	public static String createJWT(String id, String issuer, String subject, long ttlMillis,Register register) {

		// The JWT signature algorithm we will be using to sign the token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		// We will sign our JWT with our ApiKey secret
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		// Let's set the JWT Claims
		JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now).setSubject(subject).setIssuer(issuer).claim("userdata", register)
				.signWith(signatureAlgorithm, signingKey);

		// if it has been specified, let's add the expiration
		if (ttlMillis > 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}

		// Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();
	}

	public static void main(String[] args) throws Exception {
		
		
		String token = createJWT("demoproject", "ibm", "srihari", 1000*60*60,null);
		System.out.println(token);
		
		Claims claims =	decodeJWT(token);
		  LinkedHashMap atmdata=  claims.get("userdata", LinkedHashMap.class);
		  System.out.println(atmdata);
		  System.out.println(atmdata.get("accountNumber"));
		  
		  
		  
	}

}
