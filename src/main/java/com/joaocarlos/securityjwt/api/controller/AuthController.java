package com.joaocarlos.securityjwt.api.controller;

import com.joaocarlos.securityjwt.api.DTO.LoginUserDTO;
import com.joaocarlos.securityjwt.api.DTO.RecoveryJwtTokenDTO;
import com.joaocarlos.securityjwt.api.DTO.RecoveryUserDTO;
import com.joaocarlos.securityjwt.api.DTO.RegisterUserDTO;
import com.joaocarlos.securityjwt.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService userService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public RecoveryUserDTO createUser(@RequestBody RegisterUserDTO user){
        return userService.signup(user);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public RecoveryJwtTokenDTO authenticateUser(@RequestBody LoginUserDTO loginUserDTO){
        return userService.authenticate(loginUserDTO);
    }

}
