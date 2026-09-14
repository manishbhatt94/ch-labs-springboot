# Spring Boot 2.7.18 + JSP – Quick Revision Notes

## 1. Does Spring Boot support JSP out of the box?

No.

- `spring-boot-starter-web` brings embedded Tomcat.
- Embedded Tomcat **does not** include the JSP engine.
- Thymeleaf has a dedicated starter. JSP does not.
- You must add extra dependencies yourself if you want to use JSP.

---

## 2. What is Jasper?

Jasper is Tomcat's **JSP engine / compiler**.

It does two main jobs:
1. Translates a `.jsp` file into Java servlet source code.
2. Compiles that source into a `.class` file (using Eclipse JDT by default).

The main class is `org.apache.jasper.servlet.JspServlet`.

---

## 3. Jasper in Standalone Tomcat vs Embedded Tomcat

| Type                          | Jasper included? | Notes |
|-------------------------------|------------------|-------|
| Full / Standalone Tomcat      | Yes              | Comes with the server installation |
| Embedded Tomcat (Spring Boot) | No               | Intentionally left out to keep the footprint small |

Because of this, in a Spring Boot project you must explicitly add the Jasper dependency.

---

## 4. Correct Maven dependency for Jasper (Spring Boot 2.7.18)

```xml
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
</dependency>
```

### Important points

- Use the **embed** version (`tomcat-embed-jasper`), not `org.apache.tomcat:tomcat-jasper`.
- Do not write a `<version>` tag in your `pom.xml`. Spring Boot manages it.
- Spring Boot 2.7.18 uses Tomcat **9.0.83**, so `tomcat-embed-jasper` also resolves to **9.0.83**.

### Why not "tomcat-jasper"?

`tomcat-jasper` is meant for a full Tomcat installation. Using it with Spring Boot's embedded
Tomcat can cause classpath conflicts.

---

## 5. JSTL dependency

JSTL (JSP Standard Tag Library) is needed for the common tags (`c:forEach`, `fmt:formatDate`, etc.).

```xml
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>jstl</artifactId>
</dependency>
```

- Again, **no version** needed.
- Spring Boot 2.7.18 manages it to version **1.2** (the classic `javax.*` implementation).
- This is the correct artifact for Spring Boot 2.x + Java 8.

---

## 6. How Spring Boot decides the versions

Spring Boot uses a BOM (`spring-boot-dependencies`).

- Tomcat-related artifacts are controlled by the property `tomcat.version` → **9.0.83** in Spring Boot 2.7.18.
- JSTL is controlled by the property `jstl.version` → **1.2**.

When you use `spring-boot-starter-parent`, these versions are applied automatically if you omit `<version>`
when you specify the `<dependency>` in your `pom.xml` file.

You can verify the exact versions in:

- The Managed Dependency Coordinates page for 2.7.18
- Or directly in the `spring-boot-dependencies-2.7.18.pom`

---

## 7. Full Tomcat vs Embedded Tomcat (quick summary)

### Full / Standalone Tomcat

- You install it as a separate server.
- You deploy WAR files into it.
- Jasper, default servlet, etc. are already present.

### Embedded Tomcat

- Tomcat libraries run *inside* your application.
- Spring Boot starts it for you when you run `java -jar ...`.
- No separate Tomcat installation needed.
- Jasper is optional → you must add `tomcat-embed-jasper` if you need JSP.

---

## 8. Practical checklist for a simple Spring Boot + JSP project (2.7.18)

- Use packaging `war` (more reliable for JSP).
- Add the two dependencies above (`tomcat-embed-jasper` + `jstl`).
- Put JSP files under `src/main/webapp/WEB-INF/...`
- Configure the view resolver:
  ```properties
  spring.mvc.view.prefix=/WEB-INF/views/
  spring.mvc.view.suffix=.jsp
  ```
- Never hard-code the versions of `tomcat-embed-jasper` or `jstl` — let Spring Boot
  manage them.

---

## Key takeaway

- Embedded Tomcat ≠ Full Tomcat.
- Jasper is missing by default → add `tomcat-embed-jasper`.
- JSTL is also not included → add `javax.servlet:jstl`.
- Both versions are managed by Spring Boot 2.7.18 (9.0.83 and 1.2 respectively).
