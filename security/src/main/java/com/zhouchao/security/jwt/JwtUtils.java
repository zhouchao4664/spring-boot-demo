package com.zhouchao.security.jwt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Map;

/**
 * @Author zhouchao
 * @Date 2020/12/25 14:52
 * @Description
 **/
@Slf4j
public class JwtUtils {
    public final static String USERNAME = "username";
    public final static String CREATED = "created";
    public final static String AUTHORITIES = "authorities";


    private static String SECRET_KEY = "wojiushisuibianyixiefanzhengniyebuzhidao";

    private static Key getKeyInstance() {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] keySecretByte = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key key = new SecretKeySpec(keySecretByte, signatureAlgorithm.getJcaName());
        return key;
    }

    /**
     * 生成token
     *
     * @param payload
     * @return
     */
    public static String generatorToken(Map<String, Object> payload) {
        ObjectMapper objectMapper = new ObjectMapper();
        String token = null;
        try {
            token = Jwts.builder().setPayload(objectMapper.writeValueAsString(payload))
                    .signWith(SignatureAlgorithm.HS256, getKeyInstance()).compact();
        } catch (JsonProcessingException e) {
            log.error("generatorToken:", e);
        }
        return token;
    }

    /**
     * 根据token解析出内容
     *
     * @param token
     * @return
     */
    public static Claims parseToken(String token) {
        Jws<Claims> claimsJwt = Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(token);
        return claimsJwt.getBody();
    }
}
