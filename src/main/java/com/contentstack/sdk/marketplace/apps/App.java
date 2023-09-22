package com.contentstack.sdk.marketplace.apps;

import com.contentstack.sdk.BaseImplementation;
import com.contentstack.sdk.marketplace.Constants;
import com.contentstack.sdk.marketplace.apps.hosting.Hosting;
import com.contentstack.sdk.marketplace.apps.oauth.Oauth;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONObject;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.util.HashMap;
import java.util.Objects;

import static com.contentstack.sdk.marketplace.Constants.ERROR_NO_ORGANIZATION_UID;


/**
 * App/Manifest is used for creating/updating/deleting app in your Contentstack
 * organization.
 *
 * @author ishaileshmishra
 * @version v1.0.0
 * @since 2023 -APR-15
 */
public class App implements BaseImplementation<App> {

    private final AppService service;
    protected HashMap<String, String> headers;
    protected HashMap<String, Object> params;
    private String appUid;
    private final Retrofit client;

    /**
     * Instantiates a new Organization.
     *
     * @param client          The retrofit client
     * @param organizationUid the organization uid
     *                        <p>
     *                        <b>Example</b>
     *                        <p>
     *                        <code>
     *                        Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     *                        .host("api.contentstack.io").build();
     *                        App app = marketplace.app("installationId");
     *                        (or)
     *                        App app = marketplace.app();
     *                        </code>
     */
    public App(Retrofit client, String authtoken, @NotNull String organizationUid) {
        this.client = client;
        this.headers = new HashMap<>();
        this.params = new HashMap<>();
        Objects.requireNonNull(organizationUid, Constants.ERROR_NO_ORGANIZATION_UID);
        this.headers.put(Constants.ORGANIZATION_UID, organizationUid);
        if (authtoken != null) {
            this.headers.put(Constants.AUTHTOKEN, authtoken);
        }
        this.service = client.create(AppService.class);
    }

    /**
     * Instantiates a new App/Manifest.
     *
     * @param client          The retrofit client
     * @param organizationUid The uid of the organization
     * @param uid             The app uid
     *                        <p>
     *                        <b>Example</b>
     *                        <p>
     *                        <code>
     *                        Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     *                        .host("api.contentstack.io").build();
     *                        App app = marketplace.app("installationId");
     *                        (or)
     *                        App app = marketplace.app();
     *                        </code>
     */
    public App(Retrofit client, String authtoken, @NotNull String organizationUid, @NotNull String uid) {
        this.client = client;
        this.headers = new HashMap<>();
        this.params = new HashMap<>();
        Objects.requireNonNull(organizationUid, ERROR_NO_ORGANIZATION_UID);
        this.headers.put(Constants.ORGANIZATION_UID, organizationUid);
        if (authtoken != null) {
            this.headers.put(Constants.AUTHTOKEN, authtoken);
        }
        Objects.requireNonNull(uid, "Manifest uid is required");
        this.appUid = uid;
        this.service = client.create(AppService.class);
    }

    /**
     * Adds a header with the specified key and value to this location and returns
     * the updated location.
     *
     * @param key   the key of the header to be added
     * @param value the value of the header to be added
     * @return a new {@link App} object with the specified header added
     * @throws NullPointerException if the key or value argument is null
     *                              <p>
     *                              <b>Example</b>
     *                              <p>
     *                              <code>
     *                              Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     *                              .host("api.contentstack.io").build();
     *                              App app = marketplace.app().addParam("key","value");
     *                              </code>
     */
    @Override
    public App addParam(@NotNull String key, @NotNull Object value) {
        this.params.put(key, value);
        return this;
    }

    /**
     * Adds a header with the specified key and value to this location and returns
     * the updated location.
     *
     * @param key   the key of the header to be added
     * @param value the value of the header to be added
     * @return a new {@link App} object with the specified header added
     * @throws NullPointerException if the key or value argument is null
     *                              <p>
     *                              <b>Example</b>
     *                              <p>
     *                              <code>
     *                              Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     *                              .host("api.contentstack.io").build();
     *                              App app = marketplace.app().addHeader("key","value");
     *                              </code>
     */
    @Override
    public App addHeader(@NotNull String key, @NotNull String value) {
        this.headers.put(key, value);
        return this;
    }

    /**
     * Adds the specified parameters to this location and returns the updated
     * location.
     *
     * @param params a {@link HashMap} containing the parameters to be added
     * @return a new {@link App} object with the specified parameters added
     * @throws NullPointerException if the params argument is null
     *                              <p>
     *                              <b>Example</b>
     *                              <p>
     *                              <code>
     *                              Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     *                              .host("api.contentstack.io").build();
     *                              HashMap param = new HashMap();
     *                              App app = marketplace.app().addParams(param);
     *                              </code>
     */
    @Override
    public App addParams(@NotNull HashMap<String, Object> params) {
        this.params.putAll(params);
        return this;
    }

    /**
     * Adds the specified parameters to this location and returns the updated
     * location.
     *
     * @param headers a {@link HashMap} containing the parameters to be added
     * @return a new {@link App} object with the specified parameters added
     * @throws NullPointerException if the params argument is null
     *                              <p>
     *                              <b>Example</b>
     *                              <p>
     *                              <code>
     *                              Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     *                              .host("api.contentstack.io").build();
     *                              HashMap param = new HashMap();
     *                              App app = marketplace.app().addHeaders(param);
     *                              </code>
     */
    @Override
    public App addHeaders(@NotNull HashMap<String, String> headers) {
        this.headers.putAll(headers);
        return this;
    }

