package com.contentstack.sdk.marketplace.installations;

import com.contentstack.sdk.BaseImplementation;
import com.contentstack.sdk.marketplace.installations.location.Location;
import com.contentstack.sdk.marketplace.installations.webhook.Webhook;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONObject;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.util.HashMap;

/**
 * The type Installation.
 */
public class Installation implements BaseImplementation<Installation> {

    /**
     * The Missing org id.
     */
    public final String MISSING_ORG_ID = "organization uid is required";
    private String installationId;
    private String organisationId;
    private InstallationService service;
    /**
     * The Headers.
     */
    protected HashMap<String, String> headers;
    /**
     * The Params.
     */
    protected HashMap<String, Object> params;
    private Retrofit client;

    /**
     * Instantiates a new Installation.
     *
     * @param client         the client
     * @param organisationId the organisation id
     * @param installationId the installation id
     */
// The `public Installation(Retrofit client, @NotNull String organisationId,
    // @NotNull String
    // installationId)` is a constructor for the `Installation` class. It takes
    // three parameters: `client`,
    // `organisationId`, and `installationId`.
    public Installation(Retrofit client, @NotNull String organisationId, @NotNull String installationId) {
        checkOrganisationId(organisationId);
        init(client, organisationId, installationId);
    }

    /**
     * The function checks if the organisationId is empty and throws a
     * NullPointerException if it is.
     *
     * @param organisationId The parameter `organisationId` is a string that                       represents the ID of an                       organization.
     */
    protected void checkOrganisationId(String organisationId) {
        if (organisationId.isEmpty()) {
            throw new NullPointerException(MISSING_ORG_ID);
        }
    }

    /**
     * The function validates if the installationId is not null or empty.
     *
     * @param installationId The installationId parameter is a string that represents the unique identifier for an installation.
     */
    protected void validateInstallationId(String installationId) {
        if (installationId == null || installationId.isEmpty()) {
            throw new IllegalArgumentException("installationId is requirement");
        }
    }

    /**
     * Instantiates a new Installation.
     *
     * @param client         the client
     * @param organisationId the organisation id
     *                       <p>
     *                       <b>Example</b>
     *                       <p>
     *                       <code>
     *                       Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     *                       .host("api.contentstack.io").build();
     *                       Installation installation = marketplace.installation();
     *                       </code>
     */
    public Installation(@NotNull Retrofit client, @NotNull String organisationId) {
        checkOrganisationId(organisationId);
        init(client, organisationId, null);
    }

    /**
     * The function initializes the headers, parameters, installation ID,
     * organization ID, Retrofit client,
     * and service for an installation.
     *
     * @param client         The `client` parameter is an instance of the Retrofit
     *                       class. It is used to make HTTP
     *                       requests to a RESTful API.
     * @param organisationId The `organisationId` parameter is a string that
     *                       represents the unique
     *                       identifier of an organization.
     * @param installationId The installationId parameter is a String that
     *                       represents the unique identifier
     *                       for an installation.
     */
    private void init(Retrofit client, @NotNull String organisationId, String installationId) {
        this.headers = new HashMap<>();
        this.params = new HashMap<>();
        this.installationId = installationId;
        this.organisationId = organisationId;
        this.client = client;
        this.headers.put("organization_uid", organisationId);
        this.service = this.client.create(InstallationService.class);
    }

    /**
     * The function returns a list of installed apps by making a network call.
     *
     * @return The method is returning a `Call` object with a generic type of `ResponseBody`.
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * Installation installation = marketplace.installation();
     * JSONObject body = new JSONObject();
     * Call result = installation.findInstalledApps().execute();
     * </code>
     */
    Call<ResponseBody> findInstalledApps() {
        return this.service.listInstalledApps(this.headers, this.params);
    }

    /**
     * Find installations call.
     *
     * @return the call
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * Installation installation = marketplace.installation();
     * JSONObject body = new JSONObject();
     * Call result = installation.findInstallations().execute();
     * </code>
     */
    Call<ResponseBody> findInstallations() {
        return this.service.listInstallations(this.headers, this.params);
    }

