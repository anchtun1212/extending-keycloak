# ServiceLoader

https://docs.oracle.com/javase/8/docs/api/java/util/ServiceLoader.html

# SPI (Service Provider Interface)

https://docs.oracle.com/javase/tutorial/ext/basics/spi.html#define-the-service-provider-interface

- `Service`: A set of programming interfaces and classes that provide access to some specific application functionality or feature. The service can define the interfaces for the functionality and a way to retrieve an implementation. In the word-processor example, a dictionary service can define a way to retrieve a dictionary and the definition of a word, but it does not implement the underlying feature set. Instead, it relies on a service provider to implement that functionality.

- `Service provider interface (SPI)`: The set of public interfaces and abstract classes that a service defines. The SPI defines the classes and methods available to your application.

- `Service Provider`: Implements the SPI. An application with extensible services enable you, vendors, and customers to add service providers without modifying the original application.

# Deploy new changes:

1- Run: `mvn clean package -Pdev`
You have two choices:
