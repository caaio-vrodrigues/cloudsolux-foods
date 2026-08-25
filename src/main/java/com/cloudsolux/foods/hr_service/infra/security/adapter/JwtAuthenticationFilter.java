package com.cloudsolux.foods.hr_service.infra.security.adapter;

import java.io.IOException;

import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cloudsolux.foods.hr_service.domain.security.model.TokenManagerPort;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private static final String AUTHORIZATION_HEADER = "Authorization";
  private static final String BEARER_PREFIX = "Bearer ";

  private final TokenManagerPort tokenService;
  private final UserDetailsService userDetailsService;

  @Override
  protected void doFilterInternal(
    HttpServletRequest request,
    HttpServletResponse response,
    FilterChain filterChain
  ) throws ServletException, IOException {
    try {
      String token = extractToken(request);

      if(token != null) {
        String subject = tokenService.validateToken(token);

        UserDetails userDetails = userDetailsService.loadUserByUsername(subject);

        if(!userDetails.isEnabled() || !userDetails.isAccountNonLocked())
          throw new DisabledException("Conta desativada");

        var authentication = new UsernamePasswordAuthenticationToken(
          userDetails, 
          null, 
          userDetails.getAuthorities());

        authentication.setDetails(new WebAuthenticationDetailsSource()
          .buildDetails(request));

        SecurityContextHolder.getContext()
          .setAuthentication(authentication);
      }
    } 
    catch(Exception e) {
      log.warn(
        "Falha na validação do token JWT: {}", 
        e.getMessage());
    }

    filterChain.doFilter(request, response);
  }

  private String extractToken(HttpServletRequest request) {
    String header = request
      .getHeader(AUTHORIZATION_HEADER);

    if(header == null || !header.startsWith(BEARER_PREFIX)) return null;

    String token = header.substring(BEARER_PREFIX.length());
    return token.isEmpty() ? null : token;
  }
}