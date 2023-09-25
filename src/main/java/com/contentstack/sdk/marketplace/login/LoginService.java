package com.contentstack.sdk.marketplace.login;

import org.json.simple.JSONObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

import java.util.Map;

public interface LoginService {

    @POST("user-session")
    Call<LoginModel> login(@HeaderMap Map<String, String> headers, @Body JSONObject body);
}
