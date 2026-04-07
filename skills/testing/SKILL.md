---
name: testing
description: Use when writing or running tests, configuring TestClient, or handling secrets and coverage.
---

# Testing – Contentstack Marketplace Java SDK

## When to use

- Adding unit or integration-style tests under `src/test/java`
- Using **`TestClient`** helpers and environment variables
- Interpreting Surefire / JaCoCo output

## Instructions

### Layout and naming

- Tests live under **`src/test/java`**, mirroring `com.contentstack.sdk.marketplace.*` (e.g. `MarketplaceTest`, `AppUnitTests`, region-specific suites).
- JUnit **Jupiter** is the primary stack; **Vintage** is on the classpath for older tests — prefer Jupiter for new classes.

### TestClient and credentials

- **`com.contentstack.sdk.TestClient`** loads **`io.github.cdimascio.dotenv.Dotenv`** and reads optional env vars: `organizationUid`, `authToken`, `userId`, with placeholder defaults when unset.
- For real API runs, supply a `.env` file or environment variables locally; **never commit secrets** — keep tokens out of git and PR descriptions.
- Helpers like `getMarketplace()`, `getMarketplaceEU()`, etc., centralize host `api.contentstack.io` and region variants.

### Running tests and coverage

- Run: **`mvn test`** (see [../dev-workflow/SKILL.md](../dev-workflow/SKILL.md)).
- **`pom.xml`** configures Surefire with **`testFailureIgnore` true** — CI still runs `package`; treat red tests as something to fix before merge when possible.
- JaCoCo report: **`target/site/jacoco/index.html`** after `mvn test`.

## References

- [../dev-workflow/SKILL.md](../dev-workflow/SKILL.md) — CI parity
- [../contentstack-marketplace-sdk/SKILL.md](../contentstack-marketplace-sdk/SKILL.md) — API under test
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
