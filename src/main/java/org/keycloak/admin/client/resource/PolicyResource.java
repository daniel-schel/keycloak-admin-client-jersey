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

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.WebResource;
import org.keycloak.admin.client.AbstractResource;
import org.keycloak.representations.idm.authorization.PolicyRepresentation;
import org.keycloak.representations.idm.authorization.ResourceRepresentation;
import org.keycloak.representations.idm.authorization.ScopeRepresentation;

/**
 * The type Policy resource.
 *
 * Based on a fork of keycloak-amdin-client originally created by psilva@redhat.com.
 *
 * @author daniel-schel
 */
public class PolicyResource extends AbstractResource {

    private String path = "";

    /**
     * Instantiates a new Abstract resource.
     *
     * @param target the target
     */
    protected PolicyResource(WebResource target) {
        super(target);
    }

    /**
     * Instantiates a new Policy resource.
     *
     * @param target the target
     * @param path   the path
     */
    public PolicyResource(WebResource target, String path) {
        super(target);
        this.path = path;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
        public PolicyRepresentation toRepresentation() {
        throw new UnsupportedOperationException();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
        public PolicyRepresentation toRepresentation(@QueryParam("fields") String fields) {
        throw new UnsupportedOperationException();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(PolicyRepresentation representation) {
        throw new UnsupportedOperationException();
    }

    @DELETE
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Path("/associatedPolicies")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
        public List<PolicyRepresentation> associatedPolicies() {
        throw new UnsupportedOperationException();
    }

    @Path("/dependentPolicies")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
        public List<PolicyRepresentation> dependentPolicies() {
        throw new UnsupportedOperationException();
    }

    @Path("/scopes")
    @GET
    @Produces("application/json")
        public List<ScopeRepresentation> scopes() {
        throw new UnsupportedOperationException();
    }

    @Path("/resources")
    @GET
    @Produces("application/json")
        public List<ResourceRepresentation> resources() {
        throw new UnsupportedOperationException();
    }
}
