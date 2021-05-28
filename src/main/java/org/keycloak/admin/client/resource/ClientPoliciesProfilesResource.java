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

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * The type Client policies profiles resource.
 *
 * Based on a fork of keycloak-amdin-client originally created by takashi.norimatsu.ws@hitachi.com.
 *
 * @author daniel-schel
 */
public class ClientPoliciesProfilesResource extends AbstractResource {

    private String path = "";

    /**
     * Instantiates a new Client policies profiles resource.
     *
     * @param target the target
     */
    protected ClientPoliciesProfilesResource(WebResource target) {
        super(target);
    }

    /**
     * Instantiates a new Client policies profiles resource.
     *
     * @param target the target
     * @param path   the path
     */
    public ClientPoliciesProfilesResource(WebResource target, String path) {
        super(target);
        this.path = path;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getProfiles(){
        return getTarget().path(path).accept(MediaType.APPLICATION_JSON).get(String.class);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProfiles(final String json){
        return getTarget().path(path).type(MediaType.APPLICATION_JSON_TYPE).put(Response.class, json);
    }

}
