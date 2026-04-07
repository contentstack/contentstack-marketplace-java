---
name: code-review
description: Use when reviewing pull requests or preparing changes for review in this SDK repository.
---

# Code review – Contentstack Marketplace Java SDK

## When to use

- Reviewing a PR for correctness, API safety, and consistency
- Self-review before requesting reviewers

## Instructions

### Blocker

- Breaking changes to public **`Marketplace`** or domain types without version/changelog strategy and maintainer agreement.
- Committed secrets, real org tokens, or `.env` files with live credentials.
- New HTTP clients that bypass **`com.contentstack.sdk.Client`** without rationale (duplicated base URLs, converters).

### Major

- Missing or misleading Javadoc on new public methods/classes.
- Tests absent for non-trivial new behavior (happy path at minimum).
- Null/empty handling inconsistent with existing `Builder` and service patterns.
- Compiler warnings introduced without justification.

### Minor

- Naming or package placement inconsistent with `com.contentstack.sdk.marketplace` structure.
- Typos in user-facing Javadoc or `README.md` when behavior changes.

### Quick checklist

- [ ] `mvn -B package` succeeds locally.
- [ ] Public API changes reflected in `README.md` or Javadoc where users look first.
- [ ] Tests updated; integration tests respect env-based credentials ([../testing/SKILL.md](../testing/SKILL.md)).

## References

- [../contentstack-marketplace-sdk/SKILL.md](../contentstack-marketplace-sdk/SKILL.md)
- [../testing/SKILL.md](../testing/SKILL.md)
