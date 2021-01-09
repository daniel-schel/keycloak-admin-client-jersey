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

package org.keycloak.admin.client.resource;

import com.sun.jersey.api.client.WebResource;
import org.keycloak.admin.client.AbstractResource;
import org.keycloak.representations.idm.ClientScopeRepresentation;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * The type Client scope resource.
 *
 * Based on a fork of keycloak-amdin-client originally created by rodrigo.sasaki@icarros.com.br.
 *
 * @author daniel-schel
 */
public class ClientScopeResource extends AbstractResource {

    private String clientScopePath = "";

    protected ClientScopeResource(WebResource target) {
        super(target);
    }

    public ClientScopeResource(WebResource target, String clientScopePath) {
        super(target);
        this.clientScopePath = clientScopePath;
    }

    @Path("protocol-mappers")
    public ProtocolMappersResource getProtocolMappers() {
        return new ProtocolMappersResource(getTarget(),clientScopePath+"/protocol-mappers");
    }

    @Path("/scope-mappings")
    public RoleMappingResource getScopeMappings() {
        return new RoleMappingResource(getTarget(),clientScopePath+"/scope-mappings");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ClientScopeRepresentation toRepresentation() {
        return getTarget().path(clientScopePath).accept(MediaType.APPLICATION_JSON_TYPE).get(ClientScopeRepresentation.class);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(ClientScopeRepresentation rep) {
        getTarget().path(clientScopePath).type(MediaType.APPLICATION_JSON_TYPE).entity(rep).put(ClientScopeRepresentation.class);
    }

    @DELETE
    public void remove() {
        getTarget().path(clientScopePath).delete();
    }


}