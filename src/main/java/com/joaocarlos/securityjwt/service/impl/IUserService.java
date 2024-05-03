package com.joaocarlos.securityjwt.service.impl;

import com.joaocarlos.securityjwt.api.DTO.RecoveryUserDTO;
import com.joaocarlos.securityjwt.domain.entity.User;
import com.joaocarlos.securityjwt.domain.repository.UserRepository;
import com.joaocarlos.securityjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IUserService implements UserService {
    private final UserRepository userRepository;

    public List<RecoveryUserDTO> allUsers() {
        List<RecoveryUserDTO> users = new ArrayList<>();

        userRepository
                .findAll()
                .forEach(user -> {
                    users.add(
                            RecoveryUserDTO
                                    .builder()
                                    .firstName(user.getFirstName())
                                    .lastName(user.getLastName())
                                    .email(user.getEmail())
                                    .role(user.getRole())
                                    .build()
                    );
                });

        return users;
    }

    @Override
    public RecoveryUserDTO infoUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();

        return RecoveryUserDTO
                .builder()
                .firstName(currentUser.getFirstName())
                .lastName(currentUser.getLastName())
                .email(currentUser.getEmail())
                .role(currentUser.getRole())
                .build();
    }
}
