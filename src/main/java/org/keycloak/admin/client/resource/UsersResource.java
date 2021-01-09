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
import org.keycloak.representations.idm.UserRepresentation;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
 * The type Users resource.
 *
 * Based on a fork of keycloak-amdin-client.
 *
 * @author daniel-schel
 */
public class UsersResource extends AbstractResource {

    private String path = "";

    /**
     * Instantiates a new Abstract resource.
     *
     * @param target the target
     */
    protected UsersResource(WebResource target) {
        super(target);
    }

    /**
     * Instantiates a new Users resource.
     *
     * @param target the target
     * @param path   the path
     */
    public UsersResource(WebResource target, String path) {
        super(target);
        this.path = path;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserRepresentation> search(@QueryParam("username") String username,
                                    @QueryParam("firstName") String firstName,
                                    @QueryParam("lastName") String lastName,
                                    @QueryParam("email") String email,
                                    @QueryParam("first") Integer firstResult,
                                    @QueryParam("max") Integer maxResults) {
        throw new UnsupportedOperationException();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserRepresentation> search(@QueryParam("username") String username,
                                    @QueryParam("firstName") String firstName,
                                    @QueryParam("lastName") String lastName,
                                    @QueryParam("email") String email,
                                    @QueryParam("first") Integer firstResult,
                                    @QueryParam("max") Integer maxResults,
                                    @QueryParam("briefRepresentation") Boolean briefRepresentation) {
        throw new UnsupportedOperationException();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserRepresentation> search(@QueryParam("username") String username) {
        throw new UnsupportedOperationException();
    }

    /**
     * Search for users whose username or email matches the value provided by {@code search}. The {@code search}
     * argument also allows finding users by specific attributes as follows:
     *
     * <ul>
     *     <li><i>id:</i> - Find users by identifier. For instance, <i>id:aa497859-bbf5-44ac-bf1a-74dbffcaf197</i></li>
     * </ul>
     *
     * @param search the value to search. It can be the username, email or any of the supported options to query based on user attributes
     * @param firstResult the position of the first result to retrieve
     * @param maxResults the maximum number of results to retreive
     * @return a list of {@link UserRepresentation}
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserRepresentation> search(@QueryParam("search") String search,
                                    @QueryParam("first") Integer firstResult,
                                    @QueryParam("max") Integer maxResults) {
        throw new UnsupportedOperationException();
    }

    /**
     * Search for users whose username or email matches the value provided by {@code search}. The {@code search}
     * argument also allows finding users by specific attributes as follows:
     *
     * <ul>
     *     <li><i>id:</i> - Find users by identifier. For instance, <i>id:aa497859-bbf5-44ac-bf1a-74dbffcaf197</i></li>
     * </ul>
     *
     * @param search the value to search. It can be the username, email or any of the supported options to query based on user attributes
     * @param firstResult the position of the first result to retrieve
     * @param maxResults the maximum number of results to retreive
     * @param briefRepresentation Only return basic information (only guaranteed to return id, username, created, first and last name,
     *      email, enabled state, email verification state, federation link, and access.
     *      Note that it means that namely user attributes, required actions, and not before are not returned.)
     * @return a list of {@link UserRepresentation}
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserRepresentation> search(@QueryParam("search") String search,
                                    @QueryParam("first") Integer firstResult,
                                    @QueryParam("max") Integer maxResults,
                                    @QueryParam("briefRepresentation") Boolean briefRepresentation) {
        throw new UnsupportedOperationException();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserRepresentation> list(@QueryParam("first") Integer firstResult,
                                  @QueryParam("max") Integer maxResults) {
        throw new UnsupportedOperationException();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserRepresentation> list() {
        throw new UnsupportedOperationException();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(UserRepresentation userRepresentation) {
        throw new UnsupportedOperationException();
    }

    @Path("count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Integer count() {
        throw new UnsupportedOperationException();
    }

    @Path("{id}")
    public UserResource get(@PathParam("id") String id) {
        return new UserResource(getTarget(),path+"/"+id);
    }

    @Path("{id}")
    @DELETE
    public Response delete(@PathParam("id") String id) {
        throw new UnsupportedOperationException();
    }


}
