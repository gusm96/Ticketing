package com.ticketez.customerservice.util;


import com.ticketez.customerservice.domain.RoleType;
import com.ticketez.customerservice.domain.jwt.Token;
import com.ticketez.customerservice.domain.jwt.TokenInfo;
import com.ticketez.customerservice.exception.custom.ExpiredTokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

@Slf4j
@Component
public class JwtUtil {
    private static SecretKey hashedSecretKey;
    private final static Long ACCESS_TOKEN_EXPIRATION = 5 * 60 * 1000L;
    private final static Long REFRESH_TOKEN_EXPIRATION = 15 * 24 * 60 * 60 * 1000L;

    private static SecretKey getHashedSecretKey(String secret) {
        if (hashedSecretKey == null)
            return Keys.hmacShaKeyFor(
                    Base64.getEncoder().encodeToString(secret.getBytes()).getBytes());
        return hashedSecretKey;
    }

    // Access Token 생성
    public static Token createToken(Long customerId, RoleType roleType, String secret) {
        Claims claims = Jwts.claims()
                .add("idx", customerId)
                .add("role", roleType)
                .build();
        return Token.builder()
                .accessToken(jwtBuild(claims, ACCESS_TOKEN_EXPIRATION, secret))
                .refreshToken(jwtBuild(claims, REFRESH_TOKEN_EXPIRATION, secret))
                .build();
    }
    // Refresh Token 생성

    private static String jwtBuild(Claims claims, Long expiration, String secret) {
        return Jwts.builder()
                .claims(claims)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getHashedSecretKey(secret))
                .compact();
    }

    // 토큰 검증
    private static void validateTokenExpiration(Date expiration) {
        if (expiration != null && expiration.before(new Date())) {
            // 토큰 만료
            throw new ExpiredTokenException("토큰이 만료되었습니다.");
        }
    }

    // 토큰 정보 조회
    public static TokenInfo getTokenInfo(String token, String secret) {
        // 토큰을 해독한다.
        try {
            Claims claims = getTokenClaims(token, secret);
            validateTokenExpiration(claims.getExpiration());

            return TokenInfo.builder()
                    .customerId((Long) claims.get("idx"))
                    .roleType((RoleType) claims.get("role"))
                    .build();
        } catch (ExpiredTokenException e) {
            throw new ExpiredTokenException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new JwtException(e.getMessage());
        }
    }

    private static Claims getTokenClaims(String token, String secret) {
        return (Claims) Jwts.parser()
                .verifyWith(getHashedSecretKey(secret))
                .build()
                .parse(token).getPayload();
    }

    // Access Token 재발급
}
