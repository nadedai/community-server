package com.example.polls.security;

import com.example.polls.exception.ResourceNotFoundException;
import com.example.polls.model.User;
import com.example.polls.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


//要对用户进行身份验证或执行各种基于角色的检查，Spring security需要以某种方式加载用户详细信息
//为此，它由一个名为UserDetailsService的接口组成，该接口有一个基于用户名-加载用户的方法
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    //Spring security使用。注意findByUsernameOrEmail方法的使用。这允许用户使用用户名或电子邮件登录。
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
        );

        return UserPrincipal.create(user);
    }

    //loadUserByUsername()方法返回一个UserDetails对象，Spring Security使用该对象执行各种身份验证和基于角色的验证。
    //将由稍后定义的JWTAuthenticationFilter使用
    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("User", "id", id)
        );

        return UserPrincipal.create(user);
    }
}