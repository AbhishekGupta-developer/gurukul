package com.myorganisation.gurukul.service;

import com.myorganisation.gurukul.exception.StudentNotFoundException;
import com.myorganisation.gurukul.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return studentRepository.findByEmail(username).orElseThrow(
                () -> new StudentNotFoundException("Student email: " + username + " doesn't exist")
        );
    }
}
