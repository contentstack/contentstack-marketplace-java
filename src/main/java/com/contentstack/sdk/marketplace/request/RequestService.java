package com.contentstack.sdk.marketplace.request;

import okhttp3.ResponseBody;
import org.json.simple.JSONObject;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

/**
 * The interface Request service.
 */
public interface RequestService {

    /**
     * Create call.
     *
     * @param headers the headers
     * @param body    the body
     * @return the call
     */
    @POST("requests")
    Call<ResponseBody> create(
            @HeaderMap Map<String, String> headers,
            @Body JSONObject body);

    /**
     * List requests call.
     *
     * @param headers    the headers
     * @param parameters the parameters
     * @return the call
     */
    @GET("requests")
    Call<ResponseBody> listRequests(
            @HeaderMap Map<String, String> headers,
            @QueryMap Map<String, Object> parameters);

    /**
     * List requested stacks call.
     *
     * @param headers    the headers
     * @param parameters the parameters
     * @return the call
     */
    @GET("requests/view/stacks")
    Call<ResponseBody> listRequestedStacks(
            @HeaderMap Map<String, String> headers,
            @QueryMap Map<String, Object> parameters);

    /**
     * Delete request call.
     *
     * @param headers the headers
     * @param uid     the uid
     * @return the call
     */
    @DELETE("requests/{uid}")
    Call<ResponseBody> deleteRequest(
            @HeaderMap Map<String, String> headers,
            @Path("uid") String uid);
}
