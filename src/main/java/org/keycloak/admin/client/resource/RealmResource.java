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
import com.sun.jersey.core.util.MultivaluedMapImpl;
import org.keycloak.admin.client.AbstractResource;
import org.keycloak.representations.adapters.action.GlobalRequestResult;
import org.keycloak.representations.idm.AdminEventRepresentation;
import org.keycloak.representations.idm.ClientRepresentation;
import org.keycloak.representations.idm.ClientScopeRepresentation;
import org.keycloak.representations.idm.EventRepresentation;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.PartialImportRepresentation;
import org.keycloak.representations.idm.RealmEventsConfigRepresentation;
import org.keycloak.representations.idm.RealmRepresentation;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

/**
 * The type Realm resource.
 *
 * Based on a fork of keycloak-amdin-client originally created by rodrigo.sasaki@icarros.com.br.
 *
 * @author daniel-schel
 */
public class RealmResource extends AbstractResource {

    private String path = "";

    /**
     * Instantiates a new Abstract resource.
     *
     * @param target the target
     */
    protected RealmResource(WebResource target) {
        super(target);
    }

    /**
     * Instantiates a new Realm resource.
     *
     * @param target    the target
     * @param path the realm path
     */
    public RealmResource(WebResource target, String path) {
        super(target);
        this.path = path;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RealmRepresentation toRepresentation() {
        return getTarget().path(path).accept(MediaType.APPLICATION_JSON).get(RealmRepresentation.class);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(RealmRepresentation realmRepresentation) {
        getTarget().path(path).type(MediaType.APPLICATION_JSON).entity(realmRepresentation).put();
    }

    @Path("clients")
    public ClientsResource clients() {
        return new ClientsResource(getTarget(), path +"/clients");
    }

    @Path("client-scopes")
    public ClientScopesResource clientScopes() {
        return new ClientScopesResource(getTarget(), path +"/client-scopes");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("default-default-client-scopes")
    public List<ClientScopeRepresentation> getDefaultDefaultClientScopes() {
        return getTarget().path(path + "/default-default-client-scopes").accept(MediaType.APPLICATION_JSON).get(new GenericType<List<ClientScopeRepresentation>>() {
        });
    }

    @PUT
    @Path("default-default-client-scopes/{clientScopeId}")
    public void addDefaultDefaultClientScope(@PathParam("clientScopeId") String clientScopeId) {
        getTarget().path(path + "/default-default-client-scopes/" + clientScopeId).put();
    }

    @DELETE
    @Path("default-default-client-scopes/{clientScopeId}")
    public void removeDefaultDefaultClientScope(@PathParam("clientScopeId") String clientScopeId) {
        getTarget().path(path + "/default-default-client-scopes/" + clientScopeId).delete();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("default-optional-client-scopes")
    public List<ClientScopeRepresentation> getDefaultOptionalClientScopes() {
        return getTarget().path(path + "/default-optional-client-scopes").accept(MediaType.APPLICATION_JSON).get(new GenericType<List<ClientScopeRepresentation>>() {
        });
    }

    @PUT
    @Path("default-optional-client-scopes/{clientScopeId}")
    public void addDefaultOptionalClientScope(@PathParam("clientScopeId") String clientScopeId) {
        getTarget().path(path + "/default-optional-client-scopes/" + clientScopeId).put();
    }

    @DELETE
    @Path("default-optional-client-scopes/{clientScopeId}")
    public void removeDefaultOptionalClientScope(@PathParam("clientScopeId") String clientScopeId) {
        getTarget().path(path + "/default-optional-client-scopes/" + clientScopeId).delete();
    }

    @Path("client-description-converter")
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    @Produces(MediaType.APPLICATION_JSON)
    public ClientRepresentation convertClientDescription(String description) {
        return getTarget().path(path + "/client-description-converter").type(MediaType.TEXT_PLAIN).accept(MediaType.APPLICATION_JSON_TYPE).entity(description).post(ClientRepresentation.class);
    }

    @Path("users")
    public UsersResource users() {
        return new UsersResource(getTarget(), path +"/users");
    }

    @Path("roles")
    public RolesResource roles() {
        return new RolesResource(getTarget(), path + "/roles");
    }

    @Path("roles-by-id")
    public RoleByIdResource rolesById() {
        return new RoleByIdResource(getTarget(), path + "/roles-by-id");
    }

    @Path("groups")
    public GroupsResource groups() {
        return new GroupsResource(getTarget(), path + "/groups");
    }

    @DELETE
    @Path("events")
    public void clearEvents() {
        getTarget().path(path + "/events").delete();
    }

    @GET
    @Path("events")
    @Produces(MediaType.APPLICATION_JSON)
    public List<EventRepresentation> getEvents() {
        return getTarget().path(path + "/events").accept(MediaType.APPLICATION_JSON).get(new GenericType<List<EventRepresentation>>() {
        });
    }

    @Path("events")
    @GET
    //@NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public List<EventRepresentation> getEvents(@QueryParam("type") List<String> types, @QueryParam("client") String client,
                                               @QueryParam("user") String user, @QueryParam("dateFrom") String dateFrom, @QueryParam("dateTo") String dateTo,
                                               @QueryParam("ipAddress") String ipAddress, @QueryParam("first") Integer firstResult,
                                               @QueryParam("max") Integer maxResults) {
        MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
        queryParams.add("type", String.join(",", types));
        queryParams.add("client", client);
        queryParams.add("user", user);
        queryParams.add("dateFrom", dateFrom);
        queryParams.add("dateTo", dateTo);
        queryParams.add("ipAddress", ipAddress);
        queryParams.add("first", firstResult.toString());
        queryParams.add("max", maxResults.toString());
        return getTarget().path(path + "/events").queryParams(queryParams).accept(MediaType.APPLICATION_JSON).get(new GenericType<List<EventRepresentation>>() {
        });
    }

    @DELETE
    @Path("admin-events")
    public void clearAdminEvents() {
        getTarget().path(path + "/admin-events").delete();
    }

    @GET
    @Path("admin-events")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AdminEventRepresentation> getAdminEvents() {
        return getTarget().path(path + "/admin-events").accept(MediaType.APPLICATION_JSON).get(new GenericType<List<AdminEventRepresentation>>() {});
    }

    @GET
    @Path("admin-events")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AdminEventRepresentation> getAdminEvents(@QueryParam("operationTypes") List<String> operationTypes, @QueryParam("authRealm") String authRealm,
                                                         @QueryParam("authClient") String authClient, @QueryParam("authUser") String authUser,
                                                         @QueryParam("authIpAddress") String authIpAddress, @QueryParam("resourcePath") String resourcePath,
                                                         @QueryParam("dateFrom") String dateFrom, @QueryParam("dateTo") String dateTo,
                                                         @QueryParam("first") Integer firstResult, @QueryParam("max") Integer maxResults) {
        MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
        queryParams.add("operationTypes", String.join(",", operationTypes));
        queryParams.add("authRealm", authRealm);
        queryParams.add("authClient", authClient);
        queryParams.add("authUser", authUser);
        queryParams.add("authIpAddress", authIpAddress);
        queryParams.add("resourcePath", resourcePath);
        queryParams.add("dateFrom", dateFrom);
        queryParams.add("dateTo", dateTo);
        queryParams.add("first", firstResult.toString());
        queryParams.add("max", maxResults.toString());
        return getTarget().path(path + "/admin-events").queryParams(queryParams).accept(MediaType.APPLICATION_JSON).get(new GenericType<List<AdminEventRepresentation>>() {
        });
    }

    @GET
    @Path("events/config")
    @Produces(MediaType.APPLICATION_JSON)
    public RealmEventsConfigRepresentation getRealmEventsConfig() {
        return getTarget().path(path + "/events/config").accept(MediaType.APPLICATION_JSON).get(RealmEventsConfigRepresentation.class);
    }

    @PUT
    @Path("events/config")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateRealmEventsConfig(RealmEventsConfigRepresentation rep) {
        getTarget().path(path + "/events/config").type(MediaType.APPLICATION_JSON_TYPE).entity(rep).put();
    }

    @GET
    @Path("group-by-path/{path: .*}")
    //@NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public GroupRepresentation getGroupByPath(@PathParam("path") String path) {
        return getTarget().path(this.path + "/group-by-path/" + path).accept(MediaType.APPLICATION_JSON).get(GroupRepresentation.class);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("default-groups")
    public List<GroupRepresentation> getDefaultGroups() {
        return getTarget().path(path + "/default-groups").accept(MediaType.APPLICATION_JSON).get(new GenericType<List<GroupRepresentation>>() {
        });
    }

    @PUT
    @Path("default-groups/{groupId}")
    public void addDefaultGroup(@PathParam("groupId") String groupId) {
        getTarget().path(path + "/default-groups/" + groupId).put();
    }

    @DELETE
    @Path("default-groups/{groupId}")
    public void removeDefaultGroup(@PathParam("groupId") String groupId) {
        getTarget().path(path + "/default-groups/" + groupId).delete();
    }

    @Path("identity-provider")
    public IdentityProvidersResource identityProviders() {
        return new IdentityProvidersResource(getTarget(), path + "/identity-provider");
    }

    @DELETE
    public void remove() {
        getTarget().path(path).delete();
    }

    @Path("client-session-stats")
    @GET
    public List<Map<String, String>> getClientSessionStats() {
        return getTarget().path(path + "/client-session-stats").accept(MediaType.APPLICATION_JSON).get(new GenericType<List<Map<String, String>>>() {
        });
    }

    @Path("clients-initial-access")
    public ClientInitialAccessResource clientInitialAccess() {
        return new ClientInitialAccessResource(getTarget(), path + "/clients-initial-access");
    }

    @Path("client-registration-policy")
    public ClientRegistrationPolicyResource clientRegistrationPolicy() {
        return new ClientRegistrationPolicyResource(getTarget(), path + "/client-registration-policy");
    }

    @Path("partialImport")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response partialImport(PartialImportRepresentation rep) {
        return getTarget().path(path + "/partialImport").type(MediaType.APPLICATION_JSON_TYPE).entity(rep).post(Response.class);
    }

    @Path("partial-export")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public RealmRepresentation partialExport(@QueryParam("exportGroupsAndRoles") Boolean exportGroupsAndRoles,
                                             @QueryParam("exportClients") Boolean exportClients) {
        MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
        queryParams.add("exportGroupsAndRoles", exportGroupsAndRoles.toString());
        queryParams.add("exportClients", exportClients.toString());
        return getTarget().path(path + "/partial-export").queryParams(queryParams).accept(MediaType.APPLICATION_JSON).post(RealmRepresentation.class);
    }

    @Path("authentication")
    @Consumes(MediaType.APPLICATION_JSON)
    public AuthenticationManagementResource flows() {
        return new AuthenticationManagementResource(getTarget(), path + "/authentication");
    }

    @Path("attack-detection")
    public AttackDetectionResource attackDetection() {
        return new AttackDetectionResource(getTarget(), path + "/attack-detection");
    }

    @Path("testLDAPConnection")
    @POST
    //@NoCache
    public Response testLDAPConnection(@FormParam("action") String action, @FormParam("connectionUrl") String connectionUrl,
                                       @FormParam("bindDn") String bindDn, @FormParam("bindCredential") String bindCredential,
                                       @FormParam("useTruststoreSpi") String useTruststoreSpi, @FormParam("connectionTimeout") String connectionTimeout) {
        throw new UnsupportedOperationException();
    }

    @Path("testSMTPConnection/{config}")
    @POST
    //@NoCache
    @Consumes(MediaType.APPLICATION_JSON)
    public Response testSMTPConnection(final @PathParam("config") String config) throws Exception {
        return getTarget().path(path + "/testSMTPConnection/" + config).post(Response.class);
    }

    @Path("clear-realm-cache")
    @POST
    public void clearRealmCache() {
        getTarget().path(path + "/clear-realm-cache").post();
    }

    @Path("clear-user-cache")
    @POST
    public void clearUserCache() {
        getTarget().path(path + "/clear-user-cache").post();
    }

    @Path("clear-keys-cache")
    @POST
    public void clearKeysCache() {
        getTarget().path(path + "/clear-keys-cache").post();
    }

    @Path("push-revocation")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public GlobalRequestResult pushRevocation() {
        return getTarget().path(path + "/push-revocation").accept(MediaType.APPLICATION_JSON).post(GlobalRequestResult.class);
    }

    @Path("logout-all")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public GlobalRequestResult logoutAll() {
        return getTarget().path(path + "/logout-all").accept(MediaType.APPLICATION_JSON).post(GlobalRequestResult.class);
    }

    @Path("sessions/{session}")
    @DELETE
    public void deleteSession(@PathParam("session") String sessionId) {
        getTarget().path(path + "/sessions/" + sessionId).delete();
    }

    @Path("components")
    public ComponentsResource components() {
        return new ComponentsResource(getTarget(), path + "/components");
    }

    @Path("user-storage")
    public UserStorageProviderResource userStorage() {
        return new UserStorageProviderResource(getTarget(), path +"/user-storage");
    }

    @Path("keys")
    public KeyResource keys() {
        return new KeyResource(getTarget(), path + "/keys");
    }

}
