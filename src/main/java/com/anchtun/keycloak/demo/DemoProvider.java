package com.anchtun.keycloak.demo;

import org.keycloak.provider.Provider;

public interface DemoProvider extends Provider {

    void sayHi();
}