/*
 * Copyright 2016 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.keycloak.admin.client.resource;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.multipart.FormDataMultiPart;
import org.keycloak.admin.client.AbstractResource;
import org.keycloak.representations.KeyStoreConfig;
import org.keycloak.representations.idm.CertificateRepresentation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * The type Client attribute certificate resource.
 *
 * Based on a fork of keycloak-amdin-client originally created by ssilvert@redhat.com.
 *
 * @author daniel-schel
 */
public class ClientAttributeCertificateResource extends AbstractResource {

    private String clientPath = "";

    /**
     * Instantiates a new Abstract resource.
     *
     * @param target the target
     */
    protected ClientAttributeCertificateResource(WebResource target) {
        super(target);
    }

    public ClientAttributeCertificateResource(WebResource target, String clientPath) {
        super(target);
        this.clientPath = clientPath;
    }

    /**
     * Get key info
     *
     * @return
     */
    @GET
        @Produces(MediaType.APPLICATION_JSON)
    public CertificateRepresentation getKeyInfo() {
        throw new UnsupportedOperationException();
    }

    /**
     * Generate a new certificate with new key pair
     *
     * @return
     */
    @POST
    // @NoCache
    @Path("generate")
    @Produces(MediaType.APPLICATION_JSON)
    public CertificateRepresentation generate() {
        throw new UnsupportedOperationException();
    }

    /**
     * Upload certificate and eventually private key
     *
     * @param output
     * @return
     */
    @POST
    @Path("upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public CertificateRepresentation uploadJks(Object output) {
        throw new UnsupportedOperationException();
    }

    /**
     * Upload only certificate, not private key
     *
     * @param output
     * @return
     */
    @POST
    @Path("upload-certificate")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public CertificateRepresentation uploadJksCertificate(Object output) {
        throw new UnsupportedOperationException();
    }

    /**
     * Get a keystore file for the client, containing private key and public certificate
     *
     * @param config Keystore configuration as JSON
     * @return
     */
    @POST
        @Path("/download")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Consumes(MediaType.APPLICATION_JSON)
    public byte[] getKeystore(final KeyStoreConfig config) {
        throw new UnsupportedOperationException();
    }

    /**
     * Generate a new keypair and certificate, and get the private key file
     *
     * Generates a keypair and certificate and serves the private key in a specified keystore format.
     * Only generated public certificate is saved in Keycloak DB - the private key is not.
     *
     * @param config Keystore configuration as JSON
     * @return
     */
    @POST
        @Path("/generate-and-download")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Consumes(MediaType.APPLICATION_JSON)
    public byte[] generateAndGetKeystore(final KeyStoreConfig config) {
        throw new UnsupportedOperationException();
    }
}
