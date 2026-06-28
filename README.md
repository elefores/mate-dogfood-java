# mate-dogfood-java

A small, intentionally outdated **Java** app used as a dogfooding fixture for
[MATE (Keep Up)](https://github.com/elefores). It gives keepup a realistic
target to run against in CI.

## The app

A minimal Spring Boot app: a `Customer` model with Bean Validation constraints, a
`CustomerController` REST endpoint, and a JUnit 5 test.

## Intentionally outdated dependencies

`pom.xml` pins everything a few versions behind current:

| Dependency | Pinned | Why it matters |
|------------|--------|----------------|
| `spring-boot-starter-web` / `spring-boot-starter-validation` | `2.7.18` | **Breaking gap.** Spring Boot 3 moves `javax.*` → `jakarta.*`. `Customer.java` and `CustomerController.java` use `javax.validation`, so the upgrade must rewrite those imports. |
| `jackson-databind` | `2.13.5` | Behind the current 2.17.x line. |
| `junit-jupiter` | `5.9.3` | Behind 5.10.x (ignored in `kup.toml`). |

Versions are declared explicitly on each `<dependency>` (no parent BOM) so keepup
detects the gaps directly. This makes it exercise the **AI code-upgrade path**,
not just a version bump.

## keepup config

See [`kup.toml`](kup.toml): it includes the `java/kotlin` language, scopes to
`pom.xml`, ignores the test framework, sets grouping thresholds, and selects the
Claude Code agent.

## CI

[`.github/workflows/keepup.yml`](.github/workflows/keepup.yml) runs keepup on a
weekly schedule (and on demand). Set these repository secrets for it to run:

- `KUP_LICENSE_KEY` — signed keepup license key
- `CLAUDE_CODE_OAUTH_TOKEN` — Claude Code agent token
- `ACCESS_TOKEN` — GitHub token used to push branches and open PRs
