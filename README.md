# Keycloak Repository

https://github.com/keycloak/keycloak

# Configuring Keycloak

https://www.keycloak.org/server/configuration

You can run this command: `/home/mohammedayman/software/keycloak-22.0.3/bin/kc.sh start-dev --db mysql --db-url-host localhost --db-username keycloak --db-password keycloak --http-port=8094 --spi-email-sender-provider=default`

# URLs
- ServiceLoader - https://docs.oracle.com/javase/8/docs/api/java/util/ServiceLoader.html
- Configuration provider - https://www.keycloak.org/server/configuration-provider
- Add custom REST endpoints - https://www.keycloak.org/docs/latest/server_development/index.html#_extensions_rest
- Theme resources - https://www.keycloak.org/docs/latest/server_development/index.html#_theme_resource
- Custom SPI - https://www.keycloak.org/docs/latest/server_development/#_extensions_spi
- Authentication flows - https://www.keycloak.org/docs/latest/server_admin/index.html#_authentication-flows
- Deploying themes - https://www.keycloak.org/docs/latest/server_development/#deploying-themes
- Add custom JPA entities - https://www.keycloak.org/docs/latest/server_development/#_extensions_jpa
- User Storage SPI - https://www.keycloak.org/docs/latest/server_development/#_user-storage-spi
- openid-configuration - http://localhost:8094/realms/test1/.well-known/openid-configuration
- To get the token - http://localhost:8094/realms/test1/protocol/openid-connect/auth?client_id=account-console&response_type=token&redirect_uri=https://httpbin.org/
  Will redirect to https://httpbin.org/ then copy the token from: `access_token` to `token_type`.
- URL ENCODER - https://www.urlencoder.org/
- keycloakify - https://docs.keycloakify.dev/
- keycloakify GitHub - https://github.com/keycloakify/keycloakify.git
- keycloakify-starter - https://github.com/keycloakify/keycloakify-starter
- Apache FreeMarker - https://freemarker.apache.org/
- keycloak Themes - https://github.com/keycloak/keycloak/tree/main/themes
  
# Commands
		export TOKEN=copied_token
		curl -v -H "Authorization: Bearer $TOKEN" "localhost:8094/realms/test1/email-exists?email=med.aymen.charrada@gmail.com"

# SPI (Service Provider Interface)

https://docs.oracle.com/javase/tutorial/ext/basics/spi.html#define-the-service-provider-interface

- `Service`: A set of programming interfaces and classes that provide access to some specific application functionality or feature. The service can define the interfaces for the functionality and a way to retrieve an implementation. In the word-processor example, a dictionary service can define a way to retrieve a dictionary and the definition of a word, but it does not implement the underlying feature set. Instead, it relies on a service provider to implement that functionality.

- `Service provider interface (SPI)`: The set of public interfaces and abstract classes that a service defines. The SPI defines the classes and methods available to your application.

- `Service Provider`: Implements the SPI. An application with extensible services enable you, vendors, and customers to add service providers without modifying the original application.

# Deploy new changes:

      1- Run: mvn clean package -Pdev
      2- You have two choices:
      2-1- Run: sudo docker compose up
      2-2: cp -r /home/mohammedayman/git/extending-keycloak/extending-keycloak/src/main/resources/theme/bootstrap /home/mohammedayman/software/keycloak-22.0.4/themes
           cp /home/mohammedayman/git/extending-keycloak/extending-keycloak/target/deploy/extending-keycloak-0.0.1-SNAPSHOT.jar /home/mohammedayman/software/keycloak-22.0.4/providers
      3- Run Keycloak: /home/mohammedayman/software/keycloak-22.0.4/bin/kc.sh start-dev --db mysql --db-url-host localhost --db-username keycloak --db-password keycloak --http-port=8094

# keycloak-app-consumer

	Do this in Keycloak:
	realm name: keycloak-app-consumer
	username:mohamed
	password:123456
	client_id:aiasclient
	client_secret:4zyUN1wrQns24BIoklelZWgsU6tZ0h6X
	The user will login to:	
	http://localhost:8094/realms/keycloak-app-consumer/protocol/openid-connect/auth?client_id=aiasclient&redirect_uri=http%3A%2F%2Flocalhost%3A8081&response_type=code&scope=openid+profile+email&state=any
 	The spring boot application will redirect to: 
	http://localhost:8094/realms/keycloak-app-consumer/protocol/openid-connect/auth?client_id=aiasclient&response_type=code&redirect_uri=http://localhost:8081&kc_action=feeling-survey

 # keycloakify

	 git clone https://github.com/keycloakify/keycloakify-starter.git
	 yarn install && yarn build-keycloak-theme
	 cp /home/mohammedayman/git/keycloakify-starter/build_keycloak/target/keycloakify-starter-keycloak-theme-4.7.3.jar /home/mohammedayman/software/keycloak-22.0.4/providers

# Custom JPA entities

Just to check the created table run this:

	SELECT * from DATABASECHANGELOG_SUBSCRIPTI order by DATEEXECUTED desc;
