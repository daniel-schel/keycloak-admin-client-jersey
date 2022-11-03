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
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

/**
 * The type Rule policies resource.
 *
 * Based on a fork of keycloak-amdin-client originally created by psilva@redhat.com.
 *
 * @author daniel-schel
 */
public class RealmLocalizationResource extends AbstractResource {

    private String path = "";

    /**
     * Instantiates a new Abstract resource.
     *
     * @param target the target
     */
    protected RealmLocalizationResource(WebResource target) {
        super(target);
    }

    /**
     * Instantiates a new Rule policies resource.
     *
     * @param target the target
     * @param path   the path
     */
    public RealmLocalizationResource(WebResource target, String path) {
        super(target);
        this.path = path;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getRealmSpecificLocales() {
        throw new UnsupportedOperationException();
    }

    @Path("{locale}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> getRealmLocalizationTexts(final @PathParam("locale") String locale,  @QueryParam("useRealmDefaultLocaleFallback") Boolean useRealmDefaultLocaleFallback) {
        throw new UnsupportedOperationException();
    }


    @Path("{locale}/{key}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getRealmLocalizationText(final @PathParam("locale") String locale, final @PathParam("key") String key) {
        throw new UnsupportedOperationException();
    }


    @Path("{locale}")
    @DELETE
    public void deleteRealmLocalizationTexts(@PathParam("locale") String locale) {
        throw new UnsupportedOperationException();
    }

    @Path("{locale}/{key}")
    @DELETE
    public void deleteRealmLocalizationText(@PathParam("locale") String locale, @PathParam("key") String key) {
        throw new UnsupportedOperationException();
    }

    @Path("{locale}/{key}")
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void saveRealmLocalizationText(@PathParam("locale") String locale, @PathParam("key") String key, String text) {
        throw new UnsupportedOperationException();
    }

    @Path("{locale}")
    @POST
    @Consumes("application/json")
    public void createOrUpdateRealmLocalizationTexts(@PathParam("locale") String locale, Map<String, String> localizationTexts) {
        throw new UnsupportedOperationException();
    }

}
