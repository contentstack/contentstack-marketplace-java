package com.contentstack.sdk.marketplace.apps.oauth;

import okhttp3.ResponseBody;
import org.json.simple.JSONObject;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

/**
 * The interface Oauth service.
 */
public interface OauthService {

    /**
     * Gets oauth configuration.
     *
     * @param headers the headers
     * @param uid     the uid
     * @return the oauth configuration
     */
    @GET("manifests/{uid}/oauth")
    Call<ResponseBody> getOauthConfiguration(
            @HeaderMap Map<String, String> headers,
            @Path("uid") String uid);

    /**
     * Find scopes call.
     *
     * @param headers the headers
     * @return the call
     */
    @GET("manifests/oauth/scopes")
    Call<ResponseBody> findScopes(
            @HeaderMap Map<String, String> headers);

    /**
     * Update oauth configuration call.
     *
     * @param headers the headers
     * @param uid     the uid
     * @param body    the body
     * @return the call
     */
    @PUT("manifests/{uid}/oauth")
    Call<ResponseBody> updateOauthConfiguration(
            @HeaderMap Map<String, String> headers,
            @Path("uid") String uid,
            @Body JSONObject body);

}
