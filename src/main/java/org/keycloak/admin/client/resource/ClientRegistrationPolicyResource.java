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
import org.keycloak.representations.idm.ComponentTypeRepresentation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * The type Client registration policy resource.
 *
 * Based on a fork of keycloak-amdin-client originally created by mposolda@redhat.com.
 *
 * @author daniel-schel
 */
public class ClientRegistrationPolicyResource extends AbstractResource {

    private String path = "";

    /**
     * Instantiates a new Abstract resource.
     *
     * @param target the target
     */
    protected ClientRegistrationPolicyResource(WebResource target) {
        super(target);
    }

    public ClientRegistrationPolicyResource(WebResource target, String path) {
        super(target);
        this.path = path;
    }

    @Path("providers")
    @GET
        @Produces(MediaType.APPLICATION_JSON)
    public List<ComponentTypeRepresentation> getProviders() {
        throw new UnsupportedOperationException();
    }
}
