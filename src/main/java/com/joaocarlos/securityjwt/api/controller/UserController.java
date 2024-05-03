package com.joaocarlos.securityjwt.api.controller;

import com.joaocarlos.securityjwt.api.DTO.LoginUserDTO;
import com.joaocarlos.securityjwt.api.DTO.RecoveryJwtTokenDTO;
import com.joaocarlos.securityjwt.api.DTO.RecoveryUserDTO;
import com.joaocarlos.securityjwt.api.DTO.RegisterUserDTO;
import com.joaocarlos.securityjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RecoveryUserDTO createUser(@RequestBody RegisterUserDTO user){
        return userService.signup(user);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public RecoveryJwtTokenDTO authenticateUser(@RequestBody LoginUserDTO loginUserDTO){
        return userService.authenticate(loginUserDTO);
    }

    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public String getAuthenticationTest() {
        return "Autenticado com sucesso";
    }

    @GetMapping("/test/user")
    @ResponseStatus(HttpStatus.OK)
    public String getUserAuthenticationTest() {
        return "Cliente autenticado com sucesso";
    }

    @GetMapping("/test/admin")
    @ResponseStatus(HttpStatus.OK)
    public String getAdminAuthenticationTest() {
        return "Administrador autenticado com sucesso";
    }
}
