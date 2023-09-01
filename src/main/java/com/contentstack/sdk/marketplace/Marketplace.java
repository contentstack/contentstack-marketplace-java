package com.contentstack.sdk.marketplace;


import com.contentstack.sdk.Client;
import com.contentstack.sdk.Region;
import com.contentstack.sdk.marketplace.apps.App;
import com.contentstack.sdk.marketplace.auths.Auth;
import com.contentstack.sdk.marketplace.installations.Installation;
import com.contentstack.sdk.marketplace.request.AppRequest;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;


public class Marketplace {

    private final Retrofit client;
    /**
     * The organisation uid to perform operation on marketplace.
     */
    protected final String orgId;
    private final String host;

    private static final String DEFAULT_HOST = "developerhub-api.contentstack.com";

    private Marketplace(String organizationUid, String host, Region region) {
        this.orgId = organizationUid;
        if (region != null) {
            host = region.name().toLowerCase() + "-" + host;
        }
        this.host = host.isEmpty() ? DEFAULT_HOST : host;
        this.client = Client.getInstance(this.host);
    }

    /**
     * The type Builder.
     */
// Builder pattern to construct Marketplace objects
    public static class Builder {
        private final String orgId;
        private String host;
        private Region region = null;

        /**
         * Instantiates a new Builder.
         *
         * @param organizationUid The organization UID associated with your Contentstack organization
         *                        <p>
         *                        <b>Example</b>
         *                        <p>
         *                        <code>
         *                        Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID").build();
         *                        </code>
         */
        public Builder(@NotNull String organizationUid) {
            if (organizationUid.isEmpty()) {
                throw new NullPointerException("The organization uid is required");
            }
            this.orgId = organizationUid;
        }

        /**
         * Host builder.
         *
         * @param customHost the custom host
         * @return the builder
         * <p>
         * <b>Example</b>
         * <p>
         * <code>
         * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
         * .host("custom.contentstack.io").host("api.contentstack.com").build();
         * </code>
         */
        public Builder host(String customHost) {
            this.host = customHost;
            return this;
        }

        /**
         * Region builder.
         *
         * @param stackRegion the stack region
         * @return the builder
         * <p>
         * <b>Example</b>
         * <p>
         * <code>
         * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
         * .host("custom.contentstack.io").region(Region.EU).build();
         * </code>
         */
        public Builder region(Region stackRegion) {
            this.region = stackRegion;
            return this;
        }

        /**
         * Build marketplace.
         *
         * @return the marketplace
         * <p>
         * <b>Example</b>
         * <p>
         * <code>
         * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
         * .host("api.contentstack.io").build();
         * </code>
         */
        public Marketplace build() {
            return new Marketplace(this.orgId, this.host, this.region);
        }
    }


    /**
     * App app.
     *
     * @return the app instance
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io")
     * .build();
     * App app = marketplace.app();
     * </code>
     */
    public App app() {
        return new App(this.client, this.orgId);
    }

    /**
     * App app.
     *
     * @param uid the uid
     * @return the app instance
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * App app = marketplace.app("app_uid");
     * </code>
     */
    public App app(@NotNull String uid) {
        return new App(this.client, this.orgId, uid);
    }

    /**
     * Authorizations auth.
     *
     * @return the auth instance
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * Auth authorizations = marketplace.authorizations();
     * </code>
     */
    public Auth authorizations() {
        return new Auth(this.client, this.orgId);
    }

    /**
     * Installation installation.
     *
     * @return the installation instance
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * Auth authorizations = marketplace.installation();
     * </code>
     */
    public Installation installation() {
        return new Installation(this.client, this.orgId);
    }

    /**
     * Installation installation.
     *
     * @param installationId the installation id
     * @return the installation instance
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * Installation installation = marketplace.installation("installationId");
     * </code>
     */
    public Installation installation(String installationId) {
        return new Installation(this.client, this.orgId, installationId);
    }

    /**
     * Request app request.
     *
     * @return the app request instance
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * AppRequest request = marketplace.request();
     * </code>
     */
    public AppRequest request() {
        return new AppRequest(this.client, this.orgId);
    }
}
