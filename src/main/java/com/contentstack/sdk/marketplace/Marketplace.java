package com.contentstack.sdk.marketplace;

import com.contentstack.sdk.Client;
import com.contentstack.sdk.marketplace.apps.App;
import com.contentstack.sdk.marketplace.auths.Auth;
import com.contentstack.sdk.marketplace.installations.Installation;
import com.contentstack.sdk.marketplace.request.AppRequest;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;


public class Marketplace {

    private final Retrofit client;
    protected final String orgId;
    private final String DEFAULT_HOST = "api.contentstack.io";

    // The `Marketplace` constructor is initializing a new instance of the
    // `Marketplace` class. It takes
    // three parameters: `Retrofit client`, `String orgId`, and `String baseUrl`.
    public Marketplace(@NotNull String organizationUid, @NotNull String host) {
        if (organizationUid.isEmpty()) {
            throw new NullPointerException("The organization_uid is required");
        }
        host = (host.isEmpty()) ? DEFAULT_HOST : host;
        this.orgId = organizationUid;
        this.client = Client.getInstance(host);
    }

    public Marketplace(@NotNull String organizationUid) {
        if (organizationUid.isEmpty()) {
            throw new NullPointerException("The organization_uid is required");
        }
        this.orgId = organizationUid;
        this.client = Client.getInstance(DEFAULT_HOST);
    }

    /**
     * The function returns a new instance of the App class with the specified
     * client and orgId.
     *
     * @return An instance of the App class is being returned.
     */
    public App app() {
        return new App(this.client, this.orgId);
    }

    /**
     * The function creates and returns a new instance of the App class with the
     * given parameters.
     *
     * @param uid The uid parameter is a String that represents a unique identifier
     *            for the app.
     * @return An instance of the App class is being returned.
     */
    public App app(@NotNull String uid) {
        return new App(this.client, this.orgId, uid);
    }

    /**
     * The function returns a new instance of the Auth class with the given client
     * and orgId.
     *
     * @return An instance of the Auth class is being returned.
     */
    public Auth authorizations() {
        return new Auth(this.client, this.orgId);
    }

    /**
     * The function returns a new instance of the Installation class with the
     * specified client and orgId.
     *
     * @return An instance of the Installation class.
     */
    public Installation installation() {
        return new Installation(this.client, this.orgId);
    }

    /**
     * The function returns a new Installation object with the specified
     * installation ID.
     *
     * @param installationId The installationId parameter is a unique identifier for
     *                       an installation. It is
     *                       used to create a new Installation object with the
     *                       specified installationId.
     * @return An instance of the Installation class.
     */
    public Installation installation(String installationId) {
        return new Installation(this.client, this.orgId, installationId);
    }

    /**
     * The function returns a new instance of the AppRequest class with the
     * specified client and orgId.
     *
     * @return An instance of the AppRequest class.
     */
    public AppRequest request() {
        return new AppRequest(this.client, this.orgId);
    }

}
