package com.contentstack.sdk;

import com.contentstack.sdk.marketplace.Marketplace;
import io.github.cdimascio.dotenv.Dotenv;

public class TestClient {
    final static Dotenv env = Dotenv.load();
    final static String HOST = "api.contentstack.io";
    public final static String ORGANIZATION_UID = (env.get("organizationUid") != null) ? env.get("organizationUid") : "orgId999999999";
    public final static String AUTHTOKEN = (env.get("authToken") != null) ? env.get("authToken") : "auth999999999";
    public final static String USER_ID = (env.get("userId") != null) ? env.get("userId") : "bltc11e668e0295477f";
    private static Marketplace instance;

    private TestClient() {
        // Private constructor to prevent direct instantiation
    }


    public static Marketplace getMarketplace() {
        return new Marketplace
                .Builder(TestClient.ORGANIZATION_UID)
                .host(HOST)
                .build();
    }

    public static Marketplace getMarketplaceEU() {
        return new Marketplace
                .Builder(TestClient.ORGANIZATION_UID)
                .host(HOST)
                .region(Region.EU)
                .build();
    }

    public static Marketplace getMarketplaceAzureNa() {
        return new Marketplace
                .Builder(TestClient.ORGANIZATION_UID)
                .host(HOST)
                .region(Region.AZURE_NA)
                .build();
    }

    public static Marketplace getMarketplaceAzureEu() {
        return new Marketplace
                .Builder(TestClient.ORGANIZATION_UID)
                .host(HOST)
                .region(Region.AZURE_EU)
                .build();
    }


    public static Marketplace getMarketplaceWithLogin() {
        return new Marketplace
                .Builder(TestClient.ORGANIZATION_UID)
                .host(HOST)
                .authtoken("test")
                .login("test@email.com", "************")
                .region(Region.AZURE_EU)
                .build();
    }

}

