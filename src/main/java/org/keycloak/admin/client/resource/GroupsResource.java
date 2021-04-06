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

import javax.ws.rs.Consumes;
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
import java.util.Map;

/**
 * The type Groups resource.
 *
 * Based on a fork of keycloak-amdin-client originally created by bill@burkecentral.com.
 *
 * @author daniel-schel
 */
public class GroupsResource extends AbstractResource {

    private String path = "";

    /**
     * Instantiates a new Abstract resource.
     *
     * @param target the target
     */
    protected GroupsResource(WebResource target) {
        super(target);
    }

    public GroupsResource(WebResource target, String path) {
        super(target);
        this.path = path;
    }

    /**
     * Get all groups.
     * @return A list containing all groups.
     */
    @GET
    //@NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public List<GroupRepresentation> groups() {
        throw new UnsupportedOperationException();
    }

    /**
     * Get groups by pagination params.
     * @param first index of the first element
     * @param max max number of occurrences
     * @return A list containing the slice of all groups.
     */
    @GET
    //@NoCache
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<GroupRepresentation> groups(@QueryParam("first") Integer first, @QueryParam("max") Integer max) {
        throw new UnsupportedOperationException();
    }

    /**
     * Get groups by pagination params.
     * @param search max number of occurrences
     * @param first index of the first element
     * @param max max number of occurrences
     * @return A list containing the slice of all groups.
     */
    @GET
    //@NoCache
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<GroupRepresentation> groups(@QueryParam("search") String search,
                                     @QueryParam("first") Integer first,
                                     @QueryParam("max") Integer max) {
        throw new UnsupportedOperationException();
    }

    /**
     * Get groups by pagination params.
     * @param search max number of occurrences
     * @param first index of the first element
     * @param max max number of occurrences
     * @param briefRepresentation if false, return groups with their attributes
     * @return A list containing the slice of all groups.
     */
    @GET
    // @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<GroupRepresentation> groups(@QueryParam("search") String search,
                                     @QueryParam("first") Integer first,
                                     @QueryParam("max") Integer max,
                                     @QueryParam("briefRepresentation") @DefaultValue("true") boolean briefRepresentation) {
        throw new UnsupportedOperationException();
    }
    /**
     * Counts all groups.
     * @return A map containing key "count" with number of groups as value.
     */
    @GET
    //@NoCache
    @Path("count")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Map<String, Long> count() {
        throw new UnsupportedOperationException();
    }

    /**
     * Counts groups by name search.
     * @param search max number of occurrences
     * @return A map containing key "count" with number of groups as value which matching with search.
     */
    @GET
    //@NoCache
    @Path("count")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Map<String, Long> count(@QueryParam("search") String search) {
        throw new UnsupportedOperationException();
    }

    /**
     * Counts groups by name search.
     * @param onlyTopGroups <code>true</code> or <code>false</code> for filter only top level groups count
     * @return A map containing key "count" with number of top level groups.
     */
    @GET
    //@NoCache
    @Path("count")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Map<String, Long> count(@QueryParam("top") @DefaultValue("true") boolean onlyTopGroups) {
        throw new UnsupportedOperationException();
    }

    /**
     * create or add a top level realm groupSet or create child.  This will update the group and set the parent if it exists.  Create it and set the parent
     * if the group doesn't exist.
     *
     * @param rep
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(GroupRepresentation rep) {
        throw new UnsupportedOperationException();
    }

    @Path("{id}")
    public GroupResource group(@PathParam("id") String id) {
        return new GroupResource(getTarget(),path + "/"+id);
    }

}
