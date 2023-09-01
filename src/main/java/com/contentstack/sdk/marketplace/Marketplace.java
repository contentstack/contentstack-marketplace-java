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
    protected final String orgId;
    private final String host;

    private static final String DEFAULT_HOST = "developerhub-api.contentstack.com";

    // Private constructor to enforce the Builder pattern
    private Marketplace(String organizationUid, String host, Region region) {
        this.orgId = organizationUid;
        if (region != null) {
            host = region.name().toLowerCase() + "-" + host;
        }
        this.host = host.isEmpty() ? DEFAULT_HOST : host;
        //String endpoint = "https://" + this.host;
        this.client = Client.getInstance(this.host);
    }

    // Builder pattern to construct Marketplace objects
    public static class Builder {
        private final String orgId;
        private String host;
        private Region region = null;

        public Builder(@NotNull String organizationUid) {
            if (organizationUid.isEmpty()) {
                throw new NullPointerException("The organization uid is required");
            }
            this.orgId = organizationUid;
        }

        public Builder host(String customHost) {
            this.host = customHost;
            return this;
        }

        public Builder region(Region stackRegion) {
            this.region = stackRegion;
            return this;
        }

        public Marketplace build() {
            return new Marketplace(this.orgId, this.host, this.region);
        }
    }


    public App app() {
        return new App(this.client, this.orgId);
    }

    public App app(@NotNull String uid) {
        return new App(this.client, this.orgId, uid);
    }

    public Auth authorizations() {
        return new Auth(this.client, this.orgId);
    }

    public Installation installation() {
        return new Installation(this.client, this.orgId);
    }

    public Installation installation(String installationId) {
        return new Installation(this.client, this.orgId, installationId);
    }

    public AppRequest request() {
        return new AppRequest(this.client, this.orgId);
    }
}
