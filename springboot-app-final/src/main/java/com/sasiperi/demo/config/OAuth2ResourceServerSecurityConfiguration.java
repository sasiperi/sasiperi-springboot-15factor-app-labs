package com.sasiperi.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class OAuth2ResourceServerSecurityConfiguration {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// @formatter:off
		http
				.authorizeHttpRequests((authorize) -> authorize
						.requestMatchers("/v3/**", "/swagger-ui/**","/swagger-ui.html","/actuator/**","/actuator").anonymous() //permitAll
						.requestMatchers(HttpMethod.GET, "/**").hasAuthority("SCOPE_urn:sp-api:read")
						.requestMatchers(HttpMethod.POST, "/**").hasAuthority("SCOPE_urn:sp-api:write")
						.anyRequest().authenticated()
				)
				.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
		// @formatter:on
		return http.build();
	}

	// if we want to override the default decoder.
	/*
	 * @Bean JwtDecoder jwtDecoder() { return
	 * NimbusJwtDecoder.withJwkSetUri(this.jwkSetUri).build(); }
	 */

}
