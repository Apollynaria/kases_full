package com.example.backend.jwt;

import com.example.backend.model.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

@Component
public class JwtUtils {

    @Value("${jwt.secret.access}")
    private String jwtSecret;

    @Value("${jwt.secret.expirationMs}")
    private int jwtExpirationMs;

    public String generateJwtToken(User userAuth) {
        User user = userAuth;
        SecretKey a = new SecretKeySpec(jwtSecret.getBytes(), "HmacSHA512");
        return Jwts.builder()
                .setSubject((user.getLogin()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(a)
                .compact();
    }

    public String getLoginFromJwtToken(String token) {
        SecretKey a = new SecretKeySpec(jwtSecret.getBytes(), "HmacSHA512");
        return Jwts.parserBuilder().setSigningKey(a).build().parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            SecretKey a = new SecretKeySpec(jwtSecret.getBytes(), "HmacSHA512");
            Jwts.parserBuilder().setSigningKey(a).build().parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            System.out.println("Invalid JWT signature" + " " + e.getMessage());
        } catch (MalformedJwtException e) {
            System.out.println("Invalid JWT token" + " " + e.getMessage());
        } catch (ExpiredJwtException e) {
            System.out.println("JWT token is expired" + " " + e.getMessage());
        } catch (UnsupportedJwtException e) {
            System.out.println("JWT token is unsupported" + " " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("JWT claims string is empty" + " " + e.getMessage());
        }
        return false;
    }
}
