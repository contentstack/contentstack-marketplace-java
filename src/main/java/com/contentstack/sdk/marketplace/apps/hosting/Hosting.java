package com.contentstack.sdk.marketplace.apps.hosting;

import com.contentstack.sdk.BaseImplementation;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONObject;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.util.HashMap;
import java.util.Objects;

public class Hosting implements BaseImplementation<Hosting> {
    private final HostingService service;
    protected HashMap<String, String> headers;
    protected HashMap<String, Object> params;
    protected final String appId;

    // Instantiates a new Hosting
    // The `public Hosting(Retrofit client, String organizationId, @NotNull String
    // appId)` constructor
    // is used to initialize the `Hosting` object. It takes three parameters:
    // `client`,
    // `organizationId`, and `appId`.
    public Hosting(Retrofit client, String organizationId, @NotNull String appId) {
        this.headers = new HashMap<>();
        this.params = new HashMap<>();
        Objects.requireNonNull(appId, "app id/manifest uid is required");
        this.appId = appId;
        Objects.requireNonNull(organizationId, "Organization uid could not be empty");
        this.headers.put("organization_uid", organizationId);
        this.service = client.create(HostingService.class);
    }

    /**
     * The function fetches hosting data using the provided headers, app ID, and
     * parameters. It Gets hosting configuration of your App Manifest
     *
     * @return The method is returning a Call object with a generic type of
     * ResponseBody.
     */
    public Call<ResponseBody> fetchHosting() {
        return this.service.getHosting(this.headers, this.appId, this.params);
    }

    /**
     * Create signed upload url call.
     * The function returns a signed upload URL by making a request to a service
     * with the provided headers and app ID.
     *
     * @return The method is returning a Call object with a generic type of
     * ResponseBody.
     */
    public Call<ResponseBody> createSignedUploadUrl() {
        return this.service.signedUploadUrl(this.headers, this.appId);
    }

    /**
     * The function uploads a file to a specified URL using the provided headers and
     * parameters.
     *
     * @param url The URL where the file will be uploaded to.
     * @return The method is returning a Call object with a ResponseBody type.
     */
    public Call<ResponseBody> uploadFile(@NotNull String url) {
        Objects.requireNonNull(url, "Url is required to upload the file");
        return this.service.uploadFile(url, this.headers, this.params);
    }

    /**
     * The function creates a deployment using the provided JSON body.
     *
     * @param body The `body` parameter is a `JSONObject` that contains the data
     *             needed to create a
     *             deployment.
     * @return The method is returning a Call object with a ResponseBody type.
     */
    public Call<ResponseBody> createDeployment(@NotNull JSONObject body) {
        return this.service.createDeployments(this.headers, this.appId, body, this.params);
    }

    /**
     * The function `findDeployments()` returns a `Call` object that makes a request
     * to find deployments
     * using the provided headers, app ID, and parameters.
     *
     * @return The method is returning a Call object with a generic type of
     * ResponseBody.
     */
    public Call<ResponseBody> findDeployments() {
        return this.service.findDeployments(this.headers, this.appId, this.params);
    }

    /**
     * The function fetches a deployment using the provided deployment ID.
     *
     * @param deploymentId The deploymentId is a unique identifier for a deployment.
     *                     It is used to retrieve
     *                     information about a specific deployment.
     * @return instance call
     */
    public Call<ResponseBody> fetchDeployment(@NotNull String deploymentId) {
        Objects.requireNonNull(this.appId, "App uid is required");
        Objects.requireNonNull(deploymentId, "deploymentId is required to get deployment");
        return this.service.fetchDeployment(this.headers, this.appId, deploymentId, this.params);
    }

    /**
     * The function returns the latest live deployment by making an API call.
     *
     * @return The method is returning a `Call` object with a generic type of
     * `ResponseBody`.
     */
    public Call<ResponseBody> getLatestLiveDeployment() {
        return this.service.fetchLatestLiveDeployment(this.headers, this.appId, this.params);
    }

