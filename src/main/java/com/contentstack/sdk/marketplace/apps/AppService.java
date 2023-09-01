package com.contentstack.sdk.marketplace.apps;

import okhttp3.ResponseBody;
import org.json.simple.JSONObject;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

/**
 * The interface App service.
 */
public interface AppService {

    /**
     * Create installation call.
     *
     * @param headers the headers
     * @param uid     the uid
     * @param body    the body
     * @param param   the param
     * @return the call
     */
    @POST("manifests/{uid}/install")
    Call<ResponseBody> createInstallation(
            @HeaderMap Map<String, String> headers,
            @Path("uid") String uid,
            @Body JSONObject body,
            @QueryMap Map<String, Object> param);

    /**
     * Update version call.
     *
     * @param headers     the headers
     * @param id          the id
     * @param body        the body
     * @param queryParams the query params
     * @return the call
     */
    @PUT("manifests/{id}/reinstall")
    Call<ResponseBody> updateVersion(
            @HeaderMap Map<String, String> headers,
            @Path("id") String id,
            @Body JSONObject body,
            @QueryMap Map<String, Object> queryParams);

    /**
     * Find app authorizations call.
     *
     * @param headers     the headers
     * @param uid         the uid
     * @param queryParams the query params
     * @return the call
     */
    @GET("manifests/{uid}/authorizations")
    Call<ResponseBody> findAppAuthorizations(
            @HeaderMap Map<String, String> headers,
            @Path("uid") String uid, @QueryMap Map<String, Object> queryParams);

    /**
     * Delete authorization call.
     *
     * @param headers the headers
     * @param uid     the uid
     * @param orgId   the org id
     * @return the call
     */
    @DELETE("manifests/{uid}/authorizations/{uid}")
    Call<ResponseBody> deleteAuthorization(
            @HeaderMap Map<String, String> headers,
            @Path("uid") String uid,
            @Path("uid") String orgId);

    /**
     * List app installations call.
     *
     * @param headers         the headers
     * @param uid             the uid
     * @param queryParameters the query parameters
     * @return the call
     */
    @GET("manifests/{uid}/installations")
    Call<ResponseBody> listAppInstallations(
            @HeaderMap Map<String, String> headers,
            @Path("uid") String uid,
            @QueryMap Map<String, Object> queryParameters);

    /**
     * List apps call.
     *
     * @param headers         the headers
     * @param queryParameters the query parameters
     * @return the call
     */
    @GET("manifests")
    Call<ResponseBody> listApps(
            @HeaderMap Map<String, String> headers,
            @QueryMap Map<String, Object> queryParameters);

    /**
     * Create app call.
     *
     * @param headers         the headers
     * @param queryParameters the query parameters
     * @param body            the body
     * @return the call
     */
    @POST("manifests")
    Call<ResponseBody> createApp(
            @HeaderMap Map<String, String> headers,
            @QueryMap Map<String, Object> queryParameters,
            @Body JSONObject body);

    /**
     * Fetch app call.
     *
     * @param headers         the headers
     * @param uid             the uid
     * @param queryParameters the query parameters
     * @return the call
     */
    @GET("manifests/{uid}")
    Call<ResponseBody> fetchApp(
            @HeaderMap Map<String, String> headers,
            @Path("uid") String uid,
            @QueryMap Map<String, Object> queryParameters);

    /**
     * Update app call.
     *
     * @param headers the headers
     * @param uid     the uid
     * @param body    the body
     * @return the call
     */
    @PUT("manifests/{uid}")
    Call<ResponseBody> updateApp(
            @HeaderMap Map<String, String> headers,
            @Path("uid") String uid,
            @Body JSONObject body);

    /**
     * Delete call.
     *
     * @param headers the headers
     * @param uid     the uid
     * @return the call
     */
    @DELETE("manifests/{uid}")
    Call<ResponseBody> delete(
            @HeaderMap Map<String, String> headers,
            @Path("uid") String uid);

    /**
     * List app requests call.
     *
     * @param headers the headers
     * @param uid     the uid
     * @param params  the params
     * @return the call
     */
    @GET("manifests/{uid}/requests")
    Call<ResponseBody> listAppRequests(
            @HeaderMap Map<String, String> headers,
            @Path("uid") String uid, @QueryMap Map<String, Object> params);

}
