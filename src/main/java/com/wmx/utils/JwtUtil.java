package com.wmx.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.wmx.pojo.entity.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wmx
 * @daata 2020/7/28
 */
public class JwtUtil {

    //设置过期时间
    private static final long EXPIRE_TIME =   15 * 60 *1000;

    //设置服务器密钥
    private static final String TOKEN_SECRET = "123123123123123123123123";

    /**
     * 加密方法
     * @param user 要存储的信息
     * @return  返回token
     */
    public static String sign(User user){
        try {
            //设置过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            //HMAC256对信息进行编码
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            Map<String, Object> header = new HashMap<>(2);
            header.put("type","JWT");
            header.put("alg","hS256");
            return JWT.create()
                    .withHeader(header)
                    .withClaim("loginUser",user.getUsername()).withClaim("userId",user.getId())
                    .withExpiresAt(date).sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 验证token合法性
     * @param token
     * @return
     */
    public static boolean verify(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
