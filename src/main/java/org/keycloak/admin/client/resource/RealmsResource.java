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
import org.keycloak.representations.idm.RealmRepresentation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * The type Realms resource.
 *
 * Based on a fork of keycloak-amdin-client originally created by rodrigo.sasaki@icarros.com.br.
 *
 * @author daniel-schel
 */
@Path("/admin/realms")
@Consumes(MediaType.APPLICATION_JSON)
public class RealmsResource extends AbstractResource {

    private static final String BASE_PATH = "/admin/realms";

    public RealmsResource(WebResource target){
        super(target);
    }

    @Path("/{realm}")
    public RealmResource realm(@PathParam("realm") String realm) {
        return new RealmResource(getTarget(), BASE_PATH + "/" + realm);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(RealmRepresentation realmRepresentation) {
        getTarget().path(BASE_PATH).accept(MediaType.APPLICATION_JSON).entity(realmRepresentation,MediaType.APPLICATION_JSON).post();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RealmRepresentation> findAll() {
        return getTarget().path(BASE_PATH).type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).get(new GenericType<List<RealmRepresentation>>(){});
    }

}
