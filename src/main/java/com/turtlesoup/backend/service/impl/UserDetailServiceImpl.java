package com.turtlesoup.backend.service.impl;

import com.turtlesoup.backend.config.security.PrincipalDetails;
import com.turtlesoup.backend.entity.UserEntity;
import com.turtlesoup.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email) // Fetch user by email
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        return new PrincipalDetails(userEntity);
    }
}
