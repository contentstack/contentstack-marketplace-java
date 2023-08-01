# Marketplace SDK ReadMe

The `Marketplace` class provides a software development kit (SDK) to interact with the Contentstack Marketplace API. It facilitates the management of apps, authorizations, and installations within your Contentstack organization.

## Prerequisites

Before using the `Marketplace` SDK, ensure the following:

1. Java JDK v1.8 or above should be installed in your machine
2. You have a valid Contentstack account with access to the Contentstack Marketplace.
2. You have obtained the necessary credentials, including the organization UID, to interact with the Marketplace API.

## Installation

To use the `Marketplace` SDK in your Java project, follow these steps:

1. Download the `contentstack-java` SDK and its dependencies from the Contentstack Maven repository. Add the following dependencies to your project's `pom.xml` file:

```xml

<dependencies>
    <!-- Contentstack SDK -->
    <dependency>
        <groupId>com.contentstack.sdk</groupId>
        <artifactId>marketplace</artifactId>
        <!-- Replace 'x.x.x' with the latest version available -->
        <version>x.x.x</version>
    </dependency>
</dependencies>
```

2. Save the `pom.xml` file.

3. Ensure you have internet connectivity to download the SDK and its dependencies from the central Maven repository.

## How to Use

1. Import the required packages:

```java
import com.contentstack.sdk.marketplace.Marketplace;
import com.contentstack.sdk.marketplace.apps.App;
import com.contentstack.sdk.marketplace.auths.Auth;
import com.contentstack.sdk.marketplace.installations.Installation;
import com.contentstack.sdk.marketplace.request.AppRequest;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
```

2. Initialize the `Marketplace` class with your organization UID:

```java
// Replace 'YOUR_ORG_ID' with your Contentstack organization UID
String organizationUid = "YOUR_ORG_ID";
Marketplace marketplace = new Marketplace(organizationUid);
```

3. Use the various methods available in the `Marketplace` class to interact with the Marketplace API:

### Retrieve an instance of the `App` class:

```java
// Get an instance of the App class
App app = marketplace.app();

// Alternatively, you can pass the app UID to retrieve a specific app
String appUid = "APP_UID";
App specificApp = marketplace.app(appUid);
```

### Retrieve an instance of the `Auth` class:

```java
// Get an instance of the Auth class
Auth auth = marketplace.authorizations();
```

### Retrieve an instance of the `Installation` class:

```java
// Get an instance of the Installation class
Installation installation = marketplace.installation();

// Alternatively, you can pass the installation ID to retrieve a specific installation
String installationId = "INSTALLATION_ID";
Installation specificInstallation = marketplace.installation(installationId);
```

### Create an instance of the `AppRequest` class:

```java
// Get an instance of the AppRequest class
AppRequest appRequest = marketplace.request();
```

**Note:** Replace `'YOUR_ORG_ID'`, `'APP_UID'`, and `'INSTALLATION_ID'` with actual values from your Contentstack organization.

## License

This project is distributed under the terms of the [LICENSE](LICENSE) file.

**Note:** The `Marketplace` class is an SDK that allows you to interact with the Contentstack Marketplace API using Java code. Please refer to the official Contentstack documentation for the Marketplace API to understand the various endpoints and functionalities available for apps, authorizations, and installations.