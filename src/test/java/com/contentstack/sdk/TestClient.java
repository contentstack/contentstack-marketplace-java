package com.contentstack.sdk;

import com.contentstack.sdk.marketplace.Marketplace;
import io.github.cdimascio.dotenv.Dotenv;

public class TestClient {
    final static Dotenv env = Dotenv.load();
    final static String HOST = "developerhub-api.contentstack.com";
    public final static String ORGANIZATION_UID = (env.get("organizationUid") != null) ? env.get("organizationUid") : "orgId999999999";
    public final static String AUTHTOKEN = (env.get("authToken") != null) ? env.get("authToken") : "auth999999999";
    public final static String USER_ID = (env.get("userId") != null) ? env.get("userId") : "bltc11e668e0295477f";
    private static Marketplace instance;

    private TestClient() {
        // Private constructor to prevent direct instantiation
    }

    public static Marketplace getMarketplace() {
        if (instance == null) {
            synchronized (Marketplace.class) {
                if (instance == null) {
                    instance = new Marketplace(ORGANIZATION_UID, "api.contentstack.io");
                }
            }
        }
        return instance;
    }

}