    /**
     * The function fetches an installation by validating the installation ID and
     * making a network request.
     *
     * @return The method `fetchInstallation()` is returning a `Call<ResponseBody>` object.
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * Installation installation = marketplace.installation();
     * JSONObject body = new JSONObject();
     * Call result = installation.fetchInstallation().execute();
     * </code>
     */
    Call<ResponseBody> fetchInstallation() {
        validateInstallationId(this.installationId);
        return this.service.getInstallations(this.headers, installationId, this.params);
    }

    /**
     * The function fetches installation data by validating the installation ID and
     * making a network
     * request.
     *
     * @return The method is returning a `Call<ResponseBody>` object.
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * Installation installation = marketplace.installation();
     * JSONObject body = new JSONObject();
     * Call result = installation.fetchInstallationData().execute();
     * </code>
     */
    Call<ResponseBody> fetchInstallationData() {
        validateInstallationId(this.installationId);
        return this.service.getInstallationData(this.headers, this.installationId, this.params);
    }

    /**
     * The function updates an installation with a given installation ID and returns
     * the response body.
     *
     * @param body A JSONObject containing the data to be updated for the installation.
     * @return The method is returning a Call object with a ResponseBody type.
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * Installation installation = marketplace.installation();
     * JSONObject body = new JSONObject();
     * Call result = installation.updateInstallation(body).execute();
     * </code>
     */
    Call<ResponseBody> updateInstallation(JSONObject body) {
        validateInstallationId(this.installationId);
        return this.service.updateInstallation(this.headers, this.installationId, body, this.params);
    }

    /**
     * The function returns a list of installed users by making a network call.
     *
     * @return The method is returning a `Call` object with a generic type of `ResponseBody`
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * Installation installation = marketplace.installation();
     * JSONObject body = new JSONObject();
     * Call result = installation.findInstalledUsers().execute();
     * </code>
     */
    Call<ResponseBody> findInstalledUsers() {
        return this.service.listInstalledUsers(this.headers, this.params);
    }

    /**
     * The function returns a list of installed stacks by making a network call.
     *
     * @return The method is returning a `Call` object with a generic type of `ResponseBody`.
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * Installation installation = marketplace.installation();
     * JSONObject body = new JSONObject();
     * Call result = installation.findInstalledStacks().execute();
     * </code>
     */
    Call<ResponseBody> findInstalledStacks() {
        return this.service.listInstalledStacks(this.headers, this.params);
    }

    /**
     * The function `uninstall()` validates the installation ID and then calls the
     * `uninstall()` method of
     * a service, returning the response body.
     *
     * @return The method is returning a Call object with a ResponseBody type.
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * Installation installation = marketplace.installation();
     * JSONObject body = new JSONObject();
     * Call result = installation.uninstall().execute();
     * </code>
     */
    Call<ResponseBody> uninstall() {
        validateInstallationId(this.installationId);
        return this.service.uninstall(this.headers, this.installationId);
    }

    /**
     * The function fetches the app configuration by validating the installation ID
     * and making a network
     * request.
     *
     * @return The method is returning a Call object with a generic type of ResponseBody.
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * Installation installation = marketplace.installation();
     * JSONObject body = new JSONObject();
     * Call result = installation.fetchAppConfiguration().execute();
     * </code>
     */
    Call<ResponseBody> fetchAppConfiguration() {
        validateInstallationId(this.installationId);
        return this.service.getAppConfiguration(this.headers, this.installationId, this.params);
    }

    /**
     * The function fetches the server configuration by making a network request
     * with the installation ID
     * and parameters.
     *
     * @return The method is returning a Call object with a generic type of ResponseBody.
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * Installation installation = marketplace.installation();
     * JSONObject body = new JSONObject();
     * Call result = installation.fetchServerConfiguration().execute();
     * </code>
     */
    Call<ResponseBody> fetchServerConfiguration() {
        validateInstallationId(this.installationId);
        return this.service.getServerConfiguration(this.headers, this.installationId, this.params);
    }

