---
name: framework-and-http
description: Use when changing Retrofit/OkHttp setup, Gson serialization, or HTTP behavior for the Marketplace client.
---

# Framework and HTTP – Contentstack Marketplace Java SDK

## When to use

- Editing **`com.contentstack.sdk.Client`** or how `Marketplace` obtains **`Retrofit`**
- Adding interceptors, converters, or base URL behavior
- Debugging API calls built with **Retrofit** + **Gson**

## Instructions

### Retrofit singleton

- **`Client.getInstance(String host)`** lazily creates one **`Retrofit`** per JVM: the **first** `host` wins; later calls pass the parameter but do not recreate the client. Multiple `Marketplace` instances with different hosts in one process can mis-route requests unless this is addressed in `Client`.

### Base URL and transport

- **`createRetrofitInstance`** builds **`https://{host}/`** and attaches **`GsonConverterFactory.create()`** — new endpoints should use Retrofit interfaces consistent with existing `*Service` classes under `marketplace`.
- **OkHttp** is a direct dependency (version in `pom.xml`) — configure timeouts, interceptors, or auth headers in one place when extending the stack.

### JSON

- Gson is the Retrofit converter; **`org.json.simple`** is used where historical code requires it — follow the dominant pattern in the package you touch.

### Errors and responses

- Services typically use **`retrofit2.Call`** / **`Response`** — preserve existing error-handling conventions when adding calls (see `Marketplace` and service classes for patterns).

## References

- [../contentstack-marketplace-sdk/SKILL.md](../contentstack-marketplace-sdk/SKILL.md) — domain entry points
- [Retrofit](https://square.github.io/retrofit/), [OkHttp](https://square.github.io/okhttp/)
