---
name: contentstack-marketplace-sdk
description: Use when changing or documenting the public Marketplace SDK API, entry points, or domain modules.
---

# Marketplace SDK API – Contentstack Marketplace Java SDK

## When to use

- Adding or changing `com.contentstack.sdk.marketplace.*` public types
- Documenting how consumers construct `Marketplace` and access apps, auths, installations, requests
- Deciding what belongs in this library vs. other Contentstack Java SDKs

## Instructions

### Entry point

- **`com.contentstack.sdk.marketplace.Marketplace`** — constructed via **`Marketplace.Builder`**, which requires a non-null, non-empty organization UID (`Constants.ERROR_NO_ORGANIZATION_UID` on violation).
- Optional builder knobs: `host`, `region` (`com.contentstack.sdk.Region`), `authtoken`, and login-related methods where implemented.
- Host resolution: if `region` is set, the client prefixes the region to the host segment (see `Marketplace` constructor); empty host falls back to `Constants.DEFAULT_HOST`.

### Domain surfaces (high level)

- **`App`** / `AppService` — marketplace apps (including hosting, OAuth subpackages).
- **`Auth`** — authorizations.
- **`Installation`** — installations (including `location`, `webhook` subpackages).
- **`AppRequest`** — app request flows via `RequestService`.

### Integration boundaries

- Shared HTTP/Retrofit wiring lives in **`com.contentstack.sdk.Client`**; do not duplicate base URL or converter setup on each feature without a design reason.
- JSON: Gson via Retrofit; `org.json.simple` appears where legacy JSON types are needed — keep new code consistent with existing patterns in the same module.

### Versioning

- Library version is the Maven **`artifactId` `marketplace`** version in `pom.xml`; align changelog and consumer docs (`README.md`) when bumping.

## References

- [../framework-and-http/SKILL.md](../framework-and-http/SKILL.md) — Retrofit client and HTTP stack
- [../java/SKILL.md](../java/SKILL.md) — packages and Lombok
- End-user overview: repository root `README.md`
