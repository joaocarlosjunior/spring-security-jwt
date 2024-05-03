package com.joaocarlos.securityjwt.service.impl;

import com.joaocarlos.securityjwt.api.DTO.LoginUserDTO;
import com.joaocarlos.securityjwt.api.DTO.RecoveryJwtTokenDTO;
import com.joaocarlos.securityjwt.api.DTO.RecoveryUserDTO;
import com.joaocarlos.securityjwt.api.DTO.RegisterUserDTO;
import com.joaocarlos.securityjwt.domain.entity.User;
import com.joaocarlos.securityjwt.domain.repository.UserRepository;
import com.joaocarlos.securityjwt.service.JwtService;
import com.joaocarlos.securityjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IUserService implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public RecoveryUserDTO signup(RegisterUserDTO user) {
        User newUser = User
                .builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getPassword()))
                .role(user.getRole())
                .build();

        User userCreated = userRepository.save(newUser);

        return RecoveryUserDTO
                .builder()
                .firstName(userCreated.getFirstName())
                .lastName(userCreated.getLastName())
                .email(userCreated.getEmail())
                .role(userCreated.getRole())
                .build();
    }

    public RecoveryJwtTokenDTO authenticate(LoginUserDTO loginUser){
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(loginUser.getEmail(), loginUser.getPassword());

            Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

            User user = (User) authentication.getPrincipal();

            return RecoveryJwtTokenDTO
                    .builder()
                    .token(jwtService.generateToken(user))
                    .build();
    }
}
