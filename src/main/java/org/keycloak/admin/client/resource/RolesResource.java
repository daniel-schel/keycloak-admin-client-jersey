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
import org.keycloak.representations.idm.RoleRepresentation;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * The type Roles resource.
 *
 * Based on a fork of keycloak-amdin-client originally created by rodrigo.sasaki@icarros.com.br.
 *
 * @author daniel-schel
 */
public class RolesResource extends AbstractResource {

    private String clientPath = "";

    /**
     * Instantiates a new Abstract resource.
     *
     * @param target the target
     */
    protected RolesResource(WebResource target) {
        super(target);
    }

    public RolesResource(WebResource target, String clientPath) {
        super(target);
        this.clientPath = clientPath;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RoleRepresentation> list() {
        throw new UnsupportedOperationException();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(RoleRepresentation roleRepresentation) {
        throw new UnsupportedOperationException();
    }

    @Path("{roleName}")
    public RoleResource get(@PathParam("roleName") String roleName) {
        throw new UnsupportedOperationException();
    }

    @Path("{role-name}")
    @DELETE
    public void deleteRole(final @PathParam("role-name") String roleName) {
        throw new UnsupportedOperationException();
    }

}
