<!--
## Sync Impact Report

Version change: [uninitialized] → 1.0.0 (initial)
Modified principles: N/A (initial creation)
Added sections: Core Principles, Technology Standards, Development Workflow, Governance
Removed sections: N/A
Templates requiring updates:
  - .specify/templates/plan-template.md ✅ Constitution Check section present (generic, no updates needed)
  - .specify/templates/spec-template.md ✅ No constitution references
  - .specify/templates/tasks-template.md ✅ No constitution references
Follow-up TODOs: None
-->

# Spring Cloud Begin Constitution

## Core Principles

### I. Multi-Module Architecture

Every service is an independent Maven module with its own POM, coordinates, and lifecycle; modules must be buildable and testable in isolation; shared code lives in `cloud-service-common` or `cloud-service-api` only.

### II. Spring Cloud Alibaba First

When choosing between Spring Cloud native and Spring Cloud Alibaba implementations, prefer Spring Cloud Alibaba for distributed scenarios (Nacos for config/discovery, Sentinel for circuit breaking, Seata for distributed transactions); this is a learning project focused on Alibaba ecosystem.

### III. Service Registry and Discovery

All services MUST register with Eureka or Nacos; client-side discovery uses Ribbon or Spring Cloud LoadBalancer; server-side routing uses Spring Cloud Gateway; no service may operate without a registration mechanism.

### IV. Configuration Management

Externalized configuration is mandatory; use Spring Cloud Config or Nacos Config for all services; configuration files MUST be stored in version control (Config Server) or Nacos namespace; no hardcoded URLs, ports, or credentials in source code.

### V. Fault Tolerance and Resilience

Circuit breakers are mandatory for all inter-service communication; use Hystrix or Sentinel for timeout, fallback, and bulkheading; every Feign client MUST have a fallback implementation; no service may depend on another service without resilience patterns.

## Technology Standards

### Tech Stack Requirements

- **Language**: Java 8 (source/target compatibility)
- **Build**: Maven multi-module with parent POM for dependency management
- **Spring Boot**: 2.2.1.RELEASE (managed via parent)
- **Spring Cloud**: Hoxton.RELEASE (compatible with Spring Boot 2.2.x)
- **Spring Cloud Alibaba**: 2.2.0.RELEASE (Nacos, Sentinel, Seata)
- **Database**: MySQL 5.1.47 with Druid connection pool
- **ORM**: MyBatis via mybatis-spring-boot-starter 1.3.0
- **Utilities**: Lombok 1.16.18, Commons Lang3 3.7, Commons Collections4 4.3
- **Testing**: JUnit 4.12
- **Logging**: Log4j 1.2.17

### Module Naming Convention

Modules follow the pattern: `cloud[-alibaba]-[component-type]-[name]-[port]`; port suffix is mandatory for all service modules to avoid conflicts; `cloud-service-common` and `cloud-service-api` are the only modules without port numbers.

## Development Workflow

### Build and Test

All modules MUST pass `mvn clean compile` and `mvn test` before merge; parent POM manages dependency versions to prevent version conflicts; modules MUST declare all dependencies explicitly — no transitive-only dependencies without explicit declaration.

### Code Style

Lombok is the designated code generation tool; avoid handwritten getter/setter/constructor boilerplate; use `@Data`, `@Builder`, `@NoArgsConstructor`, `@AllArgsConstructor` consistently; all services use the same Spring Boot Maven plugin configuration with `fork=true` and `addResources=true`.

### Service Port Allocation

Each service module MUST use a unique server port; ports follow domain conventions: Eureka 7001-7003, Config 11000-11003, Payment 8001-8103, Consumer 80-81, Gateway 10000, Sentinel 9101-9102; port conflicts are a blocking bug.

## Governance

This constitution supersedes all other development practices within this repository. Amendments require documenting the rationale, updating all affected modules or patterns, and committing the updated constitution alongside the change. All new services and modules must comply with these principles. Complexity beyond what these principles allow must be justified in the implementation plan.

**Version**: 1.0.0 | **Ratified**: 2026-06-08 | **Last Amended**: 2026-06-08
