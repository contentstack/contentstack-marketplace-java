package com.contentstack.sdk.marketplace.apps.hosting;

import okhttp3.ResponseBody;
import org.json.simple.JSONObject;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

/**
 * The interface Hosting service.
 */
public interface HostingService {

    /**
     * Toggle disable hosting call.
     *
     * @param headers the headers
     * @param appId   the app id
     * @return the call
     */
    @PATCH("manifests/{appId}/hosting/disable")
    Call<ResponseBody> toggleDisableHosting(
            @HeaderMap Map<String, String> headers,
            @Path("appId") String appId);

    /**
     * Toggle enable hosting call.
     *
     * @param headers the headers
     * @param appId   the app id
     * @return the call
     */
    @PATCH("manifests/{appId}/hosting/enable")
    Call<ResponseBody> toggleEnableHosting(
            @HeaderMap Map<String, String> headers,
            @Path("appId") String appId);

    /**
     * Signed upload url call.
     *
     * @param headers the headers
     * @param uid     the uid
     * @return the call
     */
    @POST(" /manifests/{uid}/hosting/signedUploadUrl")
    Call<ResponseBody> signedUploadUrl(
            @HeaderMap Map<String, String> headers,
            @Path("uid") String uid);

    /**
     * Upload file call.
     *
     * @param url     the url
     * @param headers the headers
     * @param param   the param
     * @return the call
     */
    @POST("/{url}")
    Call<ResponseBody> uploadFile(
            @Path(value = "url", encoded = true) String url,
            @HeaderMap Map<String, String> headers,
            @QueryMap Map<String, Object> param);

    /**
     * Create deployments call.
     *
     * @param headers     the headers
     * @param appId       the app id
     * @param body        the body
     * @param queryParams the query params
     * @return the call
     */
    @POST("manifests/{appId}/hosting/deployments")
    Call<ResponseBody> createDeployments(
            @HeaderMap Map<String, String> headers,
            @Path("appId") String appId,
            @Body JSONObject body,
            @QueryMap Map<String, Object> queryParams);

    /**
     * Create signed download url call.
     *
     * @param headers the headers
     * @param appId   the app id
     * @param params  the params
     * @return the call
     */
    @POST("manifests/{appId}/hosting/signedDownloadUrl")
    Call<ResponseBody> createSignedDownloadUrl(
            @HeaderMap Map<String, String> headers,
            @Path("appId") String appId,
            @QueryMap Map<String, Object> params);

    /**
     * Gets hosting.
     *
     * @param headers the headers
     * @param uid     the uid
     * @param params  the params
     * @return the hosting
     */
    @GET("manifests/{uid}/hosting")
    Call<ResponseBody> getHosting(
            @HeaderMap Map<String, String> headers,
            @Path("uid") String uid,
            @QueryMap Map<String, Object> params);

    /**
     * Find deployments call.
     *
     * @param headers the headers
     * @param appId   the app id
     * @param params  the params
     * @return the call
     */
    @GET("manifests/{appId}/hosting/deployments")
    Call<ResponseBody> findDeployments(
            @HeaderMap Map<String, String> headers,
            @Path("appId") String appId,
            @QueryMap Map<String, Object> params);

    /**
     * Fetch deployment call.
     *
     * @param headers      the headers
     * @param appId        the app id
     * @param deploymentId the deployment id
     * @param queryParams  the query params
     * @return the call
     */
    @GET("manifests/{appId}/hosting/deployments/{deploymentId}")
    Call<ResponseBody> fetchDeployment(
            @HeaderMap Map<String, String> headers,
            @Path("appId") String appId,
            @Path("deploymentId") String deploymentId,
            @QueryMap Map<String, Object> queryParams);

    /**
     * Fetch latest live deployment call.
     *
     * @param headers     the headers
     * @param appId       the app id
     * @param queryParams the query params
     * @return the call
     */
    @GET("manifests/{appId}/hosting/latestLiveDeployment")
    Call<ResponseBody> fetchLatestLiveDeployment(
            @HeaderMap Map<String, String> headers,
            @Path("appId") String appId,
            @QueryMap Map<String, Object> queryParams);

    /**
     * Find deployment logs call.
     *
     * @param headers      the headers
     * @param appId        the app id
     * @param deploymentId the deployment id
     * @param queryParams  the query params
     * @return the call
     */
    @GET("manifests/{appId}/hosting/deployments/{deploymentId}/logs")
    Call<ResponseBody> findDeploymentLogs(
            @HeaderMap Map<String, String> headers,
            @Path("appId") String appId,
            @Path("deploymentId") String deploymentId,
            @QueryMap Map<String, Object> queryParams);

    /**
     * Download file call.
     *
     * @param url         the url
     * @param headers     the headers
     * @param queryParams the query params
     * @return the call
     */
    @GET("{url}")
    Call<ResponseBody> downloadFile(
            @Path(value = "url", encoded = true) String url,
            @HeaderMap Map<String, String> headers,
            @QueryMap Map<String, Object> queryParams);

}
