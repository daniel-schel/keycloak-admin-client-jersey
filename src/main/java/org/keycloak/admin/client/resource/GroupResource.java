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
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.ManagementPermissionReference;
import org.keycloak.representations.idm.ManagementPermissionRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * The type Group resource.
 *
 * Based on a fork of keycloak-amdin-client originally created by bill@burkecentral.com.
 *
 * @author daniel-schel
 */
public class GroupResource extends AbstractResource {

    private String path = "";

    /**
     * Instantiates a new Abstract resource.
     *
     * @param target the target
     */
    protected GroupResource(WebResource target) {
        super(target);
    }

    public GroupResource(WebResource target, String path) {
        super(target);
        this.path = path;
    }

    /**
     * Enables or disables the fine grain permissions feature.
     * Returns the updated status of the server in the
     * {@link ManagementPermissionReference}.
     *
     * @param status status request to apply
     * @return permission reference indicating the updated status
     */
    @PUT
    @Path("/management/permissions")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ManagementPermissionReference setPermissions(ManagementPermissionRepresentation status) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns indicator if the fine grain permissions are enabled or not.
     *
     * @return current representation of the permissions feature
     */
    @GET
    @Path("/management/permissions")
    @Produces(MediaType.APPLICATION_JSON)
    public ManagementPermissionReference getPermissions() {
        throw new UnsupportedOperationException();
    }

    /**
     * Does not expand hierarchy.  Subgroups will not be set.
     *
     * @return
     */
    @GET
    //  @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public GroupRepresentation toRepresentation() {
        throw new UnsupportedOperationException();
    }

    /**
     * Update group
     *
     * @param rep
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(GroupRepresentation rep) {
        throw new UnsupportedOperationException();
    }

    @DELETE
    public void remove() {
        throw new UnsupportedOperationException();
    }


    /**
     * Set or create child.  This will just set the parent if it exists.  Create it and set the parent
     * if the group doesn't exist.
     *
     * @param rep
     */
    @POST
    @Path("children")
        @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response subGroup(GroupRepresentation rep) {
        throw new UnsupportedOperationException();
    }


    @Path("role-mappings")
    public RoleMappingResource roles() {
        return new RoleMappingResource(getTarget(),path + "/role-mappings");
    }

    /**
     * Get users
     * <p/>
     * Returns a list of all users in group.
     *
     * @return  Returns a max size of 100 users
     */
    @GET
        @Path("/members")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserRepresentation> members() {
        throw new UnsupportedOperationException();
    }

    /**
     * Get users
     * <p/>
     * Returns a list of users, filtered according to query parameters
     *
     * @param firstResult Pagination offset
     * @param maxResults  Pagination size
     * @return
     */
    @GET
        @Path("/members")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserRepresentation> members(@QueryParam("first") Integer firstResult,
                                            @QueryParam("max") Integer maxResults) {
        throw new UnsupportedOperationException();
    }

    /**
     * Get users
     * <p/>
     * Returns a list of users, filtered according to query parameters
     *
     * @param firstResult Pagination offset
     * @param maxResults  Pagination size
     * @param briefRepresentation Only return basic information (only guaranteed to return id, username, created, first and last name,
     *      email, enabled state, email verification state, federation link, and access.
     *      Note that it means that namely user attributes, required actions, and not before are not returned.)
     * @return
     */
    @GET
        @Path("/members")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserRepresentation> members(@QueryParam("first") Integer firstResult,
                                            @QueryParam("max") Integer maxResults,
                                            @QueryParam("briefRepresentation") Boolean briefRepresentation) {
        throw new UnsupportedOperationException();
    }
}