    /**
     * The function `findDeploymentLogs` returns a `Call` object that retrieves
     * deployment logs based on
     * the provided deployment ID.
     *
     * @param deploymentId The deployment ID is a unique identifier for a specific
     *                     deployment. It is used
     *                     to identify and retrieve the logs for a particular
     *                     deployment.
     * @return The method is returning a `Call` object with a generic type of
     * `ResponseBody`.
     */
    public Call<ResponseBody> findDeploymentLogs(@NotNull String deploymentId) {
        return this.service.findDeploymentLogs(this.headers, this.appId, deploymentId, this.params);
    }

    /**
     * The function creates a signed download URL using the provided headers, app
     * ID, and parameters.
     *
     * @return The method is returning a `Call` object with a generic type of
     * `ResponseBody`.
     */
    public Call<ResponseBody> createSignedDownloadUrl() {
        return this.service.createSignedDownloadUrl(this.headers, this.appId, this.params);
    }

    /**
     * The function `downloadFile` downloads a file from a given URL using the
     * provided headers and
     * parameters.
     *
     * @param url The URL of the file that you want to download.
     * @return instance call
     */
    public Call<ResponseBody> downloadFile(@NotNull String url) {
        return this.service.downloadFile(url, this.headers, this.params);
    }

    /**
     * The function enables or disables hosting for a specific application.
     * It is used to enable or disable the hosting of an app.
     * <br>
     *
     * <b>ACL:</b>
     * <p>
     * Organisation Admins
     * <p>
     * Organisation Owners
     * <p>
     * Stack Owners
     * <p>
     * Stack Admins
     *
     * @return The method is returning a Call object with a ResponseBody type.
     */
    public Call<ResponseBody> enableToggleHosting() {
        Objects.requireNonNull(this.appId, "App uid is required");
        return this.service.toggleEnableHosting(this.headers, this.appId);
    }

    /**
     * The function `disableToggleHosting()` makes a network call to disable hosting
     * for a specific app.
     * The toggle hosting call is used to disable the hosting of an app.
     * <br>
     *
     * <p>
     * Organisation Admins
     * <p>
     * Organisation Owners
     * <p>
     * Stack Owners
     * <p>
     * Stack Admins
     *
     * @return The method is returning a Call object with a ResponseBody type.
     */
    public Call<ResponseBody> disableToggleHosting() {
        return this.service.toggleDisableHosting(this.headers, this.appId);
    }

    /**
     * Adds a header with the specified key and value to this location and returns
     * the updated location.
     *
     * @param key   the key of the header to be added
     * @param value the value of the header to be added
     * @return a new {@link Hosting} object with the specified header added
     * @throws NullPointerException if the key or value argument is null
     */
    @Override
    public Hosting addParam(@NotNull String key, @NotNull Object value) {
        this.params.put(key, value);
        return this;
    }

    /**
     * Adds a header with the specified key and value to this location and returns
     * the updated location.
     *
     * @param key   the key of the header to be added
     * @param value the value of the header to be added
     * @return a new {@link Hosting} object with the specified header added
     * @throws NullPointerException if the key or value argument is null
     */
    @Override
    public Hosting addHeader(@NotNull String key, @NotNull String value) {
        this.headers.put(key, value);
        return this;
    }

    /**
     * Adds the specified parameters to this location and returns the updated
     * location.
     *
     * @param params a {@link HashMap} containing the parameters to be added
     * @return a new {@link Hosting} object with the specified parameters added
     * @throws NullPointerException if the params argument is null
     */
    @Override
    public Hosting addParams(@NotNull HashMap<String, Object> params) {
        this.params.putAll(params);
        return this;
    }

    /**
     * Adds the specified parameters to this location and returns the updated
     * location.
     *
     * @param headers a {@link HashMap} containing the parameters to be added
     * @return a new {@link Hosting} object with the specified parameters added
     * @throws NullPointerException if the params argument is null
     */
    @Override
    public Hosting addHeaders(@NotNull HashMap<String, String> headers) {
        this.headers.putAll(headers);
        return this;
    }

}
