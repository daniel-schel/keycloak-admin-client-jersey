/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.keycloak.admin.client;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.client.urlconnection.HTTPSProperties;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.RealmsResource;
import org.keycloak.admin.client.resource.ServerInfoResource;
import org.keycloak.admin.client.token.TokenManager;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;

import static org.keycloak.OAuth2Constants.PASSWORD;

/**
 * Provides a Keycloak client. By default, this implementation uses a jersey {@link Client client} with the
 * default {@link DefaultClientConfig} settings. To customize the underling client, use a {@link KeycloakBuilder} to
 * create a Keycloak client.
 *
 * To read Responses, you can use {@link CreatedResponseUtil} for objects created.
 *
 * Based on a fork of keycloak-amdin-client originally created by rodrigo.sasaki@icarros.com.br.
 *
 * @author daniel-schel
 * @see KeycloakBuilder
 */
public class Keycloak implements AutoCloseable {
    private final Config config;
    private final TokenManager tokenManager;
    private final String authToken;
    private final WebResource target;
    private final Client client;
    private boolean closed = false;

    Keycloak(String serverUrl, String realm, String username, String password, String clientId, String clientSecret, String grantType, Client jerseyClient, String authtoken, String scope) {
        config = new Config(serverUrl, realm, username, password, clientId, clientSecret, grantType, scope);
        client = jerseyClient != null ? jerseyClient : newJerseyClient(null, null, false);
        authToken = authtoken;
        tokenManager = authtoken == null ? new TokenManager(config, client) : null;

        target = client.resource(config.getServerUrl());
        target.addFilter(newAuthFilter());
    }

    private BearerAuthFilter newAuthFilter() {
        return authToken != null ? new BearerAuthFilter(authToken) : new BearerAuthFilter(tokenManager);
    }

    private static Client newJerseyClient(Object customJacksonProvider, SSLContext sslContext, boolean disableTrustManager) {
        ClientConfig cc = new DefaultClientConfig();
        cc.getClasses().add(JacksonJsonProvider.class);
        if (customJacksonProvider != null) {
            cc.getSingletons().add(customJacksonProvider);
        }
        cc.getProperties().put(ClientConfig.PROPERTY_THREADPOOL_SIZE,"10");
        cc.getFeatures().put("com.sun.jersey.api.json.POJOMappingFeature", true);

        if(sslContext != null) {
            HostnameVerifier hostnameVerifier;
            if (disableTrustManager) {
                // Disable PKIX path validation errors when running tests using SSL
                hostnameVerifier = (s, sslSession) -> true;
            } else {
                hostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            }
            cc.getProperties().put(HTTPSProperties.PROPERTY_HTTPS_PROPERTIES, new HTTPSProperties(hostnameVerifier, sslContext));
        }
        return Client.create(cc);
    }

    public static Keycloak getInstance(String serverUrl, String realm, String username, String password, String clientId, String clientSecret, SSLContext sslContext, Object customJacksonProvider, boolean disableTrustManager, String authToken, String scope) {
        return new Keycloak(serverUrl, realm, username, password, clientId, clientSecret, PASSWORD, newJerseyClient(customJacksonProvider, sslContext, disableTrustManager), authToken, scope);
    }

    public static Keycloak getInstance(String serverUrl, String realm, String username, String password, String clientId, String clientSecret, SSLContext sslContext, Object customJacksonProvider, boolean disableTrustManager, String authToken) {
        return getInstance(serverUrl, realm, username, password, clientId, clientSecret, sslContext, customJacksonProvider, disableTrustManager, authToken, null);
    }

    public static Keycloak getInstance(String serverUrl, String realm, String username, String password, String clientId, String clientSecret) {
        return getInstance(serverUrl, realm, username, password, clientId, clientSecret, null, null, false, null);
    }

    public static Keycloak getInstance(String serverUrl, String realm, String username, String password, String clientId, String clientSecret, SSLContext sslContext) {
        return getInstance(serverUrl, realm, username, password, clientId, clientSecret, sslContext, null, false, null);
    }

    public static Keycloak getInstance(String serverUrl, String realm, String username, String password, String clientId, String clientSecret, SSLContext sslContext, Object customJacksonProvider) {
        return getInstance(serverUrl, realm, username, password, clientId, clientSecret, sslContext, customJacksonProvider, false, null);
    }

    public static Keycloak getInstance(String serverUrl, String realm, String username, String password, String clientId) {
        return getInstance(serverUrl, realm, username, password, clientId, null, null, null, false, null);
    }

    public static Keycloak getInstance(String serverUrl, String realm, String username, String password, String clientId, SSLContext sslContext) {
        return getInstance(serverUrl, realm, username, password, clientId, null, sslContext, null, false, null);
    }

    public static Keycloak getInstance(String serverUrl, String realm, String clientId, String authToken) {
        return getInstance(serverUrl, realm, null, null, clientId, null, null, null, false, authToken);
    }

    public static Keycloak getInstance(String serverUrl, String realm, String clientId, String authToken, SSLContext sllSslContext) {
        return getInstance(serverUrl, realm, null, null, clientId, null, sllSslContext, null, false, authToken);
    }

    public RealmsResource realms() {
        return new RealmsResource(target);
    }

    public RealmResource realm(String realmName) {
        return realms().realm(realmName);
    }

    public ServerInfoResource serverInfo() {
        return new ServerInfoResource(target);
    }

    public TokenManager tokenManager() {
        return tokenManager;
    }

    /**
     * Create a secure proxy based on an absolute URI.
     * All set up with appropriate token
     *
     * @param <T>         the type parameter
     * @param proxyClass  the proxy class
     * @param absoluteURI the absolute uri
     * @return t
     */
    public <T extends AbstractResource> T proxy(Class<? extends AbstractResource> proxyClass, URI absoluteURI) {
        try {
            WebResource w = client.resource(absoluteURI);
            w.addFilter(newAuthFilter());
            return (T) proxyClass.getConstructor(WebResource.class).newInstance(w);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException("Exception during the invocation of the class constructor extending AbstractResource",e);
        }
    }

    /**
     * Closes the underlying client. After calling this method, this <code>Keycloak</code> instance cannot be reused.
     */
    @Override
    public void close() {
        closed = true;
        client.destroy();
    }

    /**
     * @return true if the underlying client is closed.
     */
    public boolean isClosed() {
        return closed;
    }
}
