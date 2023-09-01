package com.contentstack.sdk.marketplace.auths;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.QueryMap;

import java.util.Map;

/**
 * The interface Auth service.
 */
public interface AuthService {

    /**
     * Find authorized apps call.
     *
     * @param headers the headers
     * @param params  the params
     * @return the call
     */
    @GET("authorized-apps")
    Call<ResponseBody> findAuthorizedApps(@HeaderMap Map<String, String> headers,
                                          @QueryMap Map<String, Object> params);
}
