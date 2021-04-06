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
import org.keycloak.representations.idm.AuthenticationExecutionInfoRepresentation;
import org.keycloak.representations.idm.AuthenticationExecutionRepresentation;
import org.keycloak.representations.idm.AuthenticationFlowRepresentation;
import org.keycloak.representations.idm.AuthenticatorConfigInfoRepresentation;
import org.keycloak.representations.idm.AuthenticatorConfigRepresentation;
import org.keycloak.representations.idm.ConfigPropertyRepresentation;
import org.keycloak.representations.idm.RequiredActionProviderRepresentation;
import org.keycloak.representations.idm.RequiredActionProviderSimpleRepresentation;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

/**
 * The type Authentication management resource.
 *
 * Based on a fork of keycloak-amdin-client originally created by mstrukel@redhat.com.
 *
 * @author daniel-schel
 */
public class AuthenticationManagementResource extends AbstractResource {

    private String path = "";

    /**
     * Instantiates a new Abstract resource.
     *
     * @param target the target
     */
    protected AuthenticationManagementResource(WebResource target) {
        super(target);
    }

    public AuthenticationManagementResource(WebResource target, String path) {
        super(target);
        this.path = path;
    }

    @GET
    @Path("/form-providers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Map<String, Object>> getFormProviders() {
        throw new UnsupportedOperationException();
    }

    @Path("/authenticator-providers")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Map<String, Object>> getAuthenticatorProviders() {
        throw new UnsupportedOperationException();
    }

    @Path("/client-authenticator-providers")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Map<String, Object>> getClientAuthenticatorProviders() {
        throw new UnsupportedOperationException();
    }

    @Path("/form-action-providers")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Map<String, Object>> getFormActionProviders() {
        throw new UnsupportedOperationException();
    }

    @Path("/flows")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AuthenticationFlowRepresentation> getFlows() {
        throw new UnsupportedOperationException();
    }

    @Path("/flows")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createFlow(AuthenticationFlowRepresentation model) {
        throw new UnsupportedOperationException();
    }

    @Path("/flows/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public AuthenticationFlowRepresentation getFlow(@PathParam("id") String id) {
        throw new UnsupportedOperationException();
    }

    @Path("/flows/{id}")
    @DELETE
    public void deleteFlow(@PathParam("id") String id) {
        throw new UnsupportedOperationException();
    }

    @Path("/flows/{flowAlias}/copy")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response copy(@PathParam("flowAlias") String flowAlias, Map<String, String> data) {
        throw new UnsupportedOperationException();
    }

    @Path("/flows/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateFlow(@PathParam("id") String id, AuthenticationFlowRepresentation flow) {
        throw new UnsupportedOperationException();
    }

    @Path("/flows/{flowAlias}/executions/flow")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addExecutionFlow(@PathParam("flowAlias") String flowAlias, Map<String, String> data) {
        throw new UnsupportedOperationException();
    }

    @Path("/flows/{flowAlias}/executions/execution")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addExecution(@PathParam("flowAlias") String flowAlias, Map<String, String> data) {
        throw new UnsupportedOperationException();
    }

    @Path("/flows/{flowAlias}/executions")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AuthenticationExecutionInfoRepresentation> getExecutions(@PathParam("flowAlias") String flowAlias) {
        throw new UnsupportedOperationException();
    }

    @Path("/flows/{flowAlias}/executions")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateExecutions(@PathParam("flowAlias") String flowAlias, AuthenticationExecutionInfoRepresentation rep) {
        throw new UnsupportedOperationException();
    }

    @Path("/executions")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addExecution(AuthenticationExecutionRepresentation model) {
        throw new UnsupportedOperationException();
    }

    @Path("/executions/{executionId}")
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public AuthenticationExecutionRepresentation getExecution(final @PathParam("executionId") String executionId) {
        throw new UnsupportedOperationException();
    }

    @Path("/executions/{executionId}/raise-priority")
    @POST
    public void raisePriority(@PathParam("executionId") String execution) {
        throw new UnsupportedOperationException();
    }

    @Path("/executions/{executionId}/lower-priority")
    @POST
    public void lowerPriority(@PathParam("executionId") String execution) {
        throw new UnsupportedOperationException();
    }

    @Path("/executions/{executionId}")
    @DELETE
    public void removeExecution(@PathParam("executionId") String execution) {
        throw new UnsupportedOperationException();
    }

    @Path("/executions/{executionId}/config")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newExecutionConfig(@PathParam("executionId") String executionId, AuthenticatorConfigRepresentation config) {
        throw new UnsupportedOperationException();
    }

    @Path("unregistered-required-actions")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RequiredActionProviderSimpleRepresentation> getUnregisteredRequiredActions() {
        throw new UnsupportedOperationException();
    }

    @Path("register-required-action")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void registerRequiredAction(RequiredActionProviderSimpleRepresentation action) {
        throw new UnsupportedOperationException();
    }

    @Path("required-actions")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RequiredActionProviderRepresentation> getRequiredActions() {
        throw new UnsupportedOperationException();
    }

    @Path("required-actions/{alias}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RequiredActionProviderRepresentation getRequiredAction(@PathParam("alias") String alias) {
        throw new UnsupportedOperationException();
    }

    @Path("required-actions/{alias}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateRequiredAction(@PathParam("alias") String alias, RequiredActionProviderRepresentation rep) {
        throw new UnsupportedOperationException();
    }

    @Path("required-actions/{alias}")
    @DELETE
    public void removeRequiredAction(@PathParam("alias") String alias) {
        throw new UnsupportedOperationException();
    }

    @Path("required-actions/{alias}/raise-priority")
    @POST
    public void raiseRequiredActionPriority(@PathParam("alias") String alias) {
        throw new UnsupportedOperationException();
    }

    @Path("required-actions/{alias}/lower-priority")
    @POST
    public void lowerRequiredActionPriority(@PathParam("alias") String alias) {
        throw new UnsupportedOperationException();
    }

    @Path("config-description/{providerId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public AuthenticatorConfigInfoRepresentation getAuthenticatorConfigDescription(@PathParam("providerId") String providerId) {
        throw new UnsupportedOperationException();
    }

    @Path("per-client-config-description")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, List<ConfigPropertyRepresentation>> getPerClientConfigDescription() {
        throw new UnsupportedOperationException();
    }

    @Path("config/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public AuthenticatorConfigRepresentation getAuthenticatorConfig(@PathParam("id") String id) {
        throw new UnsupportedOperationException();
    }

    @Path("config/{id}")
    @DELETE
    public void removeAuthenticatorConfig(@PathParam("id") String id) {
        throw new UnsupportedOperationException();
    }

    @Path("config/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateAuthenticatorConfig(@PathParam("id") String id, AuthenticatorConfigRepresentation config) {
        throw new UnsupportedOperationException();
    }
}
