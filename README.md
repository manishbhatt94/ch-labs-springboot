# Spring Boot (SB) Learning Playground

This repository contains numerous Spring Boot (SB) projects in my Eclipse Spring Tools Suite (STS 5)
workspace, created while learning SB.

I have picked the latest SB version in the 2.x release line, which is **Spring Boot version 2.7.18**
&mdash; which is what I will be using in the projects in this repository.

Notes on choice of SB 2.7.18 (and not 3.x or the latest 4.x):
- I want to stick to using Java 8, and SB 2.7.x are the last SB versions that support Java 8.
  Starting SB 3.x, the minimum supported JDK is JDK 17.
- Spring Boot 2.7.x supports Spring Framework 5.3.x.
- Spring Boot 3.0 requires Java 17 or later. Java 8 is no longer supported. It also requires
  Spring Framework 6.0.
- With SB 2.7.18, I get to continue using the `javax.*` package namespace, instead of having to
  use the `jakarta.*` package namespace.
- Note that, from Spring Boot 4.0.0, some modularization changes have been made as noted in:
  - [www.danvega.dev/blog/spring-boot-4-modularization](https://www.danvega.dev/blog/spring-boot-4-modularization)
  - [spring.io/blog/2025/10/28/modularizing-spring-boot](https://spring.io/blog/2025/10/28/modularizing-spring-boot)
- This has some effects, including below starter names changes:
  - Up until Spring Boot (SB) 3.x, the **web** SB starter is called `spring-boot-starter-web`
    which is the name we'll therefore also use in SB 2.7.18.
  - Starting SB 4.0.0, this starter has been renamed to `spring-boot-starter-webmvc` - and there
    didn't exist any starter of this name in SB 1.x, 2.x, or 3.x releases.


## Spring Boot Documentation Links

- Index of Spring Boot documentations pages (upto version 3.2.12): \
  [docs.spring.io/spring-boot/docs/](https://docs.spring.io/spring-boot/docs/)
- Spring Boot 2.7.18 documentation:
  - Index of 2.7.18 docs (select PDF / HTML / HTML Single / Javadocs): \
    [docs.spring.io/spring-boot/docs/2.7.18/](https://docs.spring.io/spring-boot/docs/2.7.18/)
  - 2.7.18 HTML Docs (Table of Contents): \
    [docs.spring.io/spring-boot/docs/2.7.18/reference/html/](https://docs.spring.io/spring-boot/docs/2.7.18/reference/html/)
- Spring Boot 3.2.12 documentation: \
  [docs.spring.io/spring-boot/docs/3.2.12/reference/html/](https://docs.spring.io/spring-boot/docs/3.2.12/reference/html/)
- Spring Boot 3.3 (3.3.13) documentation: \
  [docs.spring.io/spring-boot/3.3/index.html](https://docs.spring.io/spring-boot/3.3/index.html)
- Spring Boot 3.4 (3.4.13) documentation: \
  [docs.spring.io/spring-boot/3.4/index.html](https://docs.spring.io/spring-boot/3.4/index.html)
- Spring Boot 3.5 (3.5.16) documentation: \
  [docs.spring.io/spring-boot/3.5/index.html](https://docs.spring.io/spring-boot/3.5/index.html)
- Spring Boot 4.0 (4.0.8) documentation: \
  [docs.spring.io/spring-boot/4.0/index.html](https://docs.spring.io/spring-boot/4.0/index.html)
- Spring Boot **Latest Version** 4.1 (4.1.1 - as of Sept. 7th 2026) documentation: \
  [docs.spring.io/spring-boot/index.html](https://docs.spring.io/spring-boot/index.html)


## Notes

- Understand Spring Data Modules Versions compatibility with a Spring Boot version \
  [spring-data-modules-versions-notes.md](./spring-data-modules-versions-notes.md)

