package com.joaocarlos.securityjwt.service.impl;

import com.joaocarlos.securityjwt.domain.entity.User;
import com.joaocarlos.securityjwt.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("Usuário não encontrado"));
    }
}
