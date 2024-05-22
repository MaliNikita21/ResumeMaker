package com.technoSignia.resumeMaker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Security_Config {
	@Bean
	UserDetailsService userDetailsService() {
		UserDetails adminUser = User.withUsername("admin").password(passwordEncoder().encode("admin123")).roles("ADMIN")
				.build();

		InMemoryUserDetailsManager userDetails = new InMemoryUserDetailsManager(adminUser);

		return userDetails;

	}

	@Bean
	PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				(authorize) -> authorize.requestMatchers("/login").permitAll().anyRequest().authenticated()).csrf((csrf) -> csrf
		                .ignoringRequestMatchers("/*"))
		                .httpBasic(Customizer.withDefaults()).formLogin(Customizer.withDefaults());

		return http.build();
	}

}