    /**
     * The function updates the server configuration with the given JSON object and
     * returns the response
     * body.
     *
     * @param body A JSONObject containing the updated server configuration data.
     * @return The method is returning a Call object with a ResponseBody type.
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * Installation installation = marketplace.installation();
     * JSONObject body = new JSONObject();
     * Call result = installation.updateServerConfiguration().execute();
     * </code>
     */
    Call<ResponseBody> updateServerConfiguration(JSONObject body) {
        validateInstallationId(this.installationId);
        return this.service.updateServerConfiguration(this.headers, this.installationId, body, this.params);
    }

    /**
     * The function updates the stack configuration using the provided JSON object.
     *
     * @param body A JSONObject containing the updated stack configuration data.
     * @return The method is returning a Call object with a ResponseBody type.
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * Installation installation = marketplace.installation();
     * JSONObject body = new JSONObject();
     * Call result = installation.updateStackConfiguration(body).execute();
     * </code>
     */
    Call<ResponseBody> updateStackConfiguration(JSONObject body) {
        validateInstallationId(this.installationId);
        return this.service.updateStackConfiguration(this.headers, this.installationId, body, this.params);
    }

    /**
     * The function creates an installation token by validating the installation ID
     * and making a request to
     * the service.
     *
     * @return The method is returning a `Call` object with a generic type of `ResponseBody`.
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * Installation installation = marketplace.installation();
     * Call result = installation.createInstallationToken().execute();
     * </code>
     */
    Call<ResponseBody> createInstallationToken() {
        validateInstallationId(this.installationId);
        return this.service.createInstallationToken(this.headers, this.installationId, this.params);
    }

    /**
     * The function returns a new Location object with the specified client,
     * organisationId, and
     * installationId.
     *
     * @return An instance of the Location class.
     *
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * Installation installation = marketplace.installation();
     * Call result = installation.location().execute();
     * </code>
     */
    public Location location() {
        validateInstallationId(this.installationId);
        return new Location(this.client, this.organisationId, this.installationId);
    }

    /**
     * The function creates and returns a new Webhook object with the given
     * parameters.
     *
     * @param webhookId A string representing the ID of the webhook.
     * @return An instance of the Webhook class.
     *
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * Installation installation = marketplace.installation();
     * JSONObject body = new JSONObject();
     * Call result = installation.webhook("webhookId").execute();
     * </code>
     */
    public Webhook webhook(@NotNull String webhookId) {
        validateInstallationId(this.installationId);
        return new Webhook(this.client, this.organisationId, webhookId, this.installationId);
    }


    /**
     * @param key   A non-null String representing the key for the parameter.
     * @param value The value parameter is of type Object, which means it can accept              any type of object              as its value.
     * @return instance of Installation
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * Installation installation = marketplace.installation().addParam("key", "value");
     * </code>
     */
    @Override
    public Installation addParam(@NotNull String key, @NotNull Object value) {
        this.params.put(key, value);
        return this;
    }

    /**
     * @param key   A non-null String representing the header key.
     * @param value The value parameter is a string that represents the value of the              header.
     * @return instance of Installation
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * Installation installation = marketplace.installation().addHeader("key", "value");
     * </code>
     */
    @Override
    public Installation addHeader(@NotNull String key, @NotNull String value) {
        this.headers.put(key, value);
        return this;
    }

    /**
     * @param parameters A HashMap object that stores key-value pairs, where the key                   is of type String                   and the value is of type Object. The HashMap is annotated                   with @NotNull, indicating that it                   cannot be null.
     * @return instance of {@link Installation}
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * HashMap parameters = new HashMap();
     * Installation installation = marketplace.installation().addParams(parameters);
     * </code>
     */
    @Override
    public Installation addParams(@NotNull HashMap<String, Object> parameters) {
        this.params.putAll(parameters);
        return this;
    }

    /**
     * @param headers A HashMap object that contains key-value pairs representing                the headers to be                added. The keys represent the header names, and the values                represent the header values.
     * @return instance of {@link Installation}
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * HashMap parameters = new HashMap();
     * Installation installation = marketplace.installation().addHeaders(parameters);
     * </code>
     */
    @Override
    public Installation addHeaders(@NotNull HashMap<String, String> headers) {
        this.headers.putAll(headers);
        return this;
    }
}
