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
     */
// Network Call to create a resource using JSON data.
    Call<ResponseBody> create(JSONObject data) {
        return this.service.create(this.headers, data);
    }

    /**
     * Find call.
     *
     * @return the call
     */
// Network Call to list requests with headers and query parameters.
    Call<ResponseBody> find() {
        return this.service.listRequests(this.headers, this.params);
    }

    /**
     * Find requested stacks call.
     *
     * @return the call
     */
// Network Call to list requested stacks with headers and query parameters.
    Call<ResponseBody> findRequestedStacks() {
        return this.service.listRequestedStacks(this.headers, this.params);
    }

    /**
     * Delete call.
     *
     * @param requestId the request id
     * @return the call
     */
// Network Call to delete a specific request identified by requestId.
    Call<ResponseBody> delete(String requestId) {
        return this.service.deleteRequest(this.headers, requestId);
    }

    @Override
    public AppRequest addParam(@NotNull String key, @NotNull Object value) {
        this.params.put(key, value);
        return this;
    }

    @Override
    public AppRequest addHeader(@NotNull String key, @NotNull String value) {
        this.headers.put(key, value);
        return this;
    }

    @Override
    public AppRequest addHeaders(@NotNull HashMap<String, String> headers) {
        this.headers.putAll(headers);
        return this;
    }

    @Override
    public AppRequest addParams(@NotNull HashMap<String, Object> parameters) {
        this.params.putAll(parameters);
        return this;
    }
}

