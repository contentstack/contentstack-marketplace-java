package com.contentstack.sdk.marketplace;

import com.contentstack.sdk.Client;
import com.contentstack.sdk.ContentstackRegion;
import com.contentstack.sdk.marketplace.apps.App;
import com.contentstack.sdk.marketplace.auths.Auth;
import com.contentstack.sdk.marketplace.installations.Installation;
import com.contentstack.sdk.marketplace.request.AppRequest;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;

// The `Marketplace` class is a Java class that represents a marketplace. It provides
// methods for interacting with various components of the marketplace, such as apps,
// authorizations, installations, and app requests. It takes in parameters such as
// organization UID, host, and region to initialize an instance of the class. The class
// also has methods for creating instances of other classes related to the marketplace,
// such as `App`, `Auth`, `Installation`, and `AppRequest`.
public class Marketplace {

    // The line `private final Retrofit client;` is declaring a private final
    // variable `client` of type
    // `Retrofit`. This variable is used to store an instance of the `Retrofit`
    // class, which is a
    // type-safe HTTP client for making API requests. The `private` access modifier
    // ensures that the variable can only be accessed within the `Marketplace` class.
    // The `final` keyword ensures that
    // the value of `client` cannot be changed once it is assigned a value.
    private final Retrofit client;
    // The line `protected final String orgId;` is declaring a protected final
    // variable `orgId` of type
    // String. This variable is used to store the organization UID, which is a
    // unique identifier for
    // the organization in the marketplace. The `protected` access modifier allows
    // the variable to be
    // accessed by subclasses of the `Marketplace` class. The `final` keyword
    // ensures that the value of
    // `orgId` cannot be changed once it is assigned a value.
    protected final String orgId;
    // The line `private String DEFAULT_HOST = "developerhub-api.contentstack.com";`
    // is initializing a
    // private variable `DEFAULT_HOST` with the value
    // `"developerhub-api.contentstack.com"`. This variable
    // is used as the default host for the marketplace if no host is provided when
    // creating an instance of
    // the `Marketplace` class.
    private String DEFAULT_HOST = "developerhub-api.contentstack.com";


    /**
     * The `public Marketplace(@NotNull String organizationUid, @NotNull String
     * host,
     * ContentstackRegion region)` constructor is initializing an instance of the
     * Marketplace class.
     * It takes three parameters: `organizationUid`, `host`, and `region`.
     *
     * @param organizationUid the organization uid
     * @param host            the custom host
     * @param region          the region for the operation
     */
    public Marketplace(@NotNull String organizationUid, @NotNull String host, ContentstackRegion region) {
        if (organizationUid.isEmpty()) {
            throw new NullPointerException("The organization uid is required");
        }
        if (region != null) {
            if (region.name().equalsIgnoreCase("azure_eu")) {
                DEFAULT_HOST = "azure-eu-" + DEFAULT_HOST;
                host = "azure-eu-" + host;
            }
            if (region.name().equalsIgnoreCase("azure_na")) {
                DEFAULT_HOST = "azure-na-" + DEFAULT_HOST;
                host = "azure-na-" + host;
            }
        }
        host = (host.isEmpty()) ? DEFAULT_HOST : host;
        String endpoint = "https://" + host + "/";
        this.orgId = organizationUid;
        this.client = Client.getInstance(endpoint);
    }

    // The `Marketplace` constructor is initializing a new instance of the
    // Marketplace` class. It takes
    // three parameters: `Retrofit client`, `String orgId`, and `String baseUrl`.
    public Marketplace(@NotNull String organizationUid, @NotNull String host) {
        if (organizationUid.isEmpty()) {
            throw new NullPointerException("The organization_uid is required");
        }
        host = (host.isEmpty()) ? DEFAULT_HOST : host;
        this.orgId = organizationUid;
        this.client = Client.getInstance(host);
    }

    // The `public Marketplace(@NotNull String organizationUid)` constructor is
    // creating a new instance of
    // the `Marketplace` class. It takes one parameter, `organizationUid`, which is
    // a string representing
    // the unique identifier for the organization in the marketplace.
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
