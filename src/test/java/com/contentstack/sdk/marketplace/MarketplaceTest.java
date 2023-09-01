package com.contentstack.sdk.marketplace;

import com.contentstack.sdk.Region;
import com.contentstack.sdk.TestClient;
import okhttp3.Request;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class MarketplaceTest {

    static Marketplace marketplace;
    static final String ORG_ID = TestClient.ORGANIZATION_UID;

    @BeforeAll
    static void setUp() {
        marketplace = new Marketplace.Builder(ORG_ID)
                .host("api.contentstack.io")
                .build();
    }


    @Test
    void testConstructorWithNullOrganizationUidAndWithValidHost() {
        // Arrange
        //String organizationUid = "nullOrganizationUid123";
        String organizationUid = null;
        String host = "developerhub-api.contentstack.com";
        assertThrows(NullPointerException.class, () -> new Marketplace.Builder(organizationUid)
                .host(host)
                .build());
    }

    @Test
    void testConstructorWithNullOrganizationUidAndWithBlankString() {
        // Arrange
        String organizationUid = "";
        String host = "example.com"; // Provide a valid host or default host for this test
        assertThrows(NullPointerException.class, () ->  new Marketplace.Builder(organizationUid)
                .host(host)
                .build());
    }

    @Test
    void testConstructorWithNullOrganizationUid() {
        // Arrange
        String organizationUid = "";
        assertThrows(NullPointerException.class, () ->  new Marketplace.Builder(organizationUid)
                .build());
    }

    @Test
    void testConstructorWithNullOrganizationUidNullCheck() {
        // Arrange
        String organizationUid = null;
        assertThrows(NullPointerException.class, () -> new Marketplace.Builder(organizationUid)
                .build());
    }

    @Test
    void testConstructorWithEmptyOrganizationUid() {
        // Arrange
        String organizationUid = "";
        String host = "example.com"; // Provide a valid host or default host for this test
        assertThrows(NullPointerException.class, () -> new Marketplace.Builder(organizationUid)
                .host(host)
                .build());
    }

    @Test
    void testConstructorWithValidInputs() {
        // Arrange
        String organizationUid = "org123";
        String host = "example.com"; // Provide a valid host or default host for this test
        // Act
        Marketplace marketplace = new Marketplace.Builder(organizationUid)
                .host(host)
                .build();
        // Assert
        Assertions.assertEquals(organizationUid, marketplace.orgId);
    }

    @Test
    void testCreateRequest() {
        Request request = marketplace.app().findApps().request();
        Assertions.assertTrue(request.isHttps());
        Assertions.assertEquals("GET", request.method());
        Assertions.assertEquals(1, request.headers().size());
    }


    @Test
    void testRegion() {
        Marketplace marketplace = new Marketplace.Builder("organizationId")
                .host("api.contentstack.com").region(Region.AZURE_NA)
                .build();
        Assertions.assertNotNull(marketplace);
    }
}
