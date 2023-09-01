package com.contentstack.sdk.marketplace.installations.location;

import com.contentstack.sdk.TestClient;
import okhttp3.Request;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

@Tag("unit")
class LocationTests {

    static Location location;
    final static String ORG_UID = TestClient.ORGANIZATION_UID;

    @BeforeAll
    static void loadBeforeAll() {
        location = TestClient.getMarketplace()
                .installation(ORG_UID).location()
                .addParam("param1", "value1")
                .addHeader("authtoken", ORG_UID);
    }


    @Test
    void testFindAuthorizedApp() throws IllegalAccessException {
        Request request = location.fetchConfigurationLocation().request();
        Assertions.assertEquals("/installations/"+ORG_UID+"/locations/configuration", request.url().encodedPath());
        Assertions.assertEquals("GET", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(4, request.url().pathSegments().size());
        Assertions.assertEquals("installations", request.url().pathSegments().get(0));
        Assertions.assertEquals(ORG_UID, request.url().pathSegments().get(1));
        Assertions.assertEquals("locations", request.url().pathSegments().get(2));
        Assertions.assertEquals("configuration", request.url().pathSegments().get(3));
        Assertions.assertNull(request.body());
        Assertions.assertNotNull(request.url().encodedQuery());
        Assertions.assertEquals("param1=value1", request.url().query());
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

        location.addParams(mapParam).addHeaders(map);
        Request request = location.addHeader("authtoken", "fake@token").fetchConfigurationLocation().request();
        Assertions.assertTrue(request.isHttps());
        Assertions.assertEquals("GET", request.method());
        Assertions.assertEquals(5, request.headers().size());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertNull(request.body());
        Assertions.assertEquals("https://api.contentstack.io/installations/orgId999999999/locations/configuration?param1=value1", request.url().toString());
    }


}
