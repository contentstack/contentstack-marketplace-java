package com.contentstack.sdk.marketplace.installations.webhook;

import com.contentstack.sdk.TestClient;
import okhttp3.Request;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

@Tag("unit")
class WebhookTests {

    private static Webhook webhook;
    static String AUTHTOKEN = TestClient.AUTHTOKEN;
    static String WEBHOOK_ID = TestClient.ORGANIZATION_UID;


    @BeforeAll
    static void setUp() {
        webhook = TestClient.getMarketplace().installation("installation_id").webhook(WEBHOOK_ID);
    }

    @Test
    void testFindExecutionLogs() throws IllegalAccessException {
        webhook.addHeader("authtoken", AUTHTOKEN);
        webhook.addParam("sort", "asc");
        webhook.addParam("order", "order");
        webhook.addParam("limit", "10");
        webhook.addParam("skip", "5");

        Request request = webhook.findExecutionLogs().request();
        Assertions.assertEquals("/installations/installation_id/webhooks/" + WEBHOOK_ID + "/executions", request.url().encodedPath());
        Assertions.assertEquals("GET", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(5, request.url().pathSegments().size());
        Assertions.assertEquals("installations", request.url().pathSegments().get(0));
        Assertions.assertEquals("installation_id", request.url().pathSegments().get(1));
        Assertions.assertEquals("webhooks", request.url().pathSegments().get(2));
        Assertions.assertNull(request.body());
        Assertions.assertNotNull(request.url().encodedQuery());
        Assertions.assertEquals("limit=10&skip=5&sort=asc&order=order", request.url().query());
    }


    @Test
    void testFetchExecutionLogs() throws IllegalAccessException {
        webhook.addHeader("authtoken", AUTHTOKEN);
        webhook.addParam("sort", "asc");
        webhook.addParam("order", "order");
        webhook.addParam("limit", "10");
        webhook.addParam("skip", "5");

        Request request = webhook.fetchExecutionLogs(WEBHOOK_ID).request();
        Assertions.assertEquals("/installations/installation_id/webhooks/" + WEBHOOK_ID + "/executions/" + WEBHOOK_ID, request.url().encodedPath());
        Assertions.assertEquals("GET", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(6, request.url().pathSegments().size());
        Assertions.assertEquals("installations", request.url().pathSegments().get(0));
        Assertions.assertEquals("installation_id", request.url().pathSegments().get(1));
        Assertions.assertEquals("webhooks", request.url().pathSegments().get(2));
        Assertions.assertNull(request.body());
        Assertions.assertNotNull(request.url().encodedQuery());
        Assertions.assertEquals("limit=10&skip=5&sort=asc&order=order", request.url().query());
    }


    @Test
    void testRetryExecution() throws IllegalAccessException {
        webhook.addHeader("authtoken", AUTHTOKEN);
        webhook.addParam("sort", "asc");
        webhook.addParam("order", "order");
        webhook.addParam("limit", "10");
        webhook.addParam("skip", "5");
        Request request = webhook.retryExecution("execution_id").request();
        Assertions.assertEquals("/installations/installation_id/webhooks/" + WEBHOOK_ID + "/executions/execution_id/retry", request.url().encodedPath());
        Assertions.assertEquals("POST", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(7, request.url().pathSegments().size());
        Assertions.assertEquals("installations", request.url().pathSegments().get(0));
        Assertions.assertEquals("installation_id", request.url().pathSegments().get(1));
        Assertions.assertEquals("webhooks", request.url().pathSegments().get(2));
        Assertions.assertNotNull(request.body());
        Assertions.assertNotNull(request.url().encodedQuery());
        Assertions.assertEquals("limit=10&skip=5&sort=asc&order=order", request.url().query());
    }

    @Test
    void testParamsAndHeaders() throws IllegalAccessException {
        HashMap<String, String> map = new HashMap<>();
        map.put("paramKey1", "paramValue1");
        map.put("paramKey2", "paramValue2");
        map.put("paramKey3", "paramValue3");

        HashMap<String, Object> mapParam = new HashMap<>();
        map.put("paramKey1", "paramValue1");
        map.put("paramKey2", "paramValue2");
        map.put("paramKey3", "paramValue3");

        webhook.addParams(mapParam).addHeaders(map);
        Request request = webhook.addHeader("authtoken", "fake@token").findExecutionLogs().request();
        Assertions.assertTrue(request.isHttps());
        Assertions.assertEquals("GET", request.method());
        Assertions.assertEquals(5, request.headers().size());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertNull(request.body());
        Assertions.assertEquals("https://api.contentstack.io/installations/installation_id/webhooks/orgId999999999/executions?limit=10&skip=5&sort=asc&order=order", request.url().toString());
    }


}
