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
import org.keycloak.representations.idm.ProtocolMapperRepresentation;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * The type Protocol mappers resource.
 *
 * Based on a fork of keycloak-amdin-client originally created by mposolda@redhat.com.
 *
 * @author daniel-schel
 */
public class ProtocolMappersResource extends AbstractResource {

    private String path = "";

    /**
     * Instantiates a new Abstract resource.
     *
     * @param target the target
     */
    protected ProtocolMappersResource(WebResource target) {
        super(target);
    }

    public ProtocolMappersResource(WebResource target, String path) {
        super(target);
        this.path = path;
    }

    @GET
    @Path("protocol/{protocol}")
    @Produces("application/json")
    public List<ProtocolMapperRepresentation> getMappersPerProtocol(@PathParam("protocol") String protocol) {
        throw new UnsupportedOperationException();
    }

    @Path("models")
    @POST
    @Consumes("application/json")
    public Response createMapper(ProtocolMapperRepresentation rep) {
        throw new UnsupportedOperationException();
    }

    @Path("add-models")
    @POST
    @Consumes("application/json")
    public void createMapper(List<ProtocolMapperRepresentation> reps) {
        throw new UnsupportedOperationException();
    }

    @GET
    @Path("models")
    @Produces("application/json")
    public List<ProtocolMapperRepresentation> getMappers() {
        throw new UnsupportedOperationException();
    }

    @GET
    @Path("models/{id}")
    @Produces("application/json")
    public ProtocolMapperRepresentation getMapperById(@PathParam("id") String id) {
        throw new UnsupportedOperationException();
    }

    @PUT
    @Path("models/{id}")
    @Consumes("application/json")
    public void update(@PathParam("id") String id, ProtocolMapperRepresentation rep) {
        throw new UnsupportedOperationException();
    }

    @DELETE
    @Path("models/{id}")
    public void delete(@PathParam("id") String id) {
        throw new UnsupportedOperationException();
    }
}
