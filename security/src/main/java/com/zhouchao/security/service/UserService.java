package com.zhouchao.security.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhouchao
 * @Date 2020/10/30 17:56
 * @Description
 **/
@Service
public class UserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!"zhouchao".equals(username)) {
            return null;
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        SimpleGrantedAuthority auth = new SimpleGrantedAuthority("ROLE_ROOT");
        authorities.add(auth);

//        UserDetails user = new User(username,"$2a$10$87qJ3tAQrzQFjrfJIr3WyO1o.YISKt928QRYExIYm338DCme.b9Jm",authorities);
        UserDetails user = new User(username,
                "$2a$10$87qJ3tAQrzQFjrfJIr3WyO1o.YISKt928QRYExIYm338DCme.b9Jm",
                true,
                true,
                true,
                false,
                authorities);

        return user;
    }
}
