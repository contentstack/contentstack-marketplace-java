# Contentstack Marketplace Java SDK – Agent guide

*Universal entry point* for contributors and AI agents. Detailed conventions live in **skills/*/SKILL.md**.

## What this repo is

| Field | Detail |
| --- | --- |
| *Name:* | [contentstack/contentstack-marketplace-java](https://github.com/contentstack/contentstack-marketplace-java) |
| *Purpose:* | Java SDK for the Contentstack Marketplace API: apps, authorizations, installations, and related resources (Retrofit-based HTTP client). |
| *Out of scope (if any):* | Not a general Contentstack Delivery or Management SDK; Marketplace API only. No Kotlin-first API surface (Kotlin stdlib is a transitive dependency). |

## Tech stack (at a glance)

| Area | Details |
| --- | --- |
| Language | Java 8 (compiler `source`/`target` in `pom.xml`; CI uses JDK 11). Lombok for generated code. |
| Build | Maven — `pom.xml`; artifact `com.contentstack.sdk:marketplace`. |
| Tests | JUnit 5 (and Vintage for legacy tests) — `src/test/java/**`. |
| Lint / coverage | Compiler warnings (`-Xlint` in `maven-compiler-plugin`); JaCoCo (`target/site/jacoco/index.html` after tests). Optional JetBrains Qodana JVM — `qodana.yaml`. |
| Other | HTTP: Retrofit 2, OkHttp, Gson. `README.md` for end-user install and usage. |

## Commands (quick reference)

| Command Type | Command |
| --- | --- |
| Build | `mvn -B package --file pom.xml` |
| Test | `mvn test` |
| Lint | No separate CLI lint target; use compiler warnings during `mvn compile` / `mvn package`, JaCoCo report after `mvn test`, or Qodana locally/CI per `qodana.yaml`. |

CI: GitHub Actions — `.github/workflows/maven.yml` (`mvn -B package --file pom.xml` on push/PR to `main`).

## Where the documentation lives: skills

| Skill | Path | What it covers |
| --- | --- | --- |
| Dev workflow | [skills/dev-workflow/SKILL.md](skills/dev-workflow/SKILL.md) | Branches, CI, build/test, release notes |
| Marketplace SDK API | [skills/contentstack-marketplace-sdk/SKILL.md](skills/contentstack-marketplace-sdk/SKILL.md) | Public API, `Marketplace` builder, domains (apps, auths, installations) |
| Java layout & conventions | [skills/java/SKILL.md](skills/java/SKILL.md) | Package layout, Java/Lombok usage in this repo |
| Testing | [skills/testing/SKILL.md](skills/testing/SKILL.md) | Test layout, `TestClient`, env / credentials |
| Code review | [skills/code-review/SKILL.md](skills/code-review/SKILL.md) | PR checklist for this SDK |
| Framework & HTTP | [skills/framework-and-http/SKILL.md](skills/framework-and-http/SKILL.md) | Retrofit `Client`, Gson, base URLs, extension points |

An index with "when to use" hints is in [skills/README.md](skills/README.md).

## Using Cursor (optional)

If you use *Cursor*, [.cursor/rules/README.md](.cursor/rules/README.md) only points to *AGENTS.md*—same docs as everyone else.
