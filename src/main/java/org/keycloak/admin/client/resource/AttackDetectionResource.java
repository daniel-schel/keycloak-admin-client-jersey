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

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * The type Attack detection resource.
 *
 * Based on a fork of keycloak-amdin-client originally created by sthorger@redhat.com.
 *
 * @author daniel-schel
 */
public class AttackDetectionResource extends AbstractResource {

    private String path = "";

    /**
     * Instantiates a new Abstract resource.
     *
     * @param target the target
     */
    protected AttackDetectionResource(WebResource target) {
        super(target);
    }

    public AttackDetectionResource(WebResource target, String path) {
        super(target);
        this.path = path;
    }

    @GET
    @Path("brute-force/users/{userId}")
    //@NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> bruteForceUserStatus(@PathParam("userId") String userId) {
        throw new UnsupportedOperationException();
    }

    @Path("brute-force/users/{userId}")
    @DELETE
    public void clearBruteForceForUser(@PathParam("userId") String userId) {
        throw new UnsupportedOperationException();
    }

    @Path("brute-force/users")
    @DELETE
    public void clearAllBruteForce() {
        throw new UnsupportedOperationException();
    }

}
