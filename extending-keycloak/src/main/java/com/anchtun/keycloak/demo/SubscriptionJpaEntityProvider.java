package com.anchtun.keycloak.demo;

import java.util.Arrays;
import java.util.List;

import org.keycloak.connections.jpa.entityprovider.JpaEntityProvider;

import com.anchtun.keycloak.demo.domain.Subscription;

public class SubscriptionJpaEntityProvider implements JpaEntityProvider {
	
	@Override
	public List<Class<?>> getEntities() {
		return Arrays.asList(Subscription.class);
	}

	@Override
	public String getChangelogLocation() {
		return "META-INF/changelog.xml";
	}

	@Override
	public String getFactoryId() {
		return "subscription";
	}

	@Override
	public void close() {

	}
}