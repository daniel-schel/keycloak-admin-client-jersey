/*
 * Copyright 2021 Red Hat, Inc. and/or its affiliates
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
import org.keycloak.representations.idm.authorization.RegexPolicyRepresentation;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * The type Regex policies resource.
 *
 * Based on a fork of keycloak-amdin-client originally created by yoshiyuki.tabata.jy@hitachi.com.
 *
 * @author daniel-schel
 */
public class RegexPoliciesResource extends AbstractResource {

    private String path = "";

    protected RegexPoliciesResource(WebResource target) {
        super(target);
    }

    public RegexPoliciesResource(WebResource target, String path) {
        super(target);
        this.path = path;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(RegexPolicyRepresentation representation) {
        throw new UnsupportedOperationException();
    }

}
