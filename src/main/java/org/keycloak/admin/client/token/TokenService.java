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

package org.keycloak.admin.client.token;

import com.sun.jersey.api.client.WebResource;
import org.keycloak.admin.client.AbstractResource;
import org.keycloak.representations.AccessTokenResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

/**
 * The type Token service.
 *
 * Based on a fork of keycloak-amdin-client originally created by rodrigo.sasaki@icarros.com.br.
 *
 * @author daniel-schel
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public class TokenService extends AbstractResource {

    public TokenService(WebResource target){
        super(target);
    }

    @POST
    @Path("/realms/{realm}/protocol/openid-connect/token")
    public AccessTokenResponse grantToken(@PathParam("realm") String realm, MultivaluedMap<String, String> map) {
        return getTarget().path("/realms/"+realm+"/protocol/openid-connect/token").type(MediaType.APPLICATION_FORM_URLENCODED).accept(MediaType.APPLICATION_JSON).entity(map,MediaType.APPLICATION_FORM_URLENCODED).post(AccessTokenResponse.class);
    }

    @POST
    @Path("/realms/{realm}/protocol/openid-connect/token")
    public AccessTokenResponse refreshToken(@PathParam("realm") String realm, MultivaluedMap<String, String> map) {
        return getTarget().path("/realms/"+realm+"/protocol/openid-connect/token").type(MediaType.APPLICATION_FORM_URLENCODED).accept(MediaType.APPLICATION_JSON).entity(map,MediaType.APPLICATION_FORM_URLENCODED).post(AccessTokenResponse.class);
    }

    @POST
    @Path("/realms/{realm}/protocol/openid-connect/logout")
    public void logout(@PathParam("realm") String realm, MultivaluedMap<String, String> map) {
        getTarget().path("/realms/"+realm+"/protocol/openid-connect/logout").type(MediaType.APPLICATION_FORM_URLENCODED).entity(map,MediaType.APPLICATION_FORM_URLENCODED).post();
    }

}
