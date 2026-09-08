# Spring Data + Spring Boot: The Complete Beginner's Reference Guide

## What This Guide Covers

When you use Spring Boot and add Spring Data to your project, you are actually
pulling in a carefully chosen, pre-tested bundle of several Spring Data
sub-libraries. This guide teaches you:

1. What Spring Data actually is (a family of modules, not one library)
2. What a "Release Train" is and why it exists
3. How to find which Release Train your Spring Boot version uses
4. How to find every module version inside that train
5. How to construct the documentation URL for any module
6. Where every piece of information lives, with exact URLs

---

## Part 1: Mental Model — What Is Spring Data?

Spring Data is NOT one library. It is an **umbrella project** — a family of
independent sub-libraries, each one designed to talk to a different kind of
database or data store.

```
The Spring Data Family:
┌───────────────────────────────────────────────────────────────┐
│                     Spring Data                               │
│                                                               │
│  spring-data-commons       ← shared foundation (always used)  │
│  spring-data-jpa           ← relational DBs via JPA/Hibernate │
│  spring-data-mongodb       ← MongoDB                          │
│  spring-data-redis         ← Redis                            │
│  spring-data-elasticsearch ← Elasticsearch                    │
│  spring-data-cassandra     ← Apache Cassandra                 │
│  spring-data-jdbc          ← relational DBs via plain JDBC    │
│  spring-data-neo4j         ← Neo4j graph database             │
│  spring-data-couchbase     ← Couchbase                        │
│  spring-data-ldap          ← LDAP directories                 │
│  spring-data-rest          ← exposes repos as REST endpoints  │
│  spring-data-envers        ← Hibernate Envers auditing        │
│  ... and a few more                                           │
└───────────────────────────────────────────────────────────────┘
```

Key facts:
- Each module has its OWN version number (e.g., `jpa` module=2.7.x, `mongodb` module=3.4.x)
- All modules share the same `spring-data-commons` as their foundation
- You only add the modules you actually need (e.g., only jpa, or only mongodb)
- `spring-data-commons` is always pulled in automatically as a dependency
  of whichever module you use; you never declare it yourself

---

## Part 2: What Is a "Release Train"?

### The Problem It Solves

Each Spring Data module is developed and released somewhat independently.
If you use both `spring-data-jpa` and `spring-data-mongodb` in one project,
you need to know: which version of JPA works with which version of MongoDB?
They both depend on `spring-data-commons` — so they must use the same version
of it, or they will conflict.

This compatibility question — for every combination of every module — would be
a nightmare for users to figure out themselves.

### The Solution: Release Trains

A **Release Train** is a named, officially tested snapshot that says:

> "These specific versions of all Spring Data modules are confirmed to work
> together. Use these together and you will have no conflicts."

It is like a carefully curated playlist — every song (module) in the playlist
is guaranteed to play well with every other song.

### How Release Trains Are Named

Spring Data has gone through two naming eras:

**Era 1 — Famous computer scientist names (alphabetical order), up to ~2021:**

```
Arora → Babbage → Codd → Dijkstra → Evans → Fowler → Gosling
→ Hopper → Ingalls → Kay → Lovelace → Moore → Neumann → Ockham (2020.0)
→ Pascal (2021.0) → Q (2021.1) → Raj (2021.2)
```

Note: Starting from Ockham, the team added a CalVer number in parentheses.

**Era 2 — Calendar Versioning (CalVer) only, from 2022 onward:**

```
Format: YYYY.MINOR.PATCH
         ^^^^  ^^^^^  ^^^^^
         year  0,1,2… patch/maintenance number

Examples: 2022.0.x, 2023.0.x, 2023.1.x, 2024.0.x, 2024.1.x, 2025.0.x ...

Some still have a parenthesized codename:
  2022.0 (Turing), 2023.0 (Ullman), 2023.1 (Vaughan)
  2024.0 and later: no codename, just the number
```

The `.x` at the end is the patch number — it increments with each bugfix
release. For example, `2021.2.18` is the 18th patch of the `2021.2` train.

---

## Part 3: The Boot-to-Train Mapping

This is the master lookup table. The `spring-data-commons` version always
matches the Spring Boot version (from Boot 2.4 onward) — this is the most
useful pattern to remember.

