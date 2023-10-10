package com.anchtun.keycloak.demo.spi;

import org.keycloak.provider.Provider;

public interface GreetingProvider extends Provider {
    void sayHi();
}