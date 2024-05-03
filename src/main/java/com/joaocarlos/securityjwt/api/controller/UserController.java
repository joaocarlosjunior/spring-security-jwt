package com.joaocarlos.securityjwt.api.controller;

import com.joaocarlos.securityjwt.api.DTO.RecoveryUserDTO;
import com.joaocarlos.securityjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public String getAuthenticationTest() {
        return "Autenticado com sucesso";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RecoveryUserDTO> allUsers(){
        return userService.allUsers();
    }

    @GetMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public RecoveryUserDTO getUserInfo() {
        return userService.infoUser();
    }

    @GetMapping("/admin")
    @ResponseStatus(HttpStatus.OK)
    public String getAdminAuthenticationTest() {
        return "Administrador autenticado com sucesso";
    }
}
