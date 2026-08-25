package com.cloudsolux.foods.hr_service.infra.security.adapter;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.cloudsolux.foods.hr_service.infra.user_account.repo.UserAccountRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserDetailsProvider implements UserDetailsService {
	
	private final UserAccountRepo userAccountRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var userAccount = userAccountRepo.findByEmail(username)
			.orElseThrow(() -> {
				log.warn("Tentativa de login falhou. Usuário não encontrado: {}", username);
				return new UsernameNotFoundException("Credenciais inválidas");
			});
      
		return User.builder()
			.username(userAccount.getEmail())
			.password(userAccount.getPassword())
			.roles(userAccount.getRole().name())
			.disabled(!userAccount.isActive())
			.build();
	}
}