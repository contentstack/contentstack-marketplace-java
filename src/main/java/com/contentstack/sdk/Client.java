package com.contentstack.sdk;

import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    protected static Retrofit retrofit;
    protected static final String SCHEME = "https://";
    protected static final String SLASH = "/";

    public static Retrofit getInstance(@NotNull String host) {
        String BASE_URL = SCHEME + host + SLASH;
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL) // Replace with your API base URL
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
