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
import org.keycloak.representations.idm.authorization.PolicyEvaluationRequest;
import org.keycloak.representations.idm.authorization.PolicyEvaluationResponse;
import org.keycloak.representations.idm.authorization.PolicyProviderRepresentation;
import org.keycloak.representations.idm.authorization.PolicyRepresentation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * The type Policies resource.
 *
 * Based on a fork of keycloak-amdin-client originally created by psilva@redhat.com.
 *
 * @author daniel-schel
 */
public class PoliciesResource extends AbstractResource {

    private String path = "";

    /**
     * Instantiates a new Abstract resource.
     *
     * @param target the target
     */
    protected PoliciesResource(WebResource target) {
        super(target);
    }

    /**
     * Instantiates a new Policies resource.
     *
     * @param target the target
     * @param path   the path
     */
    public PoliciesResource(WebResource target, String path) {
        super(target);
        this.path = path;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(PolicyRepresentation representation) {
        throw new UnsupportedOperationException();
    }

    @Path("{id}")
    public PolicyResource policy(@PathParam("id") String id) {
        return new PolicyResource(getTarget(), path + "/" + id);
    }

    @Path("/search")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@NoCache
    public PolicyRepresentation findByName(@QueryParam("name") String name) {
        throw new UnsupportedOperationException();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@NoCache
    public List<PolicyRepresentation> policies() {
        throw new UnsupportedOperationException();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@NoCache
    public List<PolicyRepresentation> policies(@QueryParam("policyId") String id,
                                        @QueryParam("name") String name,
                                        @QueryParam("type") String type,
                                        @QueryParam("resource") String resource,
                                        @QueryParam("scope") String scope,
                                        @QueryParam("permission") Boolean permission,
                                        @QueryParam("owner") String owner,
                                        @QueryParam("fields") String fields,
                                        @QueryParam("first") Integer firstResult,
                                        @QueryParam("max") Integer maxResult) {
        throw new UnsupportedOperationException();
    }

    @Path("providers")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@NoCache
    public List<PolicyProviderRepresentation> policyProviders() {
        throw new UnsupportedOperationException();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("evaluate")
    public PolicyEvaluationResponse evaluate(PolicyEvaluationRequest evaluationRequest) {
        throw new UnsupportedOperationException();
    }

    @Path("role")
    public RolePoliciesResource role() {
        return new RolePoliciesResource(getTarget(),path+"/role");
    }

    @Path("user")
    public UserPoliciesResource user() {
        return new UserPoliciesResource(getTarget(),path+"/user");
    }
    @Path("js")
    public JSPoliciesResource js() {
        return new JSPoliciesResource(getTarget(),path+"/js");
    }

    @Path("time")
    public TimePoliciesResource time() {
        return new TimePoliciesResource(getTarget(),path+"/time");
    }

    @Path("aggregate")
    public AggregatePoliciesResource aggregate() {
        return new AggregatePoliciesResource(getTarget(),path+"/aggregate");
    }

    @Path("client")
    public ClientPoliciesResource client() {
        return new ClientPoliciesResource(getTarget(),path+"/client");
    }

    @Path("group")
    public GroupPoliciesResource group() {
        return new GroupPoliciesResource(getTarget(),path+"/group");
    }
}
