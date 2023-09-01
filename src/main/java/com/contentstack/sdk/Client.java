package com.contentstack.sdk;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * The type Client.
 */
public class Client {
    private static Retrofit retrofit;

    private Client() {
        // Private constructor to prevent instantiation
    }

    /**
     * Get or create the Retrofit instance for the specified host.
     *
     * @param host The host of the API.
     * @return Retrofit instance.
     */
    public static Retrofit getInstance(String host) {
        if (retrofit == null) {
            synchronized (Client.class) {
                if (retrofit == null) {
                    retrofit = createRetrofitInstance(host);
                }
            }
        }
        return retrofit;
    }

    private static Retrofit createRetrofitInstance(String host) {
        String BASE_URL = "https://" + host + "/";
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}

