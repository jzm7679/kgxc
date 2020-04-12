package com.common.util.jwt;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * JWT
 * @author JiaZM
 * @date 2020/4/10 17:04
 */
public class JwtUtil {

    /**
     * 过期时间
     * */
    private static final long EXPIRE_TIME = 24 * 60 * 60 * 1000;

    /**
     * token私钥
     * */
    private static final String TOKEN_SECRET = "8f99d61eb5723d2be04eadb29a4815a5";

    private static final String USERNAME = "username";

    private static final String USER_ID= "userId";

    /**
     * 校验token
     * @param token 密钥
     * @return 是否正确
     * */
    public static boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * 获取token中的username信息
     * @return token中包含的username
     * */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(USERNAME).asString();
        } catch (JWTDecodeException ex) {
            return null;
        }
    }

    /**
     * 获取token中的userId
     * @return token中包含的userId
     * */
    public static String getUserId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(USER_ID).asString();
        } catch (JWTDecodeException ex) {
            return null;
        }
    }

    /**
     * 生成签名
     * @param username 用户名
     * @param userId 用户ID
     * @return 加密的token
     * */
    public static String sign(String username, String userId) {
        try {
            // 过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            // 私钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            // 头部信息
            Map<String, Object> header = new HashMap<>();
            header.put("type", "JWT");
            header.put("alg", "HS256");
            // username + userId
            return JWT.create()
                    .withHeader(header)
                    .withClaim("username", username)
                    .withClaim("userId", userId)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception ex) {

            return null;
        }
    }

}
