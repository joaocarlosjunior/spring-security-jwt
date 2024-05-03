package com.joaocarlos.securityjwt.config;

import com.joaocarlos.securityjwt.domain.entity.User;
import com.joaocarlos.securityjwt.domain.repository.UserRepository;
import com.joaocarlos.securityjwt.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final HandlerExceptionResolver handlerExceptionResolver;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {

        if (checkIfEndpointIsNotPublic(request)) {
            String token = recoveryToken(request); // Recupera o token do cabeçalho Authorization da requisição

            if (token == null) {
                filterChain.doFilter(request, response);
                return;
            }

            try {
                String subject = jwtService.getSubjectFromToken(token); // Obtém o assunto (neste caso, o nome de usuário) do token
                User user = userRepository.findByEmail(subject).get(); // Busca o usuário pelo email (que é o assunto do token)

                // Cria um objeto de autenticação do Spring Security
                Authentication authentication =
                        new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

                // Define o objeto de autenticação no contexto de segurança do Spring Security
                SecurityContextHolder.getContext().setAuthentication(authentication);

            } catch (Exception e) {
                handlerExceptionResolver.resolveException(request, response, null, e);
            }
        }
        filterChain.doFilter(request, response);
    }

    private String recoveryToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null) {
            return authorizationHeader.replace("Bearer ", "");
        }
        return null;
    }

    private boolean checkIfEndpointIsNotPublic(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return !Arrays.asList(SecurityConfig.ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED).contains(requestURI);
    }

}
