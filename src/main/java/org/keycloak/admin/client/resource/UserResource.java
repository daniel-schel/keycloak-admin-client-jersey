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
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.FederatedIdentityRepresentation;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.keycloak.representations.idm.UserSessionRepresentation;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
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
 * The type User resource.
 *
 * Based on a fork of keycloak-amdin-client originally created by rodrigo.sasaki@icarros.com.br.
 *
 * @author daniel-schel
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource extends AbstractResource {

    private String path = "";

    /**
     * Instantiates a new User resource.
     *
     * @param target the target
     */
    protected UserResource(WebResource target) {
        super(target);
    }

    /**
     * Instantiates a new User resource.
     *
     * @param target the target
     * @param path   the path
     */
    public UserResource(WebResource target, String path) {
        super(target);
        this.path = path;
    }

    @GET
    public UserRepresentation toRepresentation() {
        throw new UnsupportedOperationException();
    }

    @PUT
    public void update(UserRepresentation userRepresentation) {
        throw new UnsupportedOperationException();
    }

    @DELETE
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Path("groups")
    @GET
    public List<GroupRepresentation> groups() {
        throw new UnsupportedOperationException();
    }

    @Path("groups")
    @GET
    public List<GroupRepresentation> groups(@QueryParam("first") Integer firstResult,
                                     @QueryParam("max") Integer maxResults) {
        throw new UnsupportedOperationException();
    }

    @Path("groups")
    @GET
    public List<GroupRepresentation> groups(@QueryParam("search") String search,
                                     @QueryParam("first") Integer firstResult,
                                     @QueryParam("max") Integer maxResults) {
        throw new UnsupportedOperationException();
    }

    @Path("groups")
    @GET
    public List<GroupRepresentation> groups(@QueryParam("first") Integer firstResult,
                                     @QueryParam("max") Integer maxResults,
                                     @QueryParam("briefRepresentation") @DefaultValue("true") boolean briefRepresentation) {
        throw new UnsupportedOperationException();
    }

    @Path("groups")
    @GET
    public List<GroupRepresentation> groups(@QueryParam("search") String search,
                                     @QueryParam("first") Integer firstResult,
                                     @QueryParam("max") Integer maxResults,
                                     @QueryParam("briefRepresentation") @DefaultValue("true") boolean briefRepresentation) {
        throw new UnsupportedOperationException();
    }

    @Path("groups/count")
    @GET
    public Map<String, Long> groupsCount(@QueryParam("search") String search) {
        throw new UnsupportedOperationException();
    }


    @Path("groups/{groupId}")
    @PUT
    public void joinGroup(@PathParam("groupId") String groupId) {
        throw new UnsupportedOperationException();
    }

    @Path("groups/{groupId}")
    @DELETE
    public void leaveGroup(@PathParam("groupId") String groupId) {
        throw new UnsupportedOperationException();
    }




    @POST
    @Path("logout")
    public void logout() {
        throw new UnsupportedOperationException();
    }



    @GET
    @Path("credentials")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CredentialRepresentation> credentials() {
        throw new UnsupportedOperationException();
    }

    /**
     * Return credential types, which are provided by the user storage where user is stored. Returned values can contain for example "password", "otp" etc.
     * This will always return empty list for "local" users, which are not backed by any user storage
     *
     * @return
     */
    @GET
    @Path("configured-user-storage-credential-types")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getConfiguredUserStorageCredentialTypes() {
        throw new UnsupportedOperationException();
    }

    /**
     * Remove a credential for a user
     *
     */
    @DELETE
    @Path("credentials/{credentialId}")
    public void removeCredential(@PathParam("credentialId")String credentialId) {
        throw new UnsupportedOperationException();
    }

    /**
     * Update a credential label for a user
     */
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.TEXT_PLAIN)
    @Path("credentials/{credentialId}/userLabel")
    public void setCredentialUserLabel(final @PathParam("credentialId") String credentialId, String userLabel) {
        throw new UnsupportedOperationException();
    }

    /**
     * Move a credential to a first position in the credentials list of the user
     * @param credentialId The credential to move
     */
    @Path("credentials/{credentialId}/moveToFirst")
    @POST
    public void moveCredentialToFirst(final @PathParam("credentialId") String credentialId) {
        throw new UnsupportedOperationException();
    }

    /**
     * Move a credential to a position behind another credential
     * @param credentialId The credential to move
     * @param newPreviousCredentialId The credential that will be the previous element in the list. If set to null, the moved credential will be the first element in the list.
     */
    @Path("credentials/{credentialId}/moveAfter/{newPreviousCredentialId}")
    @POST
    public void moveCredentialAfter(final @PathParam("credentialId") String credentialId, final @PathParam("newPreviousCredentialId") String newPreviousCredentialId) {
        throw new UnsupportedOperationException();
    }


    /**
     * Disables or deletes all credentials for specific types.
     * Type examples "otp", "password"
     *
     * This is typically supported just for the users backed by user storage providers. See {@link UserRepresentation#getDisableableCredentialTypes()}
     * to see what credential types can be disabled for the particular user
     *
     * @param credentialTypes
     */
    @Path("disable-credential-types")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void disableCredentialType(List<String> credentialTypes) {
        throw new UnsupportedOperationException();
    }

    @PUT
    @Path("reset-password")
    public void resetPassword(CredentialRepresentation credentialRepresentation) {
        throw new UnsupportedOperationException();
    }

    /**
     * Use executeActionsEmail and pass in the UPDATE_PASSWORD required action
     *
     */
    @PUT
    @Path("reset-password-email")
    @Deprecated
    public void resetPasswordEmail() {
        throw new UnsupportedOperationException();
    }

    /**
     * Use executeActionsEmail and pass in the UPDATE_PASSWORD required action
     *
     */
    @PUT
    @Path("reset-password-email")
    @Deprecated
    public void resetPasswordEmail(@QueryParam("client_id") String clientId) {
        throw new UnsupportedOperationException();
    }

    /**
     * Sends an email to the user with a link within it.  If they click on the link they will be asked to perform some actions
     * i.e. {@code VERIFY_EMAIL, UPDATE_PROFILE, CONFIGURE_TOTP, UPDATE_PASSWORD, TERMS_AND_CONDITIONS}, etc.
     *
     * @param actions a {@link List} of string representation of {@link org.keycloak.models.UserModel.RequiredAction}
     */
    @PUT
    @Path("execute-actions-email")
    public void executeActionsEmail(List<String> actions) {
        throw new UnsupportedOperationException();
    }

    /**
     * Sends an email to the user with a link within it.  If they click on the link they will be asked to perform some actions
     * i.e. {@code VERIFY_EMAIL, UPDATE_PROFILE, CONFIGURE_TOTP, UPDATE_PASSWORD, TERMS_AND_CONDITIONS}, etc.
     *
     * The lifespan decides the number of seconds after which the generated token in the email link expires. The default
     * value is 12 hours.
     *
     * @param actions a {@link List} of string representation of {@link org.keycloak.models.UserModel.RequiredAction}
     * @param lifespan
     */
    @PUT
    @Path("execute-actions-email")
    public void executeActionsEmail(List<String> actions, @QueryParam("lifespan") Integer lifespan) {
        throw new UnsupportedOperationException();
    }

    /**
     * Sends an email to the user with a link within it.  If they click on the link they will be asked to perform some actions
     * i.e. {@code VERIFY_EMAIL, UPDATE_PROFILE, CONFIGURE_TOTP, UPDATE_PASSWORD, TERMS_AND_CONDITIONS}, etc.
     *
     * If redirectUri is not null, then you must specify a client id.  This will set the URI you want the flow to link
     * to after the email link is clicked and actions completed.  If both parameters are null, then no page is linked to
     * at the end of the flow.
     *
     * The lifespan decides the number of seconds after which the generated token in the email link expires. The default
     * value is 12 hours.
     *
     * @param clientId
     * @param redirectUri
     * @param lifespan
     * @param actions a {@link List} of string representation of {@link org.keycloak.models.UserModel.RequiredAction}
     */
    @PUT
    @Path("execute-actions-email")
    public void executeActionsEmail(@QueryParam("client_id") String clientId,
                             @QueryParam("redirect_uri") String redirectUri,
                             @QueryParam("lifespan") Integer lifespan,
                             List<String> actions) {
        throw new UnsupportedOperationException();
    }

    /**
     * Sends an email to the user with a link within it.  If they click on the link they will be asked to perform some actions
     * i.e. {@code VERIFY_EMAIL, UPDATE_PROFILE, CONFIGURE_TOTP, UPDATE_PASSWORD, TERMS_AND_CONDITIONS}, etc.
     *
     * If redirectUri is not null, then you must specify a client id.  This will set the URI you want the flow to link
     * to after the email link is clicked and actions completed.  If both parameters are null, then no page is linked to
     * at the end of the flow.
     *
     * @param clientId
     * @param redirectUri
     * @param actions a {@link List} of string representation of {@link org.keycloak.models.UserModel.RequiredAction}
     */
    @PUT
    @Path("execute-actions-email")
    public void executeActionsEmail(@QueryParam("client_id") String clientId, @QueryParam("redirect_uri") String redirectUri, List<String> actions) {
        throw new UnsupportedOperationException();
    }

    @PUT
    @Path("send-verify-email")
    public void sendVerifyEmail() {
        throw new UnsupportedOperationException();
    }

    @PUT
    @Path("send-verify-email")
    public void sendVerifyEmail(@QueryParam("client_id") String clientId) {
        throw new UnsupportedOperationException();
    }

    @GET
    @Path("sessions")
    public List<UserSessionRepresentation> getUserSessions() {
        throw new UnsupportedOperationException();
    }

    @GET
    @Path("offline-sessions/{clientId}")
    public List<UserSessionRepresentation> getOfflineSessions(@PathParam("clientId") String clientId) {
        throw new UnsupportedOperationException();
    }

    @GET
    @Path("federated-identity")
    public List<FederatedIdentityRepresentation> getFederatedIdentity() {
        throw new UnsupportedOperationException();
    }

    @POST
    @Path("federated-identity/{provider}")
    public Response addFederatedIdentity(@PathParam("provider") String provider, FederatedIdentityRepresentation rep) {
        throw new UnsupportedOperationException();
    }

    @Path("federated-identity/{provider}")
    @DELETE
    public void removeFederatedIdentity(final @PathParam("provider") String provider) {
        throw new UnsupportedOperationException();
    }

    @Path("role-mappings")
    public RoleMappingResource roles() {
        throw new UnsupportedOperationException();
    }


    @GET
    @Path("consents")
    public List<Map<String, Object>> getConsents() {
        throw new UnsupportedOperationException();
    }

    @DELETE
    @Path("consents/{client}")
    public void revokeConsent(@PathParam("client") String clientId) {
        throw new UnsupportedOperationException();
    }

    @POST
    @Path("impersonation")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> impersonate() {
        throw new UnsupportedOperationException();
    }
}
