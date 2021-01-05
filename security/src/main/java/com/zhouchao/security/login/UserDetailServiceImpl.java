package com.zhouchao.security.login;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhouchao.security.dao.SysUserMapper;
import com.zhouchao.security.domain.SysUser;
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
public class UserDetailServiceImpl implements UserDetailsService {

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

        UserDetails user = new User(username,
                sysUser.getPwd(),
                true,
                true,
                true,
                true,
                authorities);

        return user;
    }

    public SysUser findByUserName(String name) {
        return sysUserMapper.selectOne(new QueryWrapper<SysUser>().lambda().eq(SysUser::getName, name));
    }
}
