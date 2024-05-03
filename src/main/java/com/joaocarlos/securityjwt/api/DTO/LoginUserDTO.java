package com.joaocarlos.securityjwt.api.DTO;

import lombok.Data;

@Data
public class LoginUserDTO {
    private String email;
    private String password;
}
