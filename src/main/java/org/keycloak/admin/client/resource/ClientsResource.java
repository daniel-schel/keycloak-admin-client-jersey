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
import org.keycloak.representations.idm.ClientRepresentation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * The type Clients resource.
 *
 * Based on a fork of keycloak-amdin-client originally created by rodrigo.sasaki@icarros.com.br.
 *
 * @author daniel-schel
 */
public class ClientsResource extends AbstractResource {

    private String clientsPath = "";

    protected ClientsResource(WebResource target) {
        super(target);
    }

    public ClientsResource(WebResource target, String clientsPath) {
        super(target);
        this.clientsPath = clientsPath;
    }

    @Path("{id}")
    public ClientResource get(@PathParam("id") String id) {
        return new ClientResource(getTarget(),clientsPath+"/"+id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(ClientRepresentation clientRepresentation) {
        return getTarget().path(clientsPath).type(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE).entity(clientRepresentation).post(Response.class);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ClientRepresentation> findAll() {
        return getTarget().path(clientsPath).accept(MediaType.APPLICATION_JSON).get(new GenericType<List<ClientRepresentation>>() {});
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ClientRepresentation> findAll(@QueryParam("viewableOnly") boolean viewableOnly) {
        return getTarget().path(clientsPath).queryParam("viewableOnly",viewableOnly+"").accept(MediaType.APPLICATION_JSON).get(new GenericType<List<ClientRepresentation>>() {});
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ClientRepresentation> findAll(@QueryParam("clientId") String clientId,
                                       @QueryParam("viewableOnly") Boolean viewableOnly,
                                       @QueryParam("search") Boolean search,
                                       @QueryParam("first") Integer firstResult,
                                       @QueryParam("max") Integer maxResults) {
        return getTarget().path(clientsPath)
                .queryParam("clientId",clientId)
                .queryParam("viewableOnly",viewableOnly+"")
                .queryParam("search",search+"")
                .queryParam("first",firstResult+"")
                .queryParam("max",maxResults+"")
                .accept(MediaType.APPLICATION_JSON).get(new GenericType<List<ClientRepresentation>>() {});
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ClientRepresentation> findByClientId(@QueryParam("clientId") String clientId) {
        return getTarget().path(clientsPath).queryParam("clientId",clientId).accept(MediaType.APPLICATION_JSON).get(new GenericType<List<ClientRepresentation>>() {});
    }

}
