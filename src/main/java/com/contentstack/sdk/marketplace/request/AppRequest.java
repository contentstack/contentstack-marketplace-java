package com.contentstack.sdk.marketplace.request;

import com.contentstack.sdk.BaseImplementation;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONObject;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.util.HashMap;
import java.util.Map;

/**
 * The type App request.
 */
public class AppRequest implements BaseImplementation<AppRequest> {

    private final RequestService service;
    private final Map<String, String> headers;
    private final Map<String, Object> params;

    /**
     * Instantiates a new App request.
     *
     * @param client the client
     * @param orgId  the org id
     */
    public AppRequest(@NotNull Retrofit client, @NotNull String orgId) {
        this.service = client.create(RequestService.class);
        this.headers = new HashMap<>();
        this.headers.put("organization_uid", orgId);
        this.params = new HashMap<>();
    }

    /**
     * Create call.
     *
     * @param data the data
     * @return the call
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * AppRequest appRequest = marketplace.request();
     * JSONObject body = new JSONObject();
     * Call result = appRequest.create(body).execute();
     * </code>
     */
    Call<ResponseBody> create(JSONObject data) {
        return this.service.create(this.headers, data);
    }

    /**
     * Find call.
     *
     * @return the call
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * AppRequest appRequest = marketplace.request();
     * Call result = appRequest.find().execute();
     * </code>
     */
    Call<ResponseBody> find() {
        return this.service.listRequests(this.headers, this.params);
    }

    /**
     * Find requested stacks call.
     *
     * @return the call
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * AppRequest appRequest = marketplace.request();
     * Call result = appRequest.findRequestedStack().execute();
     * </code>
     */
    Call<ResponseBody> findRequestedStacks() {
        return this.service.listRequestedStacks(this.headers, this.params);
    }

    /**
     * Delete call.
     *
     * @param requestId the request id
     * @return the call
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * AppRequest appRequest = marketplace.request();
     * JSONObject body = new JSONObject();
     * Call result = appRequest.delete("requestId").execute();
     * </code>
     */
    Call<ResponseBody> delete(String requestId) {
        return this.service.deleteRequest(this.headers, requestId);
    }

    /**
     * @param key   A non-null String representing the key for the parameter.
     * @param value The value parameter is of type Object, which means it can accept              any type of object              as its value.
     * @return instance of AppRequest
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * AppRequest appRequest = marketplace.request();
     * appRequest.addParam("key", "value");
     * </code>
     */
    @Override
    public AppRequest addParam(@NotNull String key, @NotNull Object value) {
        this.params.put(key, value);
        return this;
    }

    /**
     * @param key   A non-null String representing the header key.
     * @param value The value parameter is a string that represents the value of the              header.
     * @return instance of AppRequest
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * AppRequest appRequest = marketplace.request();
     * appRequest.addHeader("key", "value");
     * </code>
     */
    @Override
    public AppRequest addHeader(@NotNull String key, @NotNull String value) {
        this.headers.put(key, value);
        return this;
    }

    /**
     * @param headers A HashMap object that contains key-value pairs representing                the headers to be                added. The keys represent the header names, and the values                represent the header values.
     * @return instance of AppRequest
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * AppRequest appRequest = marketplace.request();
     * HashMap headers = new HashMap()
     * appRequest.addHeaders(headers);
     * </code>
     */
    @Override
    public AppRequest addHeaders(@NotNull HashMap<String, String> headers) {
        this.headers.putAll(headers);
        return this;
    }

    /**
     * @param parameters A HashMap object that stores key-value pairs, where the key                   is of type String                   and the value is of type Object. The HashMap is annotated                   with @NotNull, indicating that it                   cannot be null.
     * @return instance of AppRequest
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * AppRequest appRequest = marketplace.request();
     * HashMap headers = new HashMap()
     * appRequest.addParams(headers);
     * </code>
     */
    @Override
    public AppRequest addParams(@NotNull HashMap<String, Object> parameters) {
        this.params.putAll(parameters);
        return this;
    }
}

