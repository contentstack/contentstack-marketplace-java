---
name: java
description: Use when navigating Java package layout, compiler settings, or Lombok usage in this repository.
---

# Java layout and conventions – Contentstack Marketplace Java SDK

## When to use

- Adding new classes under `src/main/java`
- Aligning with Java 8 language level and Maven compiler settings
- Using Lombok consistently with existing types

## Instructions

### Layout

- Root packages: **`com.contentstack.sdk`** (`Region`, `Client`, `BaseImplementation`) and **`com.contentstack.sdk.marketplace`** (Marketplace API and subpackages: `apps`, `auths`, `installations`, `login`, `request`).
- Tests mirror main packages under `src/test/java/com/contentstack/sdk/...`.
- `package-info.java` exists in several packages for Javadoc cohesion — add or update when expanding a package’s public story.

### Compiler and language level

- **`maven-compiler-plugin`** sets `source`/`target` **8** with Lombok on the annotation processor path; `-Xlint` style args are configured — fix new warnings when practical.
- `pom.xml` also declares `maven.compiler.source/target` properties (9) while the plugin overrides to 8 — treat **the plugin’s Java 8** as authoritative for emitted bytecode unless maintainers unify properties.

### Lombok and dependencies

- **Lombok** is `provided` — use for DTOs/services only where the rest of the module already does; avoid mixing styles in one feature area.
- **JetBrains annotations** (`@NotNull`, etc.) appear on public APIs — keep null contracts explicit for new parameters.

## References

- [../contentstack-marketplace-sdk/SKILL.md](../contentstack-marketplace-sdk/SKILL.md) — public API map
- [../testing/SKILL.md](../testing/SKILL.md) — test code layout
- [../dev-workflow/SKILL.md](../dev-workflow/SKILL.md) — `mvn` commands
