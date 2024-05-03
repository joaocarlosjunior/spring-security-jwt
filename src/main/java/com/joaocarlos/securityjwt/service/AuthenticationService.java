package com.joaocarlos.securityjwt.service;

import com.joaocarlos.securityjwt.api.DTO.LoginUserDTO;
import com.joaocarlos.securityjwt.api.DTO.RecoveryJwtTokenDTO;
import com.joaocarlos.securityjwt.api.DTO.RecoveryUserDTO;
import com.joaocarlos.securityjwt.api.DTO.RegisterUserDTO;

public interface AuthenticationService {
    RecoveryUserDTO signup(RegisterUserDTO user);
    RecoveryJwtTokenDTO authenticate(LoginUserDTO loginUser);
}
