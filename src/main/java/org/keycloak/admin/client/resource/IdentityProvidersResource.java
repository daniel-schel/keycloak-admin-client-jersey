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
import com.sun.jersey.multipart.FormDataMultiPart;
import org.keycloak.admin.client.AbstractResource;
import org.keycloak.representations.idm.IdentityProviderRepresentation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

/**
 * The type Identity providers resource.
 *
 * Based on a fork of keycloak-amdin-client originally created by psilva@redhat.com.
 *
 * @author daniel-schel
 */
public class IdentityProvidersResource extends AbstractResource {

    private String path = "";

    /**
     * Instantiates a new Abstract resource.
     *
     * @param target the target
     */
    protected IdentityProvidersResource(WebResource target) {
        super(target);
    }

    public IdentityProvidersResource(WebResource target, String path) {
        super(target);
        this.path = path;
    }

    @Path("instances/{alias}")
    public IdentityProviderResource get(@PathParam("alias") String alias) {
        return new IdentityProviderResource(getTarget(), path + "/instances/" + alias);
    }

    @GET
    @Path("instances")
    @Produces(MediaType.APPLICATION_JSON)
    public List<IdentityProviderRepresentation> findAll() {
        throw new UnsupportedOperationException();
    }

    @POST
    @Path("instances")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(IdentityProviderRepresentation identityProvider) {
        throw new UnsupportedOperationException();
    }

    @GET
    @Path("/providers/{provider_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIdentityProviders(@PathParam("provider_id") String providerId) {
        throw new UnsupportedOperationException();
    }

    @POST
    @Path("import-config")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> importFrom(FormDataMultiPart data) {
        throw new UnsupportedOperationException();
    }

    @POST
    @Path("import-config")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> importFrom(Map<String, Object> data) {
        throw new UnsupportedOperationException();
    }
}
