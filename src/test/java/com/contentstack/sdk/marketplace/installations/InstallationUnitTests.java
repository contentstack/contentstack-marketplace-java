package com.contentstack.sdk.marketplace.installations;

import com.contentstack.sdk.TestClient;
import okhttp3.Request;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@Tag("unit")
class InstallationUnitTests {

    private static Installation installation;
    static String AUTHTOKEN = TestClient.AUTHTOKEN;
    private static final String MISSING_ORG_ID = "Organisation ID is missing.";


    @BeforeAll
    static void setUp() {
        installation = TestClient.getMarketplace().installation();
        installation = TestClient.getMarketplace().installation(AUTHTOKEN);
    }

    @Test
    void testFindInstalledApps() {
        installation.addHeader("authtoken", AUTHTOKEN);
        installation.addParam("sort", "asc");
        installation.addParam("order", "order");
        installation.addParam("limit", "10");
        installation.addParam("skip", "5");

        Request request = installation.findInstalledApps().request();
        Assertions.assertEquals("/installations/view/apps", request.url().encodedPath());
        Assertions.assertEquals("GET", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(3, request.url().pathSegments().size());
        Assertions.assertEquals("installations", request.url().pathSegments().get(0));
        Assertions.assertEquals("view", request.url().pathSegments().get(1));
        Assertions.assertEquals("apps", request.url().pathSegments().get(2));
        Assertions.assertNull(request.body());
        Assertions.assertNotNull(request.url().encodedQuery());
        Assertions.assertEquals("limit=10&skip=5&sort=asc&order=order", request.url().query());
    }


    @Test
    void testFindInstallations() {
        installation.addHeader("authtoken", AUTHTOKEN);
        installation.addParam("sort", "asc");
        installation.addParam("order", "order");
        installation.addParam("limit", "10");
        installation.addParam("skip", "5");

        Request request = installation.findInstallations().request();
        Assertions.assertEquals("/installations", request.url().encodedPath());
        Assertions.assertEquals("GET", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(1, request.url().pathSegments().size());
        Assertions.assertEquals("installations", request.url().pathSegments().get(0));
        Assertions.assertNull(request.body());
        Assertions.assertNotNull(request.url().encodedQuery());
        Assertions.assertEquals("limit=10&skip=5&sort=asc&order=order", request.url().query());
    }


    @Test
    void testFetchInstallation() {
        installation.addHeader("authtoken", AUTHTOKEN);
        installation.addParam("sort", "asc");
        installation.addParam("order", "order");
        installation.addParam("limit", "10");
        installation.addParam("skip", "5");

        Request request = installation.fetchInstallation().request();
        Assertions.assertEquals("/installations/" + AUTHTOKEN, request.url().encodedPath());
        Assertions.assertEquals("GET", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(2, request.url().pathSegments().size());
        Assertions.assertEquals("installations", request.url().pathSegments().get(0));
        Assertions.assertEquals(AUTHTOKEN, request.url().pathSegments().get(1));
        Assertions.assertNull(request.body());
        Assertions.assertNotNull(request.url().encodedQuery());
        Assertions.assertEquals("limit=10&skip=5&sort=asc&order=order", request.url().query());
    }

    @Test
    void testFetchInstallationData() {
        installation.addHeader("authtoken", AUTHTOKEN);
        installation.addParam("sort", "asc");
        installation.addParam("order", "order");
        installation.addParam("limit", "10");
        installation.addParam("skip", "5");

        Request request = installation.fetchInstallationData().request();
        Assertions.assertEquals("/installations/" + AUTHTOKEN + "/installationData", request.url().encodedPath());
        Assertions.assertEquals("GET", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(3, request.url().pathSegments().size());
        Assertions.assertEquals("installations", request.url().pathSegments().get(0));
        Assertions.assertEquals(AUTHTOKEN, request.url().pathSegments().get(1));
        Assertions.assertNull(request.body());
        Assertions.assertNotNull(request.url().encodedQuery());
        Assertions.assertEquals("limit=10&skip=5&sort=asc&order=order", request.url().query());
    }


    @Test
    void testUpdateInstallation() {
        installation.addHeader("authtoken", AUTHTOKEN);
        installation.addParam("sort", "asc");
        installation.addParam("order", "order");
        installation.addParam("limit", "10");
        installation.addParam("skip", "5");

        JSONObject body = new JSONObject();
        body.put("config", "SomeObject");
        body.put("server_config", "SomeObject");
        body.put("webhooks", "Array of Objects with webhook_uid and channels");
        body.put("ui_locations", "ui_locations");

        Request request = installation.updateInstallation(body).request();
        Assertions.assertEquals("/installations/" + AUTHTOKEN, request.url().encodedPath());
        Assertions.assertEquals("PUT", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(2, request.url().pathSegments().size());
        Assertions.assertEquals("installations", request.url().pathSegments().get(0));
        Assertions.assertEquals(AUTHTOKEN, request.url().pathSegments().get(1));
        Assertions.assertNotNull(request.body());
        Assertions.assertNotNull(request.url().encodedQuery());
        Assertions.assertEquals("limit=10&skip=5&sort=asc&order=order", request.url().query());
    }


    @Test
    void testUpdateInstallationWithOnlyRequestBody() {
        installation.addHeader("authtoken", AUTHTOKEN);
        installation.addParam("sort", "asc");
        installation.addParam("order", "order");
        installation.addParam("limit", "10");
        installation.addParam("skip", "5");

        JSONObject body = new JSONObject();
        body.put("config", "SomeObject");
        body.put("server_config", "SomeObject");
        body.put("webhooks", "Array of Objects with webhook_uid and channels");
        body.put("ui_locations", "ui_locations");

        Request request = installation.updateInstallation(body).request();
        Assertions.assertEquals("/installations/" + AUTHTOKEN, request.url().encodedPath());
        Assertions.assertEquals("PUT", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(2, request.url().pathSegments().size());
        Assertions.assertEquals("installations", request.url().pathSegments().get(0));
        Assertions.assertEquals(AUTHTOKEN, request.url().pathSegments().get(1));
        Assertions.assertNotNull(request.body());
        Assertions.assertNotNull(request.url().encodedQuery());
        Assertions.assertEquals("limit=10&skip=5&sort=asc&order=order", request.url().query());
    }


    @Test
    void testFindInstalledUsers() {
        installation.addHeader("authtoken", AUTHTOKEN);
        installation.addParam("sort", "asc");
        installation.addParam("order", "order");
        installation.addParam("limit", "10");
        installation.addParam("skip", "5");

        Request request = installation.findInstalledUsers().request();
        Assertions.assertEquals("/installations/view/users", request.url().encodedPath());
        Assertions.assertEquals("GET", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(3, request.url().pathSegments().size());
        Assertions.assertEquals("installations", request.url().pathSegments().get(0));
        Assertions.assertEquals("view", request.url().pathSegments().get(1));
        Assertions.assertNull(request.body());
        Assertions.assertNotNull(request.url().encodedQuery());
        Assertions.assertEquals("limit=10&skip=5&sort=asc&order=order", request.url().query());
    }


    @Test
    void testFindInstalledStacks() {
        installation.addHeader("authtoken", AUTHTOKEN);
        installation.addParam("sort", "asc");
        installation.addParam("order", "order");
        installation.addParam("limit", "10");
        installation.addParam("skip", "5");

        Request request = installation.findInstalledStacks().request();
        Assertions.assertEquals("/installations/view/stacks", request.url().encodedPath());
        Assertions.assertEquals("GET", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(3, request.url().pathSegments().size());
        Assertions.assertEquals("installations", request.url().pathSegments().get(0));
        Assertions.assertEquals("view", request.url().pathSegments().get(1));
        Assertions.assertEquals("stacks", request.url().pathSegments().get(2));
        Assertions.assertNull(request.body());
        Assertions.assertNotNull(request.url().encodedQuery());
        Assertions.assertEquals("limit=10&skip=5&sort=asc&order=order", request.url().query());
    }


    @Test
    void testUninstall() {
        installation.addHeader("authtoken", AUTHTOKEN);
        installation.addParam("sort", "asc");
        installation.addParam("order", "order");
        installation.addParam("limit", "10");
        installation.addParam("skip", "5");

        Request request = installation.uninstall().request();
        Assertions.assertEquals("/installations/" + AUTHTOKEN, request.url().encodedPath());
        Assertions.assertEquals("DELETE", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(2, request.url().pathSegments().size());
        Assertions.assertEquals("installations", request.url().pathSegments().get(0));
        Assertions.assertEquals(AUTHTOKEN, request.url().pathSegments().get(1));
        Assertions.assertNull(request.body());
        Assertions.assertNull(request.url().encodedQuery());
        Assertions.assertNull(request.url().query());
    }


    @Test
    void testFetchAppConfiguration() {
        installation.addHeader("authtoken", AUTHTOKEN);
        installation.addParam("sort", "asc");
        installation.addParam("order", "order");
        installation.addParam("limit", "10");
        installation.addParam("skip", "5");

        Request request = installation.fetchAppConfiguration().request();
        Assertions.assertEquals("/installations/" + AUTHTOKEN + "/configuration", request.url().encodedPath());
        Assertions.assertEquals("GET", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(3, request.url().pathSegments().size());
        Assertions.assertEquals("installations", request.url().pathSegments().get(0));
        Assertions.assertEquals(AUTHTOKEN, request.url().pathSegments().get(1));
        Assertions.assertNull(request.body());
        Assertions.assertNotNull(request.url().encodedQuery());
        Assertions.assertEquals("limit=10&skip=5&sort=asc&order=order", request.url().query());
    }


    @Test
    void testFetchServerConfiguration() {
        installation.addHeader("authtoken", AUTHTOKEN);
        installation.addParam("sort", "asc");
        installation.addParam("order", "order");
        installation.addParam("limit", "10");
        installation.addParam("skip", "5");

        Request request = installation.fetchServerConfiguration().request();
        Assertions.assertEquals("/installations/" + AUTHTOKEN + "/server-configuration", request.url().encodedPath());
        Assertions.assertEquals("GET", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(3, request.url().pathSegments().size());
        Assertions.assertEquals("installations", request.url().pathSegments().get(0));
        Assertions.assertEquals(AUTHTOKEN, request.url().pathSegments().get(1));
        Assertions.assertNull(request.body());
        Assertions.assertNotNull(request.url().encodedQuery());
        Assertions.assertEquals("limit=10&skip=5&sort=asc&order=order", request.url().query());
    }


    @Test
    void testUpdateServerConfiguration() {
        installation.addHeader("authtoken", AUTHTOKEN);
        installation.addParam("sort", "asc");
        installation.addParam("order", "order");
        installation.addParam("limit", "10");
        installation.addParam("skip", "5");

        JSONObject body = new JSONObject();
        body.put("config", "SomeObject");
        body.put("server_config", "SomeObject");
        body.put("webhooks", "Array of Objects with webhook_uid and channels");
        body.put("ui_locations", "ui_locations");

        Request request = installation.updateServerConfiguration(body).request();
        Assertions.assertEquals("/installations/" + AUTHTOKEN + "/server-configuration", request.url().encodedPath());
        Assertions.assertEquals("PUT", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(3, request.url().pathSegments().size());
        Assertions.assertEquals("installations", request.url().pathSegments().get(0));
        Assertions.assertEquals(AUTHTOKEN, request.url().pathSegments().get(1));
        Assertions.assertNotNull(request.body());
        Assertions.assertNotNull(request.url().encodedQuery());
        Assertions.assertEquals("limit=10&skip=5&sort=asc&order=order", request.url().query());
    }


    @Test
    void testUpdateServerConfigurationWithInstallationId() {
        installation.addHeader("authtoken", AUTHTOKEN);
        installation.addParam("sort", "asc");
        installation.addParam("order", "order");
        installation.addParam("limit", "10");
        installation.addParam("skip", "5");

        JSONObject body = new JSONObject();
        body.put("config", "SomeObject");
        body.put("server_config", "SomeObject");
        body.put("webhooks", "Array of Objects with webhook_uid and channels");
        body.put("ui_locations", "ui_locations");

        Request request = installation.updateServerConfiguration(body).request();
        Assertions.assertEquals("/installations/" + AUTHTOKEN + "/server-configuration", request.url().encodedPath());
        Assertions.assertEquals("PUT", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(3, request.url().pathSegments().size());
        Assertions.assertEquals("installations", request.url().pathSegments().get(0));
        Assertions.assertEquals(AUTHTOKEN, request.url().pathSegments().get(1));
        Assertions.assertNotNull(request.body());
        Assertions.assertNotNull(request.url().encodedQuery());
        Assertions.assertEquals("limit=10&skip=5&sort=asc&order=order", request.url().query());
    }


    @Test
    void testUpdateStackConfiguration() {
        installation.addHeader("authtoken", AUTHTOKEN);
        installation.addParam("sort", "asc");
        installation.addParam("order", "order");
        installation.addParam("limit", "10");
        installation.addParam("skip", "5");

        JSONObject body = new JSONObject();
        body.put("config", "SomeObject");
        body.put("server_config", "SomeObject");
        body.put("webhooks", "Array of Objects with webhook_uid and channels");
        body.put("ui_locations", "ui_locations");

        Request request = installation.updateStackConfiguration(body).request();
        Assertions.assertEquals("/installations/" + AUTHTOKEN + "/configuration", request.url().encodedPath());
        Assertions.assertEquals("PUT", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(3, request.url().pathSegments().size());
        Assertions.assertEquals("installations", request.url().pathSegments().get(0));
        Assertions.assertEquals(AUTHTOKEN, request.url().pathSegments().get(1));
        Assertions.assertNotNull(request.body());
        Assertions.assertNotNull(request.url().encodedQuery());
        Assertions.assertEquals("limit=10&skip=5&sort=asc&order=order", request.url().query());
    }

    @Test
    void testUpdateStackConfigurationWithoutDirectAuthtoken() {
        installation.addHeader("authtoken", AUTHTOKEN);
        installation.addParam("sort", "asc");
        installation.addParam("order", "order");
        installation.addParam("limit", "10");
        installation.addParam("skip", "5");

        JSONObject body = new JSONObject();
        body.put("config", "SomeObject");
        body.put("server_config", "SomeObject");
        body.put("webhooks", "Array of Objects with webhook_uid and channels");
        body.put("ui_locations", "ui_locations");

        Request request = installation.updateStackConfiguration(body).request();
        Assertions.assertEquals("/installations/" + AUTHTOKEN + "/configuration", request.url().encodedPath());
        Assertions.assertEquals("PUT", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(3, request.url().pathSegments().size());
        Assertions.assertEquals("installations", request.url().pathSegments().get(0));
        Assertions.assertEquals(AUTHTOKEN, request.url().pathSegments().get(1));
        Assertions.assertNotNull(request.body());
        Assertions.assertNotNull(request.url().encodedQuery());
        Assertions.assertEquals("limit=10&skip=5&sort=asc&order=order", request.url().query());
    }


    @Test
    void testCreateInstallationToken() {
        installation.addHeader("authtoken", AUTHTOKEN);
        installation.addParam("sort", "asc");
        installation.addParam("order", "order");
        installation.addParam("limit", "10");
        installation.addParam("skip", "5");

        JSONObject body = new JSONObject();
        body.put("config", "SomeObject");
        body.put("server_config", "SomeObject");
        body.put("webhooks", "Array of Objects with webhook_uid and channels");
        body.put("ui_locations", "ui_locations");

        Request request = installation.createInstallationToken().request();
        Assertions.assertEquals("/installations/" + AUTHTOKEN + "/token", request.url().encodedPath());
        Assertions.assertEquals("POST", request.method());
        Assertions.assertEquals(2, request.headers().names().size());
        Assertions.assertTrue(request.url().isHttps());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertEquals(3, request.url().pathSegments().size());
        Assertions.assertEquals("installations", request.url().pathSegments().get(0));
        Assertions.assertEquals(AUTHTOKEN, request.url().pathSegments().get(1));
        Assertions.assertNotNull(request.body());
        Assertions.assertNotNull(request.url().encodedQuery());
        Assertions.assertEquals("limit=10&skip=5&sort=asc&order=order", request.url().query());
    }

    @Test
    void testParamsAndHeaders() {
        HashMap<String, String> map = new HashMap<>();
        map.put("paramKey1", "paramValue1");
        map.put("paramKey2", "paramValue2");
        map.put("paramKey3", "paramValue3");

        HashMap<String, Object> mapParam = new HashMap<>();
        map.put("paramKey1", "paramValue1");
        map.put("paramKey2", "paramValue2");
        map.put("paramKey3", "paramValue3");

        installation.addParams(mapParam).addHeaders(map);
        Request request = installation.addHeader("authtoken", "fake@token").findInstallations().request();
        Assertions.assertTrue(request.isHttps());
        Assertions.assertEquals("GET", request.method());
        Assertions.assertEquals(5, request.headers().size());
        Assertions.assertEquals("api.contentstack.io", request.url().host());
        Assertions.assertNull(request.body());
        Assertions.assertEquals("https://api.contentstack.io/installations?limit=10&skip=5&sort=asc&order=order", request.url().toString());
    }

    @Test
    void testValidateInstallationIdWithValidInput() {
        // Arrange
        String validInstallationId = "12345";

        // Act and Assert
        Assertions.assertDoesNotThrow(() -> installation.validateInstallationId(validInstallationId));
    }

    @Test
    void testValidateInstallationIdWithNullInput() {
        // Arrange
        String nullInstallationId = null;

        // Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> installation.validateInstallationId(nullInstallationId));

        // Assert the exception message
        Assertions.assertEquals("installationId is requirement", exception.getMessage());
    }

    @Test
    void testValidateInstallationIdWithEmptyInput() {
        // Arrange
        String emptyInstallationId = "";

        // Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> installation.validateInstallationId(emptyInstallationId));

        // Assert the exception message
        Assertions.assertEquals("installationId is requirement", exception.getMessage());
    }

    @Test
    void testCheckOrganisationIdWithValidInput() {
        // Arrange
        String validOrgId = "org123";

        // Act and Assert
        Assertions.assertDoesNotThrow(() -> installation.checkOrganisationId(validOrgId));
    }

    @Test
    void testCheckOrganisationIdWithEmptyInput() {
        // Arrange
        String emptyOrgId = "";

        // Act and Assert
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> installation.checkOrganisationId(emptyOrgId));

        // Assert the exception message
        Assertions.assertEquals("organization uid is required", exception.getMessage());
    }


}
