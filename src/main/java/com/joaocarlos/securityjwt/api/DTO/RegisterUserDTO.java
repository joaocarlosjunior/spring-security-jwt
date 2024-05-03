package com.joaocarlos.securityjwt.api.DTO;

import com.joaocarlos.securityjwt.domain.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class RegisterUserDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
}
