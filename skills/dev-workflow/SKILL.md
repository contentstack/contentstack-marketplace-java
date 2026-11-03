---
name: dev-workflow
description: Use when branching, running CI locally, building, testing, or releasing this Maven project.
---

# Dev workflow – Contentstack Marketplace Java SDK

## When to use

- Setting up the repo locally or onboarding
- Matching what CI runs before opening a PR
- Cutting releases or understanding deploy steps in `pom.xml`

## Instructions

### Repository and default branch

- Remote: `https://github.com/contentstack/contentstack-marketplace-java` (see `pom.xml` `<scm>`).
- CI in `.github/workflows/maven.yml` runs on pushes and pull requests targeting `main`: checkout, JDK 11 (Temurin), `mvn -B package --file pom.xml`.

### Local commands

- Full package (compile, test, package): `mvn -B package --file pom.xml` — aligns with CI.
- Tests only: `mvn test`.
- Coverage HTML after tests: `target/site/jacoco/index.html` (JaCoCo is bound to the `test` phase).

### Maven release / publishing

- `pom.xml` documents release flow (e.g. `mvn clean deploy`, Central Publishing plugin, GPG signing in `verify`). Coordinate with maintainers before changing version or release profiles.

### PR expectations

- Ensure `mvn -B package` passes; note that Surefire may be configured with `testFailureIgnore` — still fix failing tests before merging when possible.

## References

- [../testing/SKILL.md](../testing/SKILL.md) — test env and credentials
- [../java/SKILL.md](../java/SKILL.md) — compiler and layout
- Official: [Maven](https://maven.apache.org/guides/), [GitHub Actions Java + Maven](https://docs.github.com/en/actions/automating-builds-and-tests/building-and-testing-java-with-maven)
