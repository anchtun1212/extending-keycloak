# ServiceLoader

https://docs.oracle.com/javase/8/docs/api/java/util/ServiceLoader.html

# SPI (Service Provider Interface)

https://docs.oracle.com/javase/tutorial/ext/basics/spi.html#define-the-service-provider-interface

- `Service`: A set of programming interfaces and classes that provide access to some specific application functionality or feature. The service can define the interfaces for the functionality and a way to retrieve an implementation. In the word-processor example, a dictionary service can define a way to retrieve a dictionary and the definition of a word, but it does not implement the underlying feature set. Instead, it relies on a service provider to implement that functionality.

- `Service provider interface (SPI)`: The set of public interfaces and abstract classes that a service defines. The SPI defines the classes and methods available to your application.

- `Service Provider`: Implements the SPI. An application with extensible services enable you, vendors, and customers to add service providers without modifying the original application.

# Configuration provider

https://www.keycloak.org/server/configuration-provider

# Deploy new changes:

      1- Run: mvn clean package -Pdev
      2- You have two choices:
      2-1- Run: sudo docker compose up
      2-2: Copy: /home/mohammedayman/git/extending-keycloak/src/main/resources/theme to /home/mohammedayman/software/keycloak-22.0.3/themes means
           cp -r /home/mohammedayman/git/extending-keycloak/src/main/resources/theme /home/mohammedayman/software/keycloak-22.0.3/themes
           and Copy /home/mohammedayman/git/extending-keycloak/target/deploy to /home/mohammedayman/software/keycloak-22.0.3/providers means
           cp /home/mohammedayman/git/extending-keycloak/target/deploy/extending-keycloak-0.0.1-SNAPSHOT.jar /home/mohammedayman/software/keycloak-22.0.3/providers
      3- Run Keycloak: /home/mohammedayman/software/keycloak-22.0.3/bin/kc.sh start-dev --db mysql --db-url-host localhost --db-username keycloak --db-password keycloak --http-port=8094