```
┌──────────────────┬─────────────────────────────┬───────────────────────┐
│  Spring Boot     │  Spring Data Release Train  │  spring-data-commons  │
│  version         │  (name + CalVer)            │  version              │
├──────────────────┼─────────────────────────────┼───────────────────────┤
│  2.4.x           │  2020.0  (Ockham)           │  2.4.x                │
│  2.5.x           │  2021.0  (Pascal)           │  2.5.x                │
│  2.6.x           │  2021.1  (Q)                │  2.6.x                │
│  2.7.x  ← YOU    │  2021.2  (Raj)              │  2.7.x        ← YOU   │
│  3.0.x           │  2022.0  (Turing)           │  3.0.x                │
│  3.1.x           │  2023.0  (Ullman)           │  3.1.x                │
│  3.2.x           │  2023.1  (Vaughan)          │  3.2.x                │
│  3.3.x           │  2024.0                     │  3.3.x                │
│  3.4.x           │  2024.1                     │  3.4.x                │
│  3.5.x           │  2025.0                     │  3.5.x                │
└──────────────────┴─────────────────────────────┴───────────────────────┘
```

**The pattern to memorize:**
Spring Boot `X.Y.z` → `spring-data-commons` version is also `X.Y.z`
(From Boot 2.4 onward. Before that the numbers did not align like this.)

---

## Part 4: Module Versions Inside the 2021.2 (Raj) Train

This is the complete list of modules and their exact versions that ship with
Spring Boot 2.7.x (i.e., the `2021.2` train), patch version `.18`:

```
┌─────────────────────────────┬─────────────┐
│  Spring Data Module         │  Version    │
├─────────────────────────────┼─────────────┤
│  spring-data-commons        │  2.7.18     │
│  spring-data-jpa            │  2.7.18     │
│  spring-data-redis          │  2.7.18     │
│  spring-data-ldap           │  2.7.18     │
│  spring-data-envers         │  2.7.18     │
│  spring-data-keyvalue       │  2.7.18     │
│  spring-data-rest-core      │  3.7.18     │  ← note different major
│  spring-data-mongodb        │  3.4.18     │  ← note different major
│  spring-data-cassandra      │  3.4.18     │  ← note different major
│  spring-data-elasticsearch  │  4.4.18     │  ← note different major
│  spring-data-couchbase      │  4.4.18     │  ← note different major
│  spring-data-neo4j          │  6.3.18     │  ← note different major
│  spring-data-jdbc           │  2.4.18     │  ← note different minor
│  spring-data-r2dbc          │  1.5.18     │  ← note different major
└─────────────────────────────┴─────────────┘
```

