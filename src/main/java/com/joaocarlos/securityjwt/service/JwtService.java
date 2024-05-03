package com.joaocarlos.securityjwt.service;

import com.joaocarlos.securityjwt.domain.entity.User;

public interface JwtService {
    String generateToken(User user);
    String getSubjectFromToken(String token);
}
