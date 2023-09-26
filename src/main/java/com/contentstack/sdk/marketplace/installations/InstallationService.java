package com.contentstack.sdk.marketplace.installations;

import okhttp3.ResponseBody;
import org.json.simple.JSONObject;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

/**
 * The interface Installation service.
 */
public interface InstallationService {

    /**
     * List installed apps call.
     *
     * @param headers     the headers
     * @param queryParams the query params
     * @return the call
     */
    @GET("installations/view/apps")
    Call<ResponseBody> listInstalledApps(
            @HeaderMap Map<String, String> headers,
            @QueryMap Map<String, Object> queryParams);

    /**
     * List installations call.
     *
     * @param headers     the headers
     * @param queryParams the query params
     * @return the call
     */
    @GET("installations")
    Call<ResponseBody> listInstallations(
            @HeaderMap Map<String, String> headers,
            @QueryMap Map<String, Object> queryParams);

    /**
     * Gets installations.
     *
     * @param headers     the headers
     * @param id          the id
     * @param queryParams the query params
     * @return the installations
     */
    @GET("installations/{id}")
    Call<ResponseBody> getInstallations(
            @HeaderMap Map<String, String> headers,
            @Path("id") String id,
            @QueryMap Map<String, Object> queryParams);

    /**
     * Gets installation data.
     *
     * @param headers     the headers
     * @param id          the id
     * @param queryParams the query params
     * @return the installation data
     */
    @GET("installations/{id}/installationData")
    Call<ResponseBody> getInstallationData(
            @HeaderMap Map<String, String> headers,
            @Path("id") String id,
            @QueryMap Map<String, Object> queryParams);

    /**
     * Update installation call.
     *
     * @param headers     the headers
     * @param id          the id
     * @param requestBody the request body
     * @param queryParams the query params
     * @return the call
     */
    @PUT("installations/{id}")
    Call<ResponseBody> updateInstallation(
            @HeaderMap Map<String, String> headers,
            @Path("id") String id,
            @Body JSONObject requestBody,
            @QueryMap Map<String, Object> queryParams);

    /**
     * List installed users call.
     *
     * @param headers     the headers
     * @param queryParams the query params
     * @return the call
     */
    @GET("installations/view/users")
    Call<ResponseBody> listInstalledUsers(
            @HeaderMap Map<String, String> headers,
            @QueryMap Map<String, Object> queryParams);

    /**
     * List installed stacks call.
     *
     * @param headers     the headers
     * @param queryParams the query params
     * @return the call
     */
    @GET("installations/view/stacks")
    Call<ResponseBody> listInstalledStacks(
            @HeaderMap Map<String, String> headers,
            @QueryMap Map<String, Object> queryParams);

    /**
     * Uninstall call.
     *
     * @param headers the headers
     * @param id      the id
     * @return the call
     */
    @DELETE("installations/{id}")
    Call<ResponseBody> uninstall(
            @HeaderMap Map<String, String> headers,
            @Path("id") String id);

    /**
     * Gets app configuration.
     *
     * @param headers     the headers
     * @param id          the id
     * @param queryParams the query params
     * @return the app configuration
     */
    @GET("installations/{id}/configuration")
    Call<ResponseBody> getAppConfiguration(
            @HeaderMap Map<String, String> headers,
            @Path("id") String id,
            @QueryMap Map<String, Object> queryParams);

    /**
     * Gets server configuration.
     *
     * @param headers     the headers
     * @param id          the id
     * @param queryParams the query params
     * @return the server configuration
     */
    @GET("installations/{id}/server-configuration")
    Call<ResponseBody> getServerConfiguration(
            @HeaderMap Map<String, String> headers,
            @Path("id") String id,
            @QueryMap Map<String, Object> queryParams);

    /**
     * Update server configuration call.
     *
     * @param headers     the headers
     * @param id          the id
     * @param body        the body
     * @param queryParams the query params
     * @return the call
     */
    @PUT("installations/{id}/server-configuration")
    Call<ResponseBody> updateServerConfiguration(
            @HeaderMap Map<String, String> headers,
            @Path("id") String id,
            @Body JSONObject body,
            @QueryMap Map<String, Object> queryParams);

    /**
     * Update stack configuration call.
     *
     * @param headers     the headers
     * @param id          the id
     * @param body        the body
     * @param queryParams the query params
     * @return the call
     */
    @PUT("installations/{id}/configuration")
    Call<ResponseBody> updateStackConfiguration(
            @HeaderMap Map<String, String> headers,
            @Path("id") String id,
            @Body JSONObject body,
            @QueryMap Map<String, Object> queryParams);

    /**
     * Create installation token call.
     *
     * @param headers     the headers
     * @param id          the id
     * @param queryParams the query params
     * @return the call
     */
    @POST("installations/{id}/token")
    Call<ResponseBody> createInstallationToken(
            @HeaderMap Map<String, String> headers,
            @Path("id") String id,
            @QueryMap Map<String, Object> queryParams);

}