*Above table data captured from [docs.spring.io/spring-boot/docs/2.7.18/reference/html/dependency-versions.html](https://docs.spring.io/spring-boot/docs/2.7.18/reference/html/dependency-versions.html)*

<br>

**Why do some modules have different major/minor numbers?**

Each module was already at a certain version before joining a train. The patch
number (`.18` here) is always synchronized — it increments together for all
modules in a train. But the `major.minor` prefix of each module tracks that
module's own independent evolution history.

The `.18` being the same for all of them (i.e. for all of the Spring Data modules
under GroupId `org.springframework.data`) is what tells you they belong to the
same patch release of the same train. The prefix (2.7, 3.4, 4.4, etc.) is
just that module's own generational version.

---

## Part 5: The Step-by-Step Method to Find Everything

### STEP 1 — Go to the Spring Boot Dependency Versions Page (Managed Dependency Coordinates section)

**URL pattern (replace version with yours):**
```
https://docs.spring.io/spring-boot/docs/{BOOT-VERSION}/reference/html/dependency-versions.html
```

Or for newer Spring Boot version (i.e. 3.3.x onwards) documentations:
```
https://docs.spring.io/spring-boot/{BOOT-VERSION}/appendix/dependency-versions/coordinates.html
```

Example:
- For Spring Boot 2.7.18: \
[docs.spring.io/spring-boot/docs/2.7.18/reference/html/dependency-versions.html](https://docs.spring.io/spring-boot/docs/2.7.18/reference/html/dependency-versions.html)
- For Spring Boot 3.3.13 (For any 3.3.x, URL redirects to below): \
[docs.spring.io/spring-boot/3.3/appendix/dependency-versions/coordinates.html](https://docs.spring.io/spring-boot/3.3/appendix/dependency-versions/coordinates.html)
- For Spring Boot 3.4.13 (For any 3.4.x, URL redirects to below): \
[docs.spring.io/spring-boot/3.4/appendix/dependency-versions/coordinates.html](https://docs.spring.io/spring-boot/3.4/appendix/dependency-versions/coordinates.html)
- For Spring Boot 3.5.16 (For any 3.5.x, URL redirects to below): \
[docs.spring.io/spring-boot/3.5/appendix/dependency-versions/coordinates.html](https://docs.spring.io/spring-boot/3.5/appendix/dependency-versions/coordinates.html)
- For Spring Boot 4.0.8 (For any 4.0.x, URL redirects to below): \
[docs.spring.io/spring-boot/4.0/appendix/dependency-versions/coordinates.html](https://docs.spring.io/spring-boot/4.0/appendix/dependency-versions/coordinates.html)
- For Spring Boot 4.1.1 - i.e. Current Latest Stable Spring Boot version (For any 4.1.x, URL redirects to below): \
[docs.spring.io/spring-boot/appendix/dependency-versions/coordinates.html](https://docs.spring.io/spring-boot/appendix/dependency-versions/coordinates.html)


This page is the **single source of truth** for every library version that
Spring Boot manages. It is an appendix in the official Spring Boot docs.


### STEP 2 — Find Spring Data Module Versions on That Page

Use Ctrl+F (browser find) and search for these terms one at a time:

```
Search term           What it finds
─────────────────     ──────────────────────────────────────────────────────
spring-data-commons   The foundation module — its version = your key number
spring-data-jpa       The JPA module version
spring-data-mongodb   The MongoDB module version
spring-data-redis     The Redis module version
(etc.)                Search any module name you need
```

You will find rows in a table like:

```
Group ID                    │ Artifact ID          │ Version
────────────────────────────┼──────────────────────┼─────────
org.springframework.data    │ spring-data-commons  │ 2.7.18
org.springframework.data    │ spring-data-jpa      │ 2.7.18
org.springframework.data    │ spring-data-mongodb  │ 3.4.18
```

**Write down the version for each module you care about.**
The `spring-data-commons` version is the *most important* — it is the key that
unlocks the documentation URL pattern.


### STEP 3 — Build the Documentation URL

The URL pattern for any Spring Data module's Reference Documentation is:
```
https://docs.spring.io/spring-data/{MODULE}/docs/{VERSION}/reference/html/
```

The URL pattern for any Spring Data module's API (Javadoc) is:
```
https://docs.spring.io/spring-data/{MODULE}/docs/{VERSION}/api/
```

Replace `{MODULE}` with the module name (see table below) and `{VERSION}`
with the version you found in Step 2 for that specific module.

```
Module name in URL     │ Artifact ID
───────────────────────┼──────────────────────────
commons                │ spring-data-commons
jpa                    │ spring-data-jpa
mongodb                │ spring-data-mongodb
redis                  │ spring-data-redis
elasticsearch          │ spring-data-elasticsearch
cassandra              │ spring-data-cassandra
neo4j                  │ spring-data-neo4j
jdbc                   │ spring-data-jdbc
r2dbc                  │ spring-data-r2dbc
rest                   │ spring-data-rest
couchbase              │ spring-data-couchbase
ldap                   │ spring-data-ldap
envers                 │ spring-data-envers
```

### STEP 4 — Verify Using the Preface of the Docs You Just Opened

Every Spring Data module's reference documentation starts with a **Preface**
section. In it there is a compatibility table that looks like this:

```
Spring Data Release Train │ Spring Data JPA │ Spring Framework │ Spring Boot
──────────────────────────┼─────────────────┼──────────────────┼────────────
2021.2 (Raj)              │ 2.7.x           │ 5.3.x            │ 2.7.x
2021.1 (Q)                │ 2.6.x           │ 5.3.x            │ 2.6.x
2021.0 (Pascal)           │ 2.5.x           │ 5.3.x            │ 2.5.x
```

This table directly answers the question "which train name does my Boot use?"
without needing any external lookup. It is the most authoritative and
beginner-friendly source for this specific question.

---

## Part 6: Pre-Built URLs for Spring Boot 2.7.18

Save these. You do not need to repeat the steps above for your current project.

### Spring Data Modules - Reference Documentation (to read and learn from):


- Spring Data Commons 2.7.18: \
https://docs.spring.io/spring-data/commons/docs/2.7.18/reference/html/

- Spring Data JPA 2.7.18: \
https://docs.spring.io/spring-data/jpa/docs/2.7.18/reference/html/

- Spring Data MongoDB 3.4.18: \
https://docs.spring.io/spring-data/mongodb/docs/3.4.18/reference/html/

- Spring Data Redis 2.7.18: \
https://docs.spring.io/spring-data/redis/docs/2.7.18/reference/html/

- Spring Data Elasticsearch 4.4.18: \
https://docs.spring.io/spring-data/elasticsearch/docs/4.4.18/reference/html/

- Spring Data JDBC 2.4.18: \
https://docs.spring.io/spring-data/jdbc/docs/2.4.18/reference/html/

- Spring Data REST 3.7.18: \
https://docs.spring.io/spring-data/rest/docs/3.7.18/reference/html/


### Spring Data Modules - API / Javadoc (class-level reference, when you need method signatures):


- Spring Data Commons 2.7.18: \
https://docs.spring.io/spring-data/commons/docs/2.7.18/api/

- Spring Data JPA 2.7.18: \
https://docs.spring.io/spring-data/jpa/docs/2.7.18/api/

- Spring Data MongoDB 3.4.18: \
https://docs.spring.io/spring-data/mongodb/docs/3.4.18/api/


(Same pattern for any other module.)

### Spring Boot Dependency Versions Page for 2.7.18:

[docs.spring.io/spring-boot/docs/2.7.18/reference/html/dependency-versions.html](https://docs.spring.io/spring-boot/docs/2.7.18/reference/html/dependency-versions.html)


### Docs Links for newer versions of Spring Data Modules (Updated Documentation URLs Structure)

First, find the version numbers of the Spring Data Modules that get installed with the version of
Spring Boot you're working on, then proceed.

#### **Example, For Spring Boot 3.5.16:**

Take the version numbers of the Spring Data Modules (i.e. Group ID = `org.springframework.data`; and
Artifact ID = `spring-data-*`) from the below link (as mentioned previously):

[docs.spring.io/spring-boot/3.5/appendix/dependency-versions/coordinates.html](https://docs.spring.io/spring-boot/3.5/appendix/dependency-versions/coordinates.html)

| Group ID | Artifact ID | Version |
| --- | --- | --- |
| `org.springframework.data` | `spring-data-commons` | `3.5.13` |
| `org.springframework.data` | `spring-data-elasticsearch` | `5.5.13` |
| `org.springframework.data` | `spring-data-jpa` | `3.5.13` |
| `org.springframework.data` | `spring-data-mongodb` | `4.5.13` |
| `org.springframework.data` | `spring-data-neo4j` | `7.5.13` |
| `org.springframework.data` | `spring-data-redis` | `3.5.13` |

*Table of Spring Data Modules versions installed with Spring Boot 3.5.16*
<br>

Module documentation URL Pattern:
- Reference:
  ```
  https://docs.spring.io/spring-data/{module}/reference/{moduleShortVersion}/
  ```
- API / Javadoc:
  ```
  https://docs.spring.io/spring-data/{module}/reference/{moduleShortVersion}/api/java/index.html
  ```


And, the corresponding documentation links for these (notice the URL pattern):
- `spring-data-commons` | `3.5.13`
  - Module version shortened (`major.minor`): `3.5`
  - Reference: [docs.spring.io/spring-data/commons/reference/3.5/](https://docs.spring.io/spring-data/commons/reference/3.5/)
  - Javadoc: [docs.spring.io/spring-data/commons/reference/3.5/api/java/index.html](https://docs.spring.io/spring-data/commons/reference/3.5/api/java/index.html)
- `spring-data-elasticsearch` | `5.5.13`
  - Module version shortened (`major.minor`): `5.5`
  - Reference: [docs.spring.io/spring-data/elasticsearch/reference/5.5/](https://docs.spring.io/spring-data/elasticsearch/reference/5.5/)
  - Javadoc: [docs.spring.io/spring-data/elasticsearch/reference/5.5/api/java/index.html](https://docs.spring.io/spring-data/elasticsearch/reference/5.5/api/java/index.html)
- `spring-data-jpa` | `3.5.13`
  - Module version shortened (`major.minor`): `3.5`
  - Reference: [docs.spring.io/spring-data/jpa/reference/3.5/](https://docs.spring.io/spring-data/jpa/reference/3.5/)
  - Javadoc: [docs.spring.io/spring-data/jpa/reference/3.5/api/java/index.html](https://docs.spring.io/spring-data/jpa/reference/3.5/api/java/index.html)
- `spring-data-mongodb` | `4.5.13`
  - Module version shortened (`major.minor`): `4.5`
  - Reference: [docs.spring.io/spring-data/mongodb/reference/4.5/](https://docs.spring.io/spring-data/mongodb/reference/4.5/)
  - Javadoc: [docs.spring.io/spring-data/mongodb/reference/4.5/api/java/index.html](https://docs.spring.io/spring-data/mongodb/reference/4.5/api/java/index.html)
- `spring-data-neo4j` | `7.5.13`
  - Module version shortened (`major.minor`): `7.5`
  - Reference: [docs.spring.io/spring-data/neo4j/reference/7.5/](https://docs.spring.io/spring-data/neo4j/reference/7.5/)
  - Javadoc: [docs.spring.io/spring-data/neo4j/reference/7.5/api/java/index.html](https://docs.spring.io/spring-data/neo4j/reference/7.5/api/java/index.html)
- `spring-data-redis` | `3.5.13`
  - Module version shortened (`major.minor`): `3.5`
  - Reference: [docs.spring.io/spring-data/redis/reference/3.5/](https://docs.spring.io/spring-data/redis/reference/3.5/)
  - Javadoc: [docs.spring.io/spring-data/redis/reference/3.5/api/java/index.html](https://docs.spring.io/spring-data/redis/reference/3.5/api/java/index.html)


---

## Part 7: How to Find the Release Train Name (Three Methods)

You will sometimes see tutorials, blog posts, or Stack Overflow answers that
say things like "this feature was added in Ockham" or "use the Raj train".
Here is how to match that train name to your Spring Boot version.

### Method A — The Preface Table (Recommended, Fastest)

1. Open any Spring Data module's reference docs for your version.
   (Use the URLs from Part 6 above.)
2. Navigate to the Preface section (it is the very first section).
3. Read the compatibility table — it lists the train name, the module version,
   the Spring Framework version, and the Spring Boot version, all together.
4. Find the row where the Spring Boot column matches yours (e.g., 2.7.x).
5. The first column gives you the train name: **2021.2 (Raj)**.

No GitHub needed. No wiki needed. The answer is in the docs you are reading.

### Method B — The spring-data-bom GitHub Releases Page

URL:
```
https://github.com/spring-projects/spring-data-bom/releases
```

This page lists every release train bundle ever published.

How to use it:
1. Press Ctrl+F and search for your Spring Data Commons version (e.g., `2.7.18`)
2. You will find a release entry labelled `2021.2.18`
3. That entry lists every module and its version in that bundle
4. The train name is the CalVer prefix: `2021.2` → **Release Train 2021.2 (Raj)**

This page is the ground truth that Spring Boot itself references internally.

### Method C — The spring-data-commons GitHub Wiki (Harder, Less Direct)

URL:
```
https://github.com/spring-projects/spring-data-commons/wiki
```

**Warning:** This wiki does NOT directly show "Spring Boot 2.7.x → train Raj".
The wiki's "Release Trains" page shows a matrix of module versions per train,
but does NOT mention Spring Boot versions at all. It is only useful AFTER you
already know your train name and want to explore historical module version
numbers.

For finding which train matches your Boot version, Methods A and B above are
far better. Only use this wiki for exploring old historical information or
reading release notes after you already know which train you are on.

---

## Part 8: The Hierarchy of These Resources

Understanding what each resource is FOR helps you know when to use which one.

```
┌──────────────────────────────────────────────────────────────────────────┐
│           WHAT YOU WANT            │  WHERE TO GO                        │
├────────────────────────────────────┼─────────────────────────────────────┤
│ Exact version of any library used  │ Spring Boot Dependency Versions     │
│ by your Spring Boot version        │ appendix page (Part 5, Step 1)      │
├────────────────────────────────────┼─────────────────────────────────────┤
│ Which Release Train name your      │ The Preface of any SD module's      │
│ Spring Boot version uses           │ reference docs (Method A, Part 7)   │
├────────────────────────────────────┼─────────────────────────────────────┤
│ All module versions in one train   │ spring-data-bom GitHub releases     │
│ bundle (ground truth)              │ (Method B, Part 7)                  │
├────────────────────────────────────┼─────────────────────────────────────┤
│ Reference docs to LEARN FROM       │ docs.spring.io/spring-data/{module} │
│ (concepts, how-to, configuration)  │ /docs/{version}/reference/html/     │
├────────────────────────────────────┼─────────────────────────────────────┤
│ API / Javadoc for class and method │ docs.spring.io/spring-data/{module} │
│ signatures                         │ /docs/{version}/api/                │
├────────────────────────────────────┼─────────────────────────────────────┤
│ Release train names and history    │ spring-data-commons GitHub Wiki     │
│ (exploration only, not for lookup) │ (Part 7, Method C — use last)       │
└────────────────────────────────────┴─────────────────────────────────────┘
```

---

## Part 9: The 30-Second Cheat Sheet for Any Future Project

When you start a new project with a different Spring Boot version, do this:

```
Step 1 — Open:
  https://docs.spring.io/spring-boot/docs/{YOUR-BOOT-VERSION}/reference/html/dependency-versions.html

Step 2 — Ctrl+F → search "spring-data-commons" → note its version number
          Also search any other SD module you are using → note those versions

Step 3 — Open your SD module's docs:
  https://docs.spring.io/spring-data/{module}/docs/{version}/reference/html/

Step 4 — Read the Preface table to confirm the train name if you need it

Done.
```

---

## Part 10: Do Other Spring Projects Also Use Release Trains?

Release trains exist only when a project is an **umbrella of multiple
sub-projects** that all need to be kept version-compatible with each other.

```
┌──────────────────────────┬────────────────┬────────────────────────────┐
│  Spring Project          │  Uses Release  │  Notes                     │
│                          │  Trains?       │                            │
├──────────────────────────┼────────────────┼────────────────────────────┤
│  Spring Data             │  YES           │  This entire guide.        │
│                          │                │  Named: Ockham, Raj, etc.  │
├──────────────────────────┼────────────────┼────────────────────────────┤
│  Spring Cloud            │  YES           │  London Tube station names │
│                          │                │  Angel→Brixton→...→Hoxton  │
│                          │                │  then CalVer: 2020.0, etc. │
│                          │                │  Codenames: Ilford, Leyton │
├──────────────────────────┼────────────────┼────────────────────────────┤
│  Spring Security         │  NO            │  Single library, own       │
│                          │                │  straightforward version   │
│                          │                │  (e.g., 5.7.x for Boot     │
│                          │                │  2.7.x)                    │
├──────────────────────────┼────────────────┼────────────────────────────┤
│  Spring Batch            │  NO            │  Single library            │
├──────────────────────────┼────────────────┼────────────────────────────┤
│  Spring Integration      │  NO            │  Single library            │
├──────────────────────────┼────────────────┼────────────────────────────┤
│  Spring AMQP             │  NO            │  Single library            │
├──────────────────────────┼────────────────┼────────────────────────────┤
│  Spring HATEOAS          │  NO            │  Single library            │
└──────────────────────────┴────────────────┴────────────────────────────┘
```

**Rule of thumb:** If a Spring project has multiple sub-modules that need to
interoperate (like Spring Data's JPA + MongoDB + Redis all sharing commons),
it probably uses release trains. If it is a single focused library
(like Spring Security), it does not.

For all single-library projects, the same Boot dependency-versions appendix
page (Step 1 above) still gives you their exact version — you just Ctrl+F for
the artifact name instead.

---

*End of Guide*
