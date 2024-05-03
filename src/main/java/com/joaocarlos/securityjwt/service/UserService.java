package com.joaocarlos.securityjwt.service;

import com.joaocarlos.securityjwt.api.DTO.LoginUserDTO;
import com.joaocarlos.securityjwt.api.DTO.RecoveryJwtTokenDTO;
import com.joaocarlos.securityjwt.api.DTO.RecoveryUserDTO;
import com.joaocarlos.securityjwt.api.DTO.RegisterUserDTO;
import com.joaocarlos.securityjwt.domain.entity.User;
import com.joaocarlos.securityjwt.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

public interface UserService {
    RecoveryUserDTO signup(RegisterUserDTO user);
    RecoveryJwtTokenDTO authenticate(LoginUserDTO loginUser);
}
