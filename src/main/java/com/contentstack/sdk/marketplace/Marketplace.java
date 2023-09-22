package com.contentstack.sdk.marketplace;


import com.contentstack.sdk.Client;
import com.contentstack.sdk.Region;
import com.contentstack.sdk.marketplace.apps.App;
import com.contentstack.sdk.marketplace.auths.Auth;
import com.contentstack.sdk.marketplace.installations.Installation;
import com.contentstack.sdk.marketplace.login.LoginModel;
import com.contentstack.sdk.marketplace.login.LoginService;
import com.contentstack.sdk.marketplace.request.AppRequest;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONObject;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.HashMap;


public class Marketplace {

    private final Retrofit client;
    protected final String orgId;
    private final String host;

    private static final String DEFAULT_HOST = "developerhub-api.contentstack.com";
    private final String authtoken;

    private Marketplace(String authtoken, String organizationUid, String host, Region region) {
        this.authtoken = authtoken;
        this.orgId = organizationUid;
        if (region != null) {
            host = region.name().toLowerCase() + "-" + host;
        }
        this.host = host.isEmpty() ? DEFAULT_HOST : host;
        this.client = Client.getInstance(this.host);
    }

    public static class Builder {
        private final String orgId;
        private String host;
        private Region region = null;
        private String authtoken;


        public Builder(@NotNull String organizationUid) {
            if (organizationUid.isEmpty()) {
                throw new NullPointerException("Empty fields are not allowed");
            }
            this.orgId = organizationUid;
        }

        /**
         * Host builder.
         *
         * @param customHost the custom host
         * @return the builder
         * <p>
         * <b>Example</b>
         * <p>
         * <code>
         * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
         * .host("custom.contentstack.io").host("api.contentstack.com").build();
         * </code>
         */
        public Builder host(String customHost) {
            this.host = customHost;
            return this;
        }

        /**
         * Region builder.
         *
         * @param stackRegion the stack region
         * @return the builder
         * <p>
         * <b>Example</b>
         * <p>
         * <code>
         * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
         * .host("custom.contentstack.io").region(Region.EU).build();
         * </code>
         */
        public Builder region(Region stackRegion) {
            this.region = stackRegion;
            return this;
        }


        /**
         * Sets authtoken for marketplaces
         *
         * @param authtoken the authtoken
         * @return the builder
         */
        public Builder authtoken(String authtoken) {
            this.authtoken = authtoken;
            return this;
        }

        /**
         * Build marketplace.
         *
         * @return the marketplace
         * <p>
         * <b>Example</b>
         * <p>
         * <code>
         * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
         * .host("api.contentstack.io").build();
         * </code>
         */
        public Marketplace build() {
            return new Marketplace(this.authtoken, this.orgId, this.host, this.region);
        }


        /**
         * This method is to generate authtoken for Marketplace
         *
         * @param email    the email address
         * @param password the password
         * @return instance of {@link Builder}
         */
        public Builder login(String email, String password) {
            final String BASE_URL = "https://api.contentstack.io/v3/";

            Retrofit.Builder builder
                    = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

            Retrofit retrofit = builder.build();
            LoginService service = retrofit.create(LoginService.class);
            HashMap<String, HashMap<String, String>> userSession = new HashMap<>();
            userSession.put("user", setCredentials(email, password));
            JSONObject userDetail = new JSONObject(userSession);
            Call<LoginModel> request = service.login(loginHeader(), userDetail);
            try {
                Response<LoginModel> response = request.execute();
                assert response.body() != null;
                this.authtoken = response.body().getUser().authtoken;

            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
            return this;
        }

        private HashMap<String, String> loginHeader() {
            HashMap<String, String> loginHeader = new HashMap<>();
            loginHeader.put("Content-Type", "application/json");
            return loginHeader;
        }


        private HashMap<String, String> setCredentials(@NotNull String... arguments) {
            HashMap<String, String> credentials = new HashMap<>();
            credentials.put("email", arguments[0]);
            credentials.put("password", arguments[1]);
            if (arguments.length > 2) {
                credentials.put("tfa_token", arguments[2]);
            }
            return credentials;
        }

    }


    /**
     * It provides access of app instance
     *
     * @return the app instance
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io")
     * .build();
     * App app = marketplace.app();
     * </code>
     */
    public App app() {
        return new App(this.client, this.authtoken, this.orgId);
    }

    /**
     * It provides access of app instance
     *
     * @param uid the uid
     * @return the app instance
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * App app = marketplace.app("app_uid");
     * </code>
     */
    public App app(@NotNull String uid) {
        return new App(this.client, this.authtoken, this.orgId, uid);
    }

    /**
     * It provides access of Auth instance
     *
     * @return the auth instance
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * Auth authorizations = marketplace.authorizations();
     * </code>
     */
    public Auth authorizations() {
        return new Auth(this.client, this.authtoken, this.orgId);
    }

    /**
     * It provides access of Installation instance
     *
     * @return the installation instance
     *
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * Auth authorizations = marketplace.installation();
     * </code>
     */
    public Installation installation() {
        return new Installation(this.client, this.authtoken, this.orgId);
    }

    /**
     * It provides access of Installation instance
     *
     * @param installationId the installation id
     * @return the installation instance
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * Installation installation = marketplace.installation("installationId");
     * </code>
     */
    public Installation installation(String installationId) {
        return new Installation(this.client, this.authtoken, this.orgId, installationId);
    }

    /**
     * It provides access of AppRequest instance
     *
     * @return the app request instance
     * <p>
     * <b>Example</b>
     * <p>
     * <code>
     * Marketplace marketplace = new Marketplace.Builder("ORGANIZATION_UID")
     * .host("api.contentstack.io").build();
     * AppRequest request = marketplace.request();
     * </code>
     */
    public AppRequest request() {
        return new AppRequest(this.client, this.authtoken, this.orgId);
    }
}
