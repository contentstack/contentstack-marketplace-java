package com.contentstack.sdk.marketplace.auths;

import com.contentstack.sdk.BaseImplementation;
import com.contentstack.sdk.marketplace.Constants;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.util.HashMap;
import java.util.Objects;

/**
 * The type Auth.
 */
public class Auth implements BaseImplementation<Auth> {
    private final AuthService service;
    /**
     * The Headers.
     */
    protected HashMap<String, String> headers;
    /**
     * The Params.
     */
    protected HashMap<String, Object> params;

    /**
     * Instantiates a new Auth.
     *
     * @param clientInstance  the client instance
     * @param organizationUid the organization uid
     */
    public Auth(Retrofit clientInstance, String authtoken, String organizationUid) {
        this.headers = new HashMap<>();
        this.params = new HashMap<>();
        Objects.requireNonNull(organizationUid, "Organization uid could not be empty");
        this.headers.put(Constants.ORGANIZATION_UID, organizationUid);
        if (authtoken != null) {
            this.headers.put(Constants.AUTHTOKEN, authtoken);
        }
        this.service = clientInstance.create(AuthService.class);
    }

    /**
     * The function returns a call to find authorized apps using the provided
     * headers and parameters.
     *
     * @return The method is returning a Call object with a ResponseBody type.
     */
    public Call<ResponseBody> findAuthorizedApp() {
        return this.service.findAuthorizedApps(this.headers, this.params);
    }

    /**
     * Adds a header with the specified key and value to this location and returns
     * the updated location.
     *
     * @param key   the key of the header to be added
     * @param value the value of the header to be added
     * @return a new {@link Auth} object with the specified header added
     * @throws NullPointerException if the key or value argument is null
     *
     *                              <p>
     *                              <b>Example</b>
     *                              <p>
     *                              <code>
     *                              Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     *                              .host("api.contentstack.io").build();
     *                              Auth authorizations = marketplace.authorizations();
     *                              authorizations.addParam("param1", "value1");
     *                              </code>
     */
    public Auth addParam(@NotNull String key, @NotNull Object value) {
        this.params.put(key, value);
        return this;
    }

    /**
     * Adds a header with the specified key and value to this location and returns
     * the updated location.
     *
     * @param key   the key of the header to be added
     * @param value the value of the header to be added
     * @return a new {@link Auth} object with the specified header added
     * @throws NullPointerException if the key or value argument is null
     *                              <p>
     *                              <b>Example</b>
     *                              <p>
     *                              <code>
     *                              Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     *                              .host("api.contentstack.io").build();
     *                              Auth authorizations = marketplace.authorizations();
     *                              authorizations.addHeader("key", "value");
     *                              </code>
     */
    public Auth addHeader(@NotNull String key, @NotNull String value) {
        this.headers.put(key, value);
        return this;
    }

    /**
     * Adds the specified parameters to this location and returns the updated
     * location.
     *
     * @param params a {@link HashMap} containing the parameters to be added
     * @return a new {@link Auth} object with the specified parameters added
     * @throws NullPointerException if the params argument is null
     *                              <p>
     *                              <b>Example</b>
     *                              <p>
     *                              <code>
     *                              Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     *                              .host("api.contentstack.io").build();
     *                              Auth authorizations = marketplace.authorizations();
     *                              HashMap params = new HashMap();
     *                              authorizations.addParam(params);
     *                              </code>
     */
    public Auth addParams(@NotNull HashMap<String, Object> params) {
        this.params.putAll(params);
        return this;
    }

    /**
     * Adds the specified parameters to this location and returns the updated
     * location.
     *
     * @param headers a {@link HashMap} containing the parameters to be added
     * @return a new {@link Auth} object with the specified parameters added
     * @throws NullPointerException if the params argument is null
     *
     *                              <p>
     *                              <b>Example</b>
     *                              <p>
     *                              <code>
     *                              Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     *                              .host("api.contentstack.io").build();
     *                              Auth authorizations = marketplace.authorizations();
     *                              HashMap params = new HashMap();
     *                              authorizations.addHeaders(params);
     *                              </code>
     */
    public Auth addHeaders(@NotNull HashMap<String, String> headers) {
        this.headers.putAll(headers);
        return this;
    }
}
