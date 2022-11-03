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

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.client.WebResource;
import org.keycloak.admin.client.AbstractResource;
import org.keycloak.representations.idm.authorization.UserPolicyRepresentation;

/**
 * The type User policies resource.
 *
 * Based on a fork of keycloak-amdin-client originally created by psilva@redhat.com.
 *
 * @author daniel-schel
 */
public class UserPoliciesResource extends AbstractResource {

    private String path = "";

    /**
     * Instantiates a new User policies resource.
     *
     * @param target the target
     */
    protected UserPoliciesResource(WebResource target) {
        super(target);
    }

    /**
     * Instantiates a new User policies resource.
     *
     * @param target the target
     * @param path   the path
     */
    public UserPoliciesResource(WebResource target, String path) {
        super(target);
        this.path = path;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(UserPolicyRepresentation representation) {
        throw new UnsupportedOperationException();
    }

    @Path("{id}")
    public UserPolicyResource findById(@PathParam("id") String id) {
        return new UserPolicyResource(getTarget(),path+"/"+id);
    }

    @Path("/search")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
        public UserPolicyRepresentation findByName(@QueryParam("name") String name) {
        throw new UnsupportedOperationException();
    }
}
