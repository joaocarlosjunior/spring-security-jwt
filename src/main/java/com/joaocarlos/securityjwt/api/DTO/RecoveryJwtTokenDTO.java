package com.joaocarlos.securityjwt.api.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RecoveryJwtTokenDTO {
    private String token;
}
