# Contentstack Marketplace SDK Using Java

The **Marketplace** class provides a software development kit (SDK) to interact with the Contentstack Marketplace API. It facilitates the management of apps, authorizations, and installations within your Contentstack organization.

## Prerequisites

Before using the **Marketplace** SDK, ensure the following:

1. Java JDK 1.8 or above should be installed on your machine.
2. You have a valid Contentstack account with access to the Contentstack Marketplace.
3. You have obtained the necessary credentials like **organization UID** and **authtoken**, to interact with the Marketplace API.

## Installation

To use the Marketplace SDK in your Java project, follow these steps:

1. Download the contentstack-java SDK and its dependencies from the Contentstack Maven repository. Add the following dependencies to your project's pom.xml file:

```xml  
<!-- https://mvnrepository.com/artifact/com.contentstack.sdk/marketplace -->  
<dependencies>  
 <dependency> <groupId>com.contentstack.sdk</groupId> 
     <artifactId>marketplace</artifactId> 
     <version>x.x.x</version> <!-- Replace 'x.x.x' with the latest version available --> 
 </dependency>
</dependencies>  


```  

2. Save the pom.xml file.

3. Ensure you have internet connectivity to download the SDK and its dependencies from the central Maven repository.

## How to Use

1. Initialize the Marketplace class with your organization UID:

```java  
import com.contentstack.sdk.marketplace.Marketplace;
Marketplace marketplace = new Marketplace  
        .Builder(TestClient.ORGANIZATION_UID)  // Required
        .host(HOST)  // Optional
        .authtoken("test")  // Optional
        .login("test@email.com", "*********")  // Optional
        .region(Region.AZURE_EU)  // Optional
        .build();  
```  

2. Use the various methods available in the Marketplace class to interact with the Marketplace API:

### Retrieve an instance of the App class:
Get an instance of the App class
```java  
import com.contentstack.sdk.marketplace.apps.App; 
App app = marketplace.app();  
// Alternatively, you can pass the app UID to retrieve a specific app   
App specificApp = marketplace.app("APP_UID");  
```  

### Retrieve an instance of the Auth class:

```java
import com.contentstack.sdk.marketplace.auths.Auth;  
// Get an instance of the Auth class  
Auth auth = marketplace.authorizations();  
```  

### Retrieve an instance of the Installation class:
Get an instance of the Installation class
```java
import com.contentstack.sdk.marketplace.installations.Installation; 
Installation installation = marketplace.installation();  
OR 
Installation specificInstallation = marketplace.installation("INSTALLATION_ID");  
```  

### Create an instance of the AppRequest class:
Get an instance of the AppRequest class
```java
import com.contentstack.sdk.marketplace.request.AppRequest;  
AppRequest appRequest = marketplace.request();  
```   

## License

The MIT License (MIT)

Copyright © 2012-2023 [Contentstack](https://www.contentstack.com/). All Rights Reserved

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software. THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES, OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT, OR OTHERWISE, ARISING FROM, OUT OF, OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
