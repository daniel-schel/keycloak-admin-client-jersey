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
import org.keycloak.representations.info.ServerInfoRepresentation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * The type Server info resource.
 *
 * Based on a fork of keycloak-amdin-client originally created by sthorger@redhat.com.
 *
 * @author daniel-schel
 */
@Path("/admin/serverinfo")
public class ServerInfoResource extends AbstractResource {

    /**
     * Instantiates a new Server info resource.
     *
     * @param target the target
     */
    public ServerInfoResource(WebResource target){
        super(target);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ServerInfoRepresentation getInfo() {
        return getTarget().path("/admin/serverinfo").accept(MediaType.APPLICATION_JSON).get(ServerInfoRepresentation.class);
    }

}
