package com.example.demosecurity.services;

import com.example.demosecurity.entities.CustomUserDetail;
import com.example.demosecurity.entities.User;
import com.example.demosecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("Not found with given username"));
        return new CustomUserDetail(user);
    }
}
