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
import org.keycloak.representations.idm.RoleRepresentation;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
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
 * The type Roles resource.
 *
 * Based on a fork of keycloak-amdin-client originally created by rodrigo.sasaki@icarros.com.br.
 *
 * @author daniel-schel
 */
public class RolesResource extends AbstractResource {

    private String clientPath = "";

    /**
     * Instantiates a new Roles resource.
     *
     * @param target the target
     */
    protected RolesResource(WebResource target) {
        super(target);
    }

    /**
     * Instantiates a new Roles resource.
     *
     * @param target     the target
     * @param clientPath the client path
     */
    public RolesResource(WebResource target, String clientPath) {
        super(target);
        this.clientPath = clientPath;
    }

    /**
     * Get roles.
     *
     * @return A list containing all roles.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RoleRepresentation> list() {
        return getTarget().path(clientPath)
                .accept(MediaType.APPLICATION_JSON).get(new GenericType<List<RoleRepresentation>>() {});
    }

    /**
     * Get roles.
     *
     * @param briefRepresentation if false, return roles with their attributes
     * @return A list containing all roles.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RoleRepresentation> list(@QueryParam("briefRepresentation") @DefaultValue("true") boolean briefRepresentation) {
        return getTarget().path(clientPath)
                .queryParam("briefRepresentation",briefRepresentation+"")
                .accept(MediaType.APPLICATION_JSON).get(new GenericType<List<RoleRepresentation>>() {});
    }

    /**
     * Get roles by pagination params.
     *
     * @param firstResult index of the first element
     * @param maxResults max number of occurrences
     * @return A list containing the slice of all roles.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RoleRepresentation> list(@QueryParam("first") Integer firstResult,
                                  @QueryParam("max") Integer maxResults) {
        return getTarget().path(clientPath)
                .queryParam("first",firstResult+"")
                .queryParam("max",maxResults+"")
                .accept(MediaType.APPLICATION_JSON).get(new GenericType<List<RoleRepresentation>>() {});
    }

    /**
     * Get roles by pagination params.
     *
     * @param firstResult index of the first element
     * @param maxResults max number of occurrences
     * @param briefRepresentation if false, return roles with their attributes
     * @return A list containing the slice of all roles.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RoleRepresentation> list(@QueryParam("first") Integer firstResult,
                                  @QueryParam("max") Integer maxResults,
                                  @QueryParam("briefRepresentation") @DefaultValue("true") boolean briefRepresentation) {
        return getTarget().path(clientPath)
                .queryParam("first",firstResult+"")
                .queryParam("max",maxResults+"")
                .queryParam("briefRepresentation",briefRepresentation+"")
                .accept(MediaType.APPLICATION_JSON).get(new GenericType<List<RoleRepresentation>>() {});
    }

    /**
     * Get roles by pagination params.
     *
     * @param search max number of occurrences
     * @param briefRepresentation if false, return roles with their attributes
     * @return A list containing the slice of all roles.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RoleRepresentation> list(@QueryParam("search") @DefaultValue("") String search,
                                  @QueryParam("briefRepresentation") @DefaultValue("true") boolean briefRepresentation) {
        return getTarget().path(clientPath)
                .queryParam("search",search)
                .queryParam("briefRepresentation",briefRepresentation+"")
                .accept(MediaType.APPLICATION_JSON).get(new GenericType<List<RoleRepresentation>>() {});
    }

    /**
     * Get roles by pagination params.
     *
     * @param search max number of occurrences
     * @param firstResult index of the first element
     * @param maxResults max number of occurrences
     * @return A list containing the slice of all roles.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RoleRepresentation> list(@QueryParam("search") @DefaultValue("") String search,
                                  @QueryParam("first") Integer firstResult,
                                  @QueryParam("max") Integer maxResults) {
        return getTarget().path(clientPath)
                .queryParam("search",search)
                .queryParam("first",firstResult+"")
                .queryParam("max",maxResults+"")
                .accept(MediaType.APPLICATION_JSON).get(new GenericType<List<RoleRepresentation>>() {});
    }

    /**
     * Get roles by pagination params.
     *
     * @param search max number of occurrences
     * @param firstResult index of the first element
     * @param maxResults max number of occurrences
     * @param briefRepresentation if false, return roles with their attributes
     * @return A list containing the slice of all roles.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RoleRepresentation> list(@QueryParam("search") @DefaultValue("") String search,
                                  @QueryParam("first") Integer firstResult,
                                  @QueryParam("max") Integer maxResults,
                                  @QueryParam("briefRepresentation") @DefaultValue("true") boolean briefRepresentation) {
        return getTarget().path(clientPath)
                .queryParam("search",search)
                .queryParam("first",firstResult+"")
                .queryParam("max",maxResults+"")
                .queryParam("briefRepresentation",briefRepresentation+"")
                .accept(MediaType.APPLICATION_JSON).get(new GenericType<List<RoleRepresentation>>() {});
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(RoleRepresentation roleRepresentation) {
        getTarget().path(clientPath).type(MediaType.APPLICATION_JSON_TYPE).entity(roleRepresentation).post(Void.class);
    }

    @Path("{roleName}")
    public RoleResource get(@PathParam("roleName") String roleName) {
        return new RoleResource(getTarget(), clientPath);
    }

    @Path("{role-name}")
    @DELETE
    public void deleteRole(final @PathParam("role-name") String roleName) {
        getTarget().path(clientPath+"/"+roleName).delete();
    }

}
