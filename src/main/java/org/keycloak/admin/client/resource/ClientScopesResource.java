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

import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import org.keycloak.admin.client.AbstractResource;
import org.keycloak.representations.idm.ClientScopeRepresentation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * The type Client scopes resource.
 *
 * Based on a fork of keycloak-amdin-client originally created by rodrigo.sasaki@icarros.com.br.
 *
 * @author daniel-schel
 */
public class ClientScopesResource extends AbstractResource {

    private String clientScopesPath = "";

    protected ClientScopesResource(WebResource target) {
        super(target);
    }

    public ClientScopesResource(WebResource target, String clientScopesPath) {
        super(target);
        this.clientScopesPath = clientScopesPath;
    }

    @Path("{id}")
    public ClientScopeResource get(@PathParam("id") String id) {
        return new ClientScopeResource(getTarget(),clientScopesPath+"/"+id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(ClientScopeRepresentation clientScopeRepresentation){
        return getTarget().path(clientScopesPath).type(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE).entity(clientScopeRepresentation).post(Response.class);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ClientScopeRepresentation> findAll() {
        return getTarget().path(clientScopesPath).accept(MediaType.APPLICATION_JSON).get(new GenericType<List<ClientScopeRepresentation>>() {});
    }

}
