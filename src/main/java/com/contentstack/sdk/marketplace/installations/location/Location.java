package com.contentstack.sdk.marketplace.installations.location;

import com.contentstack.sdk.BaseImplementation;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.util.HashMap;
import java.util.Objects;

/**
 * The type Location.
 */
public class Location implements BaseImplementation<Location> {

    private final String installationId;
    /**
     * The Headers.
     */
    protected HashMap<String, String> headers;
    private final LocationService service;
    /**
     * The Params.
     */
    protected HashMap<String, Object> params;

    /**
     * Constructs a new {@link Location} object with the specified parameters.
     *
     * @param client          a {@link Retrofit} object representing the client used to create the {@link LocationService} object
     * @param organizationUid a non-null {@link String} representing the organization UID
     * @param installationId  a non-null {@link String} representing the installation ID
     * @throws NullPointerException if any of the arguments are null
     *
     *                              <p>
     *                              <b>Example</b>
     *                              <p>
     *                              <code>
     *                              Marketplace marketplace = new Marketplace.Builder("organizationId")
     *                              .host("api.contentstack.io").build();
     *                              Location location = marketplace.installation().location();
     *                              </code>
     */
    public Location(Retrofit client, @NotNull String organizationUid, @NotNull String installationId) {
        this.headers = new HashMap<>();
        this.params = new HashMap<>();
        this.installationId = installationId;
        this.headers.put("organization_uid", organizationUid);
        this.service = client.create(LocationService.class);
    }

    /**
     * Fetch configuration location call.
     *
     * @return the call
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("organizationId")
     * .host("api.contentstack.io").build();
     * Location location = marketplace.installation().location();
     * Call result = location.fetchConfigurationLocation().execute();
     * </code>
     */
    Call<ResponseBody> fetchConfigurationLocation() {
        Objects.requireNonNull(this.installationId, "Installation Id is required");
        return this.service.getConfigurationLocation(this.headers, this.installationId, this.params);
    }

    /**
     * Adds a header with the specified key and value to this location and returns
     * the updated location.
     *
     * @param key   the key of the header to be added
     * @param value the value of the header to be added
     * @return a new {@link Location} object with the specified header added
     * @throws NullPointerException if the key or value argument is null
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("organizationId")
     * .host("api.contentstack.io").build();
     * Location location = marketplace.installation().location();
     * Location result = location.addParam("key", "value")
     * </code>
     */
    @Override
    public Location addParam(@NotNull String key, @NotNull Object value) {
        this.params.put(key, value);
        return this;
    }

    /**
     * Adds a header with the specified key and value to this location and returns
     * the updated location.
     *
     * @param key   the key of the header to be added
     * @param value the value of the header to be added
     * @return a new {@link Location} object with the specified header added
     * @throws NullPointerException if the key or value argument is null
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("organizationId")
     * .host("api.contentstack.io").build();
     * Location location = marketplace.installation().location();
     * Location result = location.addHeader("key", "value")
     * </code>
     */
    @Override
    public Location addHeader(@NotNull String key, @NotNull String value) {
        this.headers.put(key, value);
        return this;
    }

    /**
     * Adds the specified parameters to this location and returns the updated
     * location.
     *
     * @param params a {@link HashMap} containing the parameters to be added
     * @return a new {@link Location} object with the specified parameters added
     * @throws NullPointerException if the params argument is null
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("organizationId")
     * .host("api.contentstack.io").build();
     * Location location = marketplace.installation().location();
     * HashMap map = new HashMap();
     * Location result = location.addParams(map)
     * </code>
     */
    @Override
    public Location addParams(@NotNull HashMap<String, Object> params) {
        this.params.putAll(params);
        return this;
    }

    /**
     * Adds the specified parameters to this location and returns the updated
     * location.
     *
     * @param headers a {@link HashMap} containing the parameters to be added
     * @return a new {@link Location} object with the specified parameters added
     * @throws NullPointerException if the params argument is null
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("organizationId")
     * .host("api.contentstack.io").build();
     * Location location = marketplace.installation().location();
     * HashMap map = new HashMap();
     * Location result = location.addHeaders(map)
     * </code>
     */
    @Override
    public Location addHeaders(@NotNull HashMap<String, String> headers) {
        this.headers.putAll(headers);
        return this;
    }
}