    /**
     * Create installation call.
     *
     * @param body the body
     * @return the call
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * {@link JSONObject} body = new {@link JSONObject}();
     * App app = marketplace.app().createInstallation(body);
     * Call response = app.execute()
     * </code>
     */
    public Call<ResponseBody> createInstallation(@NotNull JSONObject body) {
        return this.service.createInstallation(this.headers, this.appUid, body, this.params);
    }

    /**
     * Update version call.
     *
     * @param body the body
     * @return the call
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * {@link JSONObject} body = new {@link JSONObject}();
     * App app = marketplace.app().updateVersion(body);
     * Call response = app.execute()
     * </code>
     */
    public Call<ResponseBody> updateVersion(@NotNull JSONObject body) {
        return this.service.updateVersion(this.headers, this.appUid, body, this.params);
    }

    /**
     * Find app authorizations call.
     *
     * @return the call
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * App app = marketplace.app().findAppAuthorizations();
     * Call response = app.execute()
     * </code>
     */
    public Call<ResponseBody> findAppAuthorizations() {
        return service.findAppAuthorizations(this.headers, this.appUid, this.params);
    }

    /**
     * Delete authorization call.
     *
     * @param authorizationUid the authorization uid
     * @return the call
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * App app = marketplace.app().deleteAuthorization("authorizationUid");
     * Call response = app.execute()
     * </code>
     */
    public Call<ResponseBody> deleteAuthorization(@NotNull String authorizationUid) {
        return service.deleteAuthorization(this.headers, this.appUid, authorizationUid);
    }

    /**
     * Find app installations call.
     *
     * @return the call
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * App app = marketplace.app().findAppInstallations();
     * Call response = app.execute()
     * </code>
     */
    public Call<ResponseBody> findAppInstallations() {
        return service.listAppInstallations(this.headers, this.appUid, this.params);
    }

    /**
     * Find apps call.
     *
     * @return the call
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * App app = marketplace.app().findApps();
     * Call response = app.execute()
     * </code>
     */
    public Call<ResponseBody> findApps() {
        return service.listApps(this.headers, this.params);
    }

    /**
     * Create app call.
     *
     * @param body the body
     * @return the call
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * {@link JSONObject} body = new {@link JSONObject}();
     * App app = marketplace.app().createApp(body);
     * Call response = app.execute()
     * </code>
     */
    public Call<ResponseBody> createApp(@NotNull JSONObject body) {
        return service.createApp(this.headers, this.params, body);
    }

    /**
     * Fetch app call.
     *
     * @return the call
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * App app = marketplace.app().fetchApp();
     * Call response = app.execute()
     * </code>
     */
    public Call<ResponseBody> fetchApp() {
        return service.fetchApp(this.headers, this.appUid, this.params);
    }

    /**
     * Update app call.
     *
     * @param body the body
     * @return the call
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * {@link JSONObject} body = new {@link JSONObject}();
     * App app = marketplace.app().updateApp();
     * Call response = app.execute()
     * </code>
     */
    public Call<ResponseBody> updateApp(@NotNull JSONObject body) {
        return service.updateApp(this.headers, this.appUid, body);
    }

    /**
     * Delete app call.
     *
     * @return the call
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * {@link JSONObject} body = new {@link JSONObject}();
     * App app = marketplace.app().deleteApp();
     * Call response = app.execute()
     * </code>
     */
    public Call<ResponseBody> deleteApp() {
        return service.delete(this.headers, this.appUid);
    }

    /**
     * The function returns a call to list app requests with specified headers, app
     * UID, and parameters.
     *
     * @return The method is returning a Call object with a generic type of ResponseBody.
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * App app = marketplace.app().findAppRequests();
     * Call response = app.execute()
     * </code>
     */
    public Call<ResponseBody> findAppRequests() {
        return service.listAppRequests(this.headers, this.appUid, this.params);
    }

    /**
     * Returns Instance of oauth
     *
     * @return the oauth
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * Oauth oauth = marketplace.app().oauth();
     * </code>
     */
    public Oauth oauth() {
        String orgId = this.headers.get(Constants.ORGANIZATION_UID);
        return new Oauth(this.client, orgId);
    }

    /**
     * Returns Instance of oauth
     *
     * @param id the app uid
     * @return the oauth
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * Oauth oauth = marketplace.app().oauth("id");
     * </code>
     */
    public Oauth oauth(@NotNull String id) {
        String orgId = this.headers.get(Constants.ORGANIZATION_UID);
        return new Oauth(this.client, orgId, id);
    }

    /**
     * Hosting hosting.
     *
     * @return the instance of hosting
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * Hosting hosting = marketplace.app().hosting();
     * </code>
     */
    public Hosting hosting() {
        String orgId = this.headers.get(Constants.ORGANIZATION_UID);
        return new Hosting(this.client, orgId, this.appUid);
    }

    /**
     * Hosting hosting.
     *
     * @param appId the app id
     * @return the instance of hosting
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * {@link Hosting} hosting = marketplace.app().hosting("appId");
     * </code>
     */
    public Hosting hosting(@NotNull String appId) {
        String orgId = this.headers.get(Constants.ORGANIZATION_UID);
        return new Hosting(this.client, orgId, appId);
    }

}
