package com.anchtun.keycloak.demo;

import org.keycloak.models.KeycloakContext;

import com.anchtun.keycloak.demo.spi.GreetingProvider;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultGreetingProvider implements GreetingProvider {

	private final KeycloakContext context;

	public DefaultGreetingProvider(KeycloakContext context) {
		this.context = context;
	}

	@Override
	public void sayHi() {
		if (context.getAuthenticationSession() != null) {
			log.info("Hi there {}!", context.getAuthenticationSession().getAuthenticatedUser().getFirstName());
			log.info("Email: {}", context.getAuthenticationSession().getAuthenticatedUser().getEmail());
			log.info("Id: {}", context.getAuthenticationSession().getAuthenticatedUser().getId());
		} else {
			log.info("Hi there stranger!");
		}
	}

	@Override
	public void close() {

	}
}