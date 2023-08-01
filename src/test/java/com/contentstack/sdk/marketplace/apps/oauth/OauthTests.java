package com.contentstack.sdk.marketplace.apps.oauth;

import com.contentstack.sdk.TestClient;
import okhttp3.Request;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.*;

import java.util.HashMap;


@Tag("unit")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OauthTests {

    static Oauth oauth;
    static String ORG_UID = TestClient.ORGANIZATION_UID;
    static String APP_UID = TestClient.AUTHTOKEN;

    @BeforeAll
    static void loadBeforeAll() {
        oauth = TestClient.getMarketplace().app(APP_UID).oauth("app_id");
        oauth = TestClient.getMarketplace().app(APP_UID).oauth();
    }


    @Test
    void testFetchOauthConfiguration() {
        Request request = oauth.addHeader("authtoken", ORG_UID).fetchOauthConfiguration(ORG_UID).request();
        Assertions.assertEquals("/manifests/" + ORG_UID + "/oauth", request.url().encodedPath());
        Assertions.assertEquals("GET", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(3, request.url().pathSegments().size());
        Assertions.assertEquals("manifests", request.url().pathSegments().get(0));
        Assertions.assertEquals(ORG_UID, request.url().pathSegments().get(1));
        Assertions.assertEquals("oauth", request.url().pathSegments().get(2));
        Assertions.assertNull(request.body());
        Assertions.assertNull(request.url().encodedQuery());
        Assertions.assertNull(request.url().query());
    }

    @Test
    void testUpdateOauthConfiguration() {
        JSONObject body = new JSONObject();
        body.put("obj1", "objValue");
        oauth.addHeader("authtoken", ORG_UID);
        oauth.appId = "notEmpty";
        Request request = oauth.updateOauthConfiguration(body).request();
        Assertions.assertEquals("/manifests/" + oauth.appId + "/oauth", request.url().encodedPath());
        Assertions.assertEquals("PUT", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(3, request.url().pathSegments().size());
        Assertions.assertEquals("manifests", request.url().pathSegments().get(0));
        Assertions.assertEquals("notEmpty", request.url().pathSegments().get(1));
        Assertions.assertEquals("oauth", request.url().pathSegments().get(2));
        Assertions.assertNotNull(request.body());
        Assertions.assertNull(request.url().encodedQuery());
    }

    @Test
    void testFindScopes() {
        oauth.addHeader("authtoken", ORG_UID);
        oauth.addParam("paramOne", "value");
        Request request = oauth.findScopes().request();
        Assertions.assertEquals("/manifests/oauth/scopes", request.url().encodedPath());
        Assertions.assertEquals("GET", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(3, request.url().pathSegments().size());
        Assertions.assertEquals("manifests", request.url().pathSegments().get(0));
        Assertions.assertEquals("oauth", request.url().pathSegments().get(1));
        Assertions.assertNull(request.body());
        Assertions.assertNull(request.url().encodedQuery());
    }


    @Test
    void testParamsAndHeaders() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("paramKey1", "paramValue1");
        map.put("paramKey2", "paramValue2");
        oauth.addParams(map).addHeaders(map);
        Request request = oauth.addHeader("authtoken", "fake@token").findScopes().request();
        Assertions.assertTrue(request.isHttps());
        Assertions.assertEquals("GET", request.method());
        Assertions.assertEquals(4, request.headers().size());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertNull(request.body());
        Assertions.assertEquals("https://api.contentstack.io/manifests/oauth/scopes", request.url().toString());
    }

}
