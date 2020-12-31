package com.zhouchao.security.jwt;

import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @Author zhouchao
 * @Date 2020/12/30 21:04
 * @Description
 **/
@Data
public class JwtToken extends UsernamePasswordAuthenticationToken {

    private String token;

    public JwtToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public JwtToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }
}
