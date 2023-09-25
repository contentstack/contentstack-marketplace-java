package com.contentstack.sdk.marketplace.installations.webhook;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

/**
 * The interface Webhook service.
 */
public interface WebhookService {

    /**
     * Find execution logs call.
     *
     * @param headers        the headers
     * @param installationId the installation id
     * @param webhookId      the webhook id
     * @param queryParams    the query params
     * @return the call
     */
    @GET("installations/{installationId}/webhooks/{webhookId}/executions")
    Call<ResponseBody> findExecutionLogs(
            @HeaderMap Map<String, String> headers,
            @Path("installationId") String installationId,
            @Path("webhookId") String webhookId,
            @QueryMap Map<String, Object> queryParams);

    /**
     * Fetch execution log call.
     *
     * @param headers        the headers
     * @param installationId the installation id
     * @param webhookId      the webhook id
     * @param executionId    the execution id
     * @param queryParams    the query params
     * @return the call
     */
    @GET("/installations/{installationId}/webhooks/{webhookId}/executions/{executionId}")
    Call<ResponseBody> fetchExecutionLog(
            @HeaderMap Map<String, String> headers,
            @Path("installationId") String installationId,
            @Path("webhookId") String webhookId,
            @Path("executionId") String executionId,
            @QueryMap Map<String, Object> queryParams);

    /**
     * Retry execution call.
     *
     * @param headers        the headers
     * @param installationId the installation id
     * @param webhookId      the webhook id
     * @param executionId    the execution id
     * @param queryParams    the query params
     * @return the call
     */
    @POST("/installations/{installationId}/webhooks/{webhookId}/executions/{executionId}/retry")
    Call<ResponseBody> retryExecution(
            @HeaderMap Map<String, String> headers,
            @Path("installationId") String installationId,
            @Path("webhookId") String webhookId,
            @Path("executionId") String executionId,
            @QueryMap Map<String, Object> queryParams);
}
