package com.anchtun.keycloak.demo;

import org.keycloak.events.Event;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.EventType;
import org.keycloak.events.admin.AdminEvent;

import com.anchtun.keycloak.demo.spi.GreetingProvider;

import jakarta.persistence.EntityManager;

public class GreetingEventListenerProvider implements EventListenerProvider {


    private final GreetingProvider greetingProvider;

    private final EntityManager entityManager;

    public GreetingEventListenerProvider(GreetingProvider greetingProvider, EntityManager entityManager) {
        this.greetingProvider = greetingProvider;
        this.entityManager = entityManager;
    }

    @Override
    public void onEvent(Event event) {
    	// when the user login
        if (event.getType() == EventType.LOGIN) {
         greetingProvider.sayHi();
        } else if (event.getType() == EventType.REGISTER) {
//            Subscription subscription = new Subscription();
//            subscription.setId(UUID.randomUUID());
//            UserEntity userEntity = new UserEntity();
//            userEntity.setId(event.getUserId());
//            subscription.setUser(userEntity);
//            subscription.setCreated(LocalDateTime.now());
//            entityManager.persist(subscription);
        }
    }

    @Override
    public void onEvent(AdminEvent event, boolean includeRepresentation) {

    }

    @Override
    public void close() {

    }
}