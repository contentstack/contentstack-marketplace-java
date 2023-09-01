package com.contentstack.sdk.marketplace.apps;

import com.contentstack.sdk.TestClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;

class AppUnitTests {

    private static App app;
    static String ORG_UID = "";
    final String AUTH = TestClient.AUTHTOKEN;

    @BeforeAll
    static void setup() {
        ORG_UID = TestClient.ORGANIZATION_UID;
        app = TestClient.getMarketplace().app(ORG_UID);
        app.addParam("search", "paramValue").
                addParam("limit", 10).
                addParam("skip", 3).
                addParam("order", "asc").
                addParam("sort", "updated_at").
                addParam("target_type", "stack").addHeader("authtoken", ORG_UID);
    }


    @Test
    void testFetchEnqueue() throws IOException {
        Response<ResponseBody> response = app.addHeader("authtoken", AUTH).findApps().execute();
        Assertions.assertFalse(response.isSuccessful());
    }


    @Test
    void testFetchExcecute() throws IOException {
        Response<ResponseBody> response = app.addHeader("authtoken", AUTH).findApps().execute();
        System.out.println("isSuccessful: " + response.isSuccessful());
        System.out.println("response: " + response.body());
        Assertions.assertFalse(response.isSuccessful());
    }

    @Test
    void testFind() {
        Request request = app.findApps().request();
        Assertions.assertEquals("GET", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(1, request.url().pathSegments().size());
        Assertions.assertEquals("manifests", request.url().pathSegments().get(0));
        Assertions.assertNull(request.body());
        Assertions.assertNotNull(request.url().encodedQuery());
        Assertions.assertEquals("search=paramValue&limit=10&target_type=stack&skip=3&sort=updated_at&order=asc", request.url().query());

    }

    @Test
    void testCreate() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("target_type", "dev");
        requestBody.put("name", "test");
        app.addHeader("authtoken", ORG_UID);
        Request request = app.createApp(requestBody).request();
        Assertions.assertEquals("POST", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(1, request.url().pathSegments().size());
        Assertions.assertEquals("manifests", request.url().pathSegments().get(0));
        Assertions.assertNotNull(request.body());
        Assertions.assertNotNull(request.url().encodedQuery());
        Assertions.assertEquals("search=paramValue&limit=10&target_type=stack&skip=3&sort=updated_at&order=asc", request.url().query());
    }


    @Test
    void testCreateInstallation() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("target_type", "dev");
        requestBody.put("name", "test");
        Request request = app.createInstallation(requestBody).request();
        Assertions.assertEquals("POST", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(3, request.url().pathSegments().size());
        Assertions.assertEquals("manifests", request.url().pathSegments().get(0));
        Assertions.assertNotNull(request.body());
        Assertions.assertNotNull(request.url().encodedQuery());
        Assertions.assertEquals("search=paramValue&limit=10&target_type=stack&skip=3&sort=updated_at&order=asc", request.url().query());
    }


    @Test
    void testUpdateVersion() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("target_type", "dev");
        requestBody.put("name", "test");
        Request request = app.updateVersion(requestBody).request();
        Assertions.assertEquals("PUT", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(3, request.url().pathSegments().size());
        Assertions.assertEquals("manifests", request.url().pathSegments().get(0));
        Assertions.assertNotNull(request.body());
        Assertions.assertNotNull(request.url().encodedQuery());
        Assertions.assertEquals("search=paramValue&limit=10&target_type=stack&skip=3&sort=updated_at&order=asc", request.url().query());
    }

    @Test
    void testFindAppAuthorizations() {
        Request request = app.findAppAuthorizations().request();
        Assertions.assertEquals("GET", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(3, request.url().pathSegments().size());
        Assertions.assertEquals("manifests", request.url().pathSegments().get(0));
        Assertions.assertNull(request.body());
        Assertions.assertNotNull(request.url().encodedQuery());
        Assertions.assertEquals("search=paramValue&limit=10&target_type=stack&skip=3&sort=updated_at&order=asc", request.url().query());
    }

    @Test
    void testDeleteAuthorization() {
        Request request = app.deleteAuthorization(ORG_UID).request();
        Assertions.assertEquals("DELETE", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(4, request.url().pathSegments().size());
        Assertions.assertEquals("manifests", request.url().pathSegments().get(0));
        Assertions.assertNull(request.body());
        Assertions.assertNull(request.url().encodedQuery());
    }


    @Test
    void testFindAppInstallations() {
        Request request = app.findAppInstallations().request();
        Assertions.assertEquals("GET", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(3, request.url().pathSegments().size());
        Assertions.assertEquals("manifests", request.url().pathSegments().get(0));
        Assertions.assertNull(request.body());
        Assertions.assertNotNull(request.url().encodedQuery());
        Assertions.assertEquals("search=paramValue&limit=10&target_type=stack&skip=3&sort=updated_at&order=asc", request.url().query());
    }

    @Test
    void testFindApps() {
        Request request = app.findApps().request();
        Assertions.assertEquals("GET", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(1, request.url().pathSegments().size());
        Assertions.assertEquals("manifests", request.url().pathSegments().get(0));
        Assertions.assertNull(request.body());
        Assertions.assertNotNull(request.url().encodedQuery());
        Assertions.assertEquals("search=paramValue&limit=10&target_type=stack&skip=3&sort=updated_at&order=asc", request.url().query());
    }

    @Test
    void testCreateApps() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("target_type", "dev");
        requestBody.put("name", "test");
        Request request = app.createApp(requestBody).request();
        Assertions.assertEquals("POST", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(1, request.url().pathSegments().size());
        Assertions.assertEquals("manifests", request.url().pathSegments().get(0));
        Assertions.assertNotNull(request.body());
        Assertions.assertNotNull(request.url().encodedQuery());
        Assertions.assertEquals("search=paramValue&limit=10&target_type=stack&skip=3&sort=updated_at&order=asc", request.url().query());
    }


    @Test
    void testFetchApps() {
        Request request = app.fetchApp().request();
        Assertions.assertEquals("GET", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(2, request.url().pathSegments().size());
        Assertions.assertEquals("manifests", request.url().pathSegments().get(0));
        Assertions.assertNull(request.body());
        Assertions.assertNotNull(request.url().encodedQuery());
        Assertions.assertEquals("search=paramValue&limit=10&target_type=stack&skip=3&sort=updated_at&order=asc", request.url().query());
    }


    @Test
    void testUpdateApp() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("target_type", "dev");
        requestBody.put("name", "test");
        Request request = app.updateApp(requestBody).request();
        Assertions.assertEquals("PUT", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(2, request.url().pathSegments().size());
        Assertions.assertEquals("manifests", request.url().pathSegments().get(0));
        Assertions.assertNotNull(request.body());
        Assertions.assertNull(request.url().encodedQuery());
    }

    @Test
    void testDeleteApp() {
        Request request = app.deleteApp().request();
        Assertions.assertEquals("DELETE", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(2, request.url().pathSegments().size());
        Assertions.assertEquals("manifests", request.url().pathSegments().get(0));
        Assertions.assertNull(request.body());
        Assertions.assertNull(request.url().encodedQuery());
    }

    @Test
    void testFindAppRequests() {
        Request request = app.findAppRequests().request();
        Assertions.assertEquals("GET", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(3, request.url().pathSegments().size());
        Assertions.assertEquals("manifests", request.url().pathSegments().get(0));
        Assertions.assertNull(request.body());
        Assertions.assertNotNull(request.url().encodedQuery());
        Assertions.assertEquals("search=paramValue&limit=10&target_type=stack&skip=3&sort=updated_at&order=asc", request.url().query());
    }

    @Test
    void testParamsAndHeaders() {
        HashMap<String, String> map = new HashMap<>();
        map.put("paramKey1", "paramValue1");
        map.put("paramKey2", "paramValue2");


        HashMap<String, Object> mapParam = new HashMap<>();
        map.put("paramKey1", "paramValue1");
        map.put("paramKey2", "paramValue2");
        map.put("paramKey3", "paramValue3");

        app.addParams(mapParam).addHeaders(map);
        Request request = app.addHeader("authtoken", "fake@token").findApps().request();
        Assertions.assertTrue(request.isHttps());
        Assertions.assertEquals("GET", request.method());
        Assertions.assertEquals(5, request.headers().size());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertNull(request.body());
        Assertions.assertEquals("https://api.contentstack.io/manifests?search=paramValue&limit=10&target_type=stack&skip=3&sort=updated_at&order=asc", request.url().toString());
    }


    @Test
    void testAppHosting() {
        Request request = app.hosting("app_uid").fetchHosting().request();
        Assertions.assertTrue(request.isHttps());
        Assertions.assertEquals("GET", request.method());
        Assertions.assertEquals(1, request.headers().size());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertNull(request.body());
        Assertions.assertEquals("https://api.contentstack.io/manifests/app_uid/hosting", request.url().toString());
    }

    @Test
    void testAppOAuthUsingUid() {
        Request request = app.oauth("app_uid").fetchOauthConfiguration("").request();
        Assertions.assertTrue(request.isHttps());
        Assertions.assertEquals("GET", request.method());
        Assertions.assertEquals(1, request.headers().size());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertNull(request.body());
        Assertions.assertEquals("https://api.contentstack.io/manifests//oauth", request.url().toString());
    }


}
