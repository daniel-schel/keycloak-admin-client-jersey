# keycloak-admin-client-jersey
[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Fdaniel-schel%2Fkeycloak-admin-client-jersey.svg?type=shield)](https://app.fossa.com/projects/git%2Bgithub.com%2Fdaniel-schel%2Fkeycloak-admin-client-jersey?ref=badge_shield)


Jersey based client implementation of the keycloak administration API. It based on a fork of the keycloak-amdin client implemented with resteasy, 
which you can find here: https://github.com/keycloak/keycloak/tree/master/integration/admin-client.

For more information, see the documentation: https://www.keycloak.org/docs-api/12.0/rest-api/index.html

## Usage

For a Maven project, add following to pom.xml:

    <repositories>
        <repository>
            <id>github</id>
            <name>GitHub Packages</name>
            <url>https://maven.pkg.github.com/daniel-schel/keycloak-admin-client-jersey</url>
        </repository>
	</repositories>

    <dependencies>
        <dependency>
            <groupId>org.keycloak</groupId>
            <artifactId>keycloak-admin-client-jersey</artifactId>
            <version>12.0.4</version>
        </dependency>
    </dependencies>

Authentication is required to use Github Package Registry, see more details:
[Configuring Apache Maven for use with GitHub Packages](https://docs.github.com/en/free-pro-team@latest/packages/guides/configuring-apache-maven-for-use-with-github-packages)

## Notice 

Not every method is fully implemented, so an UnsupportedOperationException is thrown. If you need a specific method, you can make an implementation.

## License

* [Apache License, Version 2.0](https://www.apache.org/licenses/LICENSE-2.0)


[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Fdaniel-schel%2Fkeycloak-admin-client-jersey.svg?type=large)](https://app.fossa.com/projects/git%2Bgithub.com%2Fdaniel-schel%2Fkeycloak-admin-client-jersey?ref=badge_large)
