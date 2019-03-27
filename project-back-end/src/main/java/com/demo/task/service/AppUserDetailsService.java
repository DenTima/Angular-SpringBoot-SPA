package com.demo.task.service;

import java.util.Arrays;

import com.demo.task.dao.UserRepository;
import com.demo.task.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class AppUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);

        if(user == null) {
            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", s));
        }
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getRole());
        UserDetails details = new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getEncodedPassword(), Arrays.asList(grantedAuthority));
        return details;
    }
}
