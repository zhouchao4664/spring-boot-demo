package com.zhouchao.security.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhouchao.security.dao.SysUserMapper;
import com.zhouchao.security.domain.SysUser;
import com.zhouchao.security.jwt.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser sysUser = findByUserName(username);
        if (sysUser == null) return null;

        //这里可以根据业务设置权限
        List<GrantedAuthority> authorities = new ArrayList<>();
        SimpleGrantedAuthority auth = new SimpleGrantedAuthority("ROLE_ROOT");
        authorities.add(auth);

//        UserDetails user = new User(username,"$2a$10$87qJ3tAQrzQFjrfJIr3WyO1o.YISKt928QRYExIYm338DCme.b9Jm",authorities);
//        UserDetails user = new User(username,
//                "$2a$10$87qJ3tAQrzQFjrfJIr3WyO1o.YISKt928QRYExIYm338DCme.b9Jm",
//                true,
//                true,
//                true,
//                true,
//                authorities);

        JwtUser user = new JwtUser();
        user.setId(sysUser.getId());
        user.setUsername(sysUser.getName());
        user.setPassword(sysUser.getPwd());

        return user;
    }

    public SysUser findByUserName(String name) {
        return sysUserMapper.selectOne(new QueryWrapper<SysUser>().lambda().eq(SysUser::getName, name));
    }
}
