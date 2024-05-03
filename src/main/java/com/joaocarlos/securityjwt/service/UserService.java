package com.joaocarlos.securityjwt.service;

import com.joaocarlos.securityjwt.api.DTO.RecoveryUserDTO;

import java.util.List;

public interface UserService {
    List<RecoveryUserDTO> allUsers();

    RecoveryUserDTO infoUser();
}
