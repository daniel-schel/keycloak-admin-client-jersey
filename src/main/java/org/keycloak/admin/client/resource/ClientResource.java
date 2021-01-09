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
import org.keycloak.representations.adapters.action.GlobalRequestResult;
import org.keycloak.representations.idm.ClientRepresentation;
import org.keycloak.representations.idm.ClientScopeRepresentation;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.keycloak.representations.idm.UserSessionRepresentation;
import org.keycloak.representations.idm.ManagementPermissionReference;
import org.keycloak.representations.idm.ManagementPermissionRepresentation;

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
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

/**
 * The type Client resource.
 *
 * Based on a fork of keycloak-amdin-client originally created by rodrigo.sasaki@icarros.com.br.
 *
 * @author daniel-schel
 */
public class ClientResource extends AbstractResource {

    private String clientPath = "";

    protected ClientResource(WebResource target) {
        super(target);
    }

    public ClientResource(WebResource target, String clientPath) {
        super(target);
        this.clientPath = clientPath;
    }

    /**
     * Enables or disables the fine grain permissions feature.
     * Returns the updated status of the server in the
     * {@link ManagementPermissionReference}.
     *
     * @param status status request to apply
     * @return permission reference indicating the updated status
     */
    @PUT
    @Path("/management/permissions")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ManagementPermissionReference setPermissions(ManagementPermissionRepresentation status) {
        return getTarget().path(clientPath + "/management/permissions").type(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE).entity(status).put(ManagementPermissionReference.class);
    }

    /**
     * Returns indicator if the fine grain permissions are enabled or not.
     *
     * @return current representation of the permissions feature
     */
    @GET
    @Path("/management/permissions")
    @Produces(MediaType.APPLICATION_JSON)
    public ManagementPermissionReference getPermissions() {
        return getTarget().path(clientPath + "/management/permissions").accept(MediaType.APPLICATION_JSON_TYPE).get(ManagementPermissionReference.class);
    }

    @Path("protocol-mappers")
    public ProtocolMappersResource getProtocolMappers() {
        return new ProtocolMappersResource(getTarget(),clientPath+"/protocol-mappers");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ClientRepresentation toRepresentation() {
        return getTarget().path(clientPath).accept(MediaType.APPLICATION_JSON_TYPE).get(ClientRepresentation.class);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(ClientRepresentation clientRepresentation) {
        getTarget().path(clientPath).type(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE).entity(clientRepresentation).put(ClientRepresentation.class);
    }

    @DELETE
    public void remove() {
        getTarget().path(clientPath).delete();
    }

    @POST
    @Path("client-secret")
    @Produces(MediaType.APPLICATION_JSON)
    public CredentialRepresentation generateNewSecret() {
        return getTarget().path(clientPath + "/client-secret").accept(MediaType.APPLICATION_JSON_TYPE).post(CredentialRepresentation.class);
    }

    @GET
    @Path("client-secret")
    @Produces(MediaType.APPLICATION_JSON)
    public CredentialRepresentation getSecret() {
        return getTarget().path(clientPath + "/client-secret").accept(MediaType.APPLICATION_JSON_TYPE).get(CredentialRepresentation.class);
    }

    /**
     * Generate a new registration access token for the client
     *
     * @return
     */
    @Path("registration-access-token")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ClientRepresentation regenerateRegistrationAccessToken() {
        return getTarget().path(clientPath + "/registration-access-token").accept(MediaType.APPLICATION_JSON_TYPE).post(ClientRepresentation.class);
    }

    /**
     * Get representation of certificate resource
     *
     * @param attributePrefix
     * @return
     */
    @Path("certificates/{attr}")
    public ClientAttributeCertificateResource getCertificateResource(@PathParam("attr") String attributePrefix) {
        return new ClientAttributeCertificateResource(getTarget(),clientPath+"/certificates/"+attributePrefix);
    }

    @GET
    //@NoCache
    @Path("installation/providers/{providerId}")
    public String getInstallationProvider(@PathParam("providerId") String providerId) {
        return getTarget().path(clientPath + "installation/providers/"+providerId).get(String.class);
    }

    @Path("session-count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Integer> getApplicationSessionCount() {
        throw new UnsupportedOperationException();
    }

    @Path("user-sessions")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserSessionRepresentation> getUserSessions(@QueryParam("first") Integer firstResult, @QueryParam("max") Integer maxResults) {
        throw new UnsupportedOperationException();
    }

    @Path("offline-session-count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Long> getOfflineSessionCount() {
        throw new UnsupportedOperationException();
    }

    @Path("offline-sessions")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserSessionRepresentation> getOfflineUserSessions(@QueryParam("first") Integer firstResult, @QueryParam("max") Integer maxResults) {
        throw new UnsupportedOperationException();
    }

    @POST
    @Path("push-revocation")
    @Produces(MediaType.APPLICATION_JSON)
    public void pushRevocation()  {
        throw new UnsupportedOperationException();
    }

    @Path("/scope-mappings")
    public RoleMappingResource getScopeMappings() {
        return new RoleMappingResource(getTarget(),clientPath+"/scope-mappings");
    }

    @Path("/roles")
    public RolesResource roles() {
        return new RolesResource(getTarget(),clientPath+"/roles");
    }

    /**
     * Get default client scopes.  Only name and ids are returned.
     *
     * @return default client scopes
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("default-client-scopes")
    public List<ClientScopeRepresentation> getDefaultClientScopes() {
        throw new UnsupportedOperationException();
    }

    @PUT
    @Path("default-client-scopes/{clientScopeId}")
    public void addDefaultClientScope(@PathParam("clientScopeId") String clientScopeId) {
        throw new UnsupportedOperationException();
    }

    @DELETE
    @Path("default-client-scopes/{clientScopeId}")
    public void removeDefaultClientScope(@PathParam("clientScopeId") String clientScopeId) {
        throw new UnsupportedOperationException();
    }

    /**
     * Get optional client scopes.  Only name and ids are returned.
     *
     * @return optional client scopes
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("optional-client-scopes")
    public List<ClientScopeRepresentation> getOptionalClientScopes() {
        throw new UnsupportedOperationException();
    }

    @PUT
    @Path("optional-client-scopes/{clientScopeId}")
    public void addOptionalClientScope(@PathParam("clientScopeId") String clientScopeId) {
        throw new UnsupportedOperationException();
    }

    @DELETE
    @Path("optional-client-scopes/{clientScopeId}")
    public void removeOptionalClientScope(@PathParam("clientScopeId") String clientScopeId) {
        throw new UnsupportedOperationException();
    }

    @Path("/service-account-user")
    @GET
    //@NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public UserRepresentation getServiceAccountUser() {
        throw new UnsupportedOperationException();
    }

    @Path("nodes")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void registerNode(Map<String, String> formParams) {
        throw new UnsupportedOperationException();
    }

    @Path("nodes/{node}")
    @DELETE
    public void unregisterNode(final @PathParam("node") String node) {
        throw new UnsupportedOperationException();
    }

    @Path("test-nodes-available")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public GlobalRequestResult testNodesAvailable() {
        throw new UnsupportedOperationException();
    }

    @Path("/authz/resource-server")
    public AuthorizationResource authorization() {
        return new AuthorizationResource(getTarget(),clientPath+"/authz/resource-server");
    }
}