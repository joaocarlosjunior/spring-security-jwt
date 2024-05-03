package com.joaocarlos.securityjwt.api.DTO;

import com.joaocarlos.securityjwt.domain.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class RecoveryUserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
}
