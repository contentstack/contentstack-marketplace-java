package com.contentstack.sdk.marketplace.apps.oauth;

import com.contentstack.sdk.BaseImplementation;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONObject;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.util.HashMap;
import java.util.Objects;

/**
 * The type Oauth.
 */
public class Oauth implements BaseImplementation<Oauth> {

    private final OauthService service;
    /**
     * The Headers.
     */
    protected HashMap<String, String> headers;
    /**
     * The Params.
     */
    protected HashMap<String, Object> params;
    /**
     * The App id.
     */
    protected String appId;

    /**
     * Instantiates a new Oauth.
     *
     * @param client         the client
     * @param organizationId the organization id
     *                       <p>
     *                       <b>Example</b>
     *                       <p>
     *                       <code>
     *                       Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     *                       .host("api.contentstack.io").build();
     *                       Oauth oauth = marketplace.app().oauth();
     *                       </code>
     */
    public Oauth(Retrofit client, String organizationId) {
        this.headers = new HashMap<>();
        this.params = new HashMap<>();
        this.headers.put("organization_uid", organizationId);
        this.service = client.create(OauthService.class);
    }

    /**
     * Instantiates a new Oauth.
     *
     * @param client         the client
     * @param organizationId the organization id
     * @param appId          the app id
     *                       <p>
     *                       <b>Example</b>
     *                       <p>
     *                       <code>
     *                       Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     *                       .host("api.contentstack.io").build();
     *                       Oauth oauth = marketplace.app().oauth();
     *                       </code>
     */


    public Oauth(Retrofit client, String organizationId, @NotNull String appId) {
        this.headers = new HashMap<>();
        this.params = new HashMap<>();
        Objects.requireNonNull(appId, "App Id is required");
        this.appId = appId;
        Objects.requireNonNull(organizationId, "Organization uid could not be empty");
        this.headers.put("organization_uid", organizationId);
        this.service = client.create(OauthService.class);
    }

    /**
     * The function fetches the OAuth configuration for a given app ID.
     *
     * @param appId The `appId` parameter is a string that represents the unique identifier of an application.
     * @return The method is returning a Call object with a generic type of ResponseBody.
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * Oauth oauth = marketplace.app().oauth();
     * Response response = oauth.addHeader("key", "value")
     * .fetchOauthConfiguration("appId").execute();
     * </code>
     */
    public Call<ResponseBody> fetchOauthConfiguration(@NotNull String appId) {
        return service.getOauthConfiguration(this.headers, appId);
    }

    /**
     * The function `updateOauthConfiguration` sends a request to update the OAuth
     * configuration with the
     * given JSON body.
     *
     * @param body A JSONObject containing the updated OAuth configuration data.
     * @return The method is returning a Call object with a ResponseBody type.
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * Oauth oauth = marketplace.app().oauth();
     * JSONObject oauthBody = new JSONObject()
     * Response<ResponseBody> response = oauth.addHeader("key", "value")
     * .updateOauthConfiguration(oauthBody).execute();
     * </code>
     */
    Call<ResponseBody> updateOauthConfiguration(JSONObject body) {
        return service.updateOauthConfiguration(this.headers, this.appId, body);
    }

    /**
     * The function `findScopes()` returns a `Call` object that makes a network
     * request to find scopes
     * using the provided headers.
     *
     * @return The method is returning a Call object with a generic type of ResponseBody.
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * Oauth oauth = marketplace.app().oauth();
     * Response<ResponseBody> response = oauth.findScopes().execute();
     * </code>
     */
    Call<ResponseBody> findScopes() {
        return service.findScopes(this.headers);
    }

    /**
     * Adds a header with the specified key and value to this location and returns
     * the updated location.
     *
     * @param key   the key of the header to be added
     * @param value the value of the header to be added
     * @return a new {@link Oauth} object with the specified header added
     * @throws NullPointerException if the key or value argument is null
     *                              <p>
     *                              <b>Example</b>
     *                              <p>
     *                              <code>
     *                              Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     *                              .host("api.contentstack.io").build();
     *                              Oauth oauth = marketplace.app().oauth();
     *                              JSONObject oauthBody = new JSONObject()
     *                              oauth.addParam("key", "value");
     *                              </code>
     */
    @Override
    public Oauth addParam(@NotNull String key, @NotNull Object value) {
        this.params.put(key, value);
        return this;
    }

    /**
     * Adds a header with the specified key and value to this location and returns
     * the updated location.
     *
     * @param key   the key of the header to be added
     * @param value the value of the header to be added
     * @return a new {@link Oauth} object with the specified header added
     * @throws NullPointerException if the key or value argument is null
     *                              <p>
     *                              <b>Example</b>
     *                              <p>
     *                              <code>
     *                              Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     *                              .host("api.contentstack.io").build();
     *                              Oauth oauth = marketplace.app().oauth();
     *                              {@link Oauth} oauth.addHeader("key", "value")
     *                              </code>
     */
    @Override
    public Oauth addHeader(@NotNull String key, @NotNull String value) {
        this.headers.put(key, value);
        return this;
    }

    /**
     * Adds the specified parameters to this location and returns the updated
     * location.
     *
     * @param params a {@link HashMap} containing the parameters to be added
     * @return a new {@link Oauth} object with the specified parameters added
     * @throws NullPointerException if the params argument is null
     *                              <p>
     *                              <b>Example</b>
     *                              <p>
     *                              <code>
     *                              Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     *                              .host("api.contentstack.io").build();
     *                              Oauth oauth = marketplace.app().oauth();
     *                              HashMap param = new HashMap();
     *                              Oauth oauth = oauth.addParams(param);
     *                              </code>
     */
    @Override
    public Oauth addParams(@NotNull HashMap<String, Object> params) {
        this.params.putAll(params);
        return this;
    }

    /**
     * Adds the specified parameters to this location and returns the updated
     * location.
     *
     * @param headers a {@link HashMap} containing the parameters to be added
     * @return a new {@link Oauth} object with the specified parameters added
     * @throws NullPointerException if the params argument is null
     *                              <p>
     *                              <b>Example</b>
     *                              <p>
     *                              <code>
     *                              Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     *                              .host("api.contentstack.io").build();
     *                              Oauth oauth = marketplace.app().oauth();
     *                              HashMap param = new HashMap();
     *                              Oauth oauth = oauth.addHeaders(param)
     *                              </code>
     */
    @Override
    public Oauth addHeaders(@NotNull HashMap<String, String> headers) {
        this.headers.putAll(headers);
        return this;
    }

}
