# Spring Boot - Interview Questions

## 1. Advantages of Spring Boot over Spring
- **Auto-Configuration** - No manual XML config
- **Embedded Server** (Tomcat/Jetty/Undertow) - No external server needed
- **Spring Boot Starters** - Pre-packaged dependencies
- **Production-ready** features (Actuator - health, metrics)
- **Minimal boilerplate** setup
- Designed for **Microservices**

## 2. Dependency Injection (DI)
Spring container creates objects and injects dependencies automatically.

**Types:**
- **Constructor Injection** (recommended) - via constructor
- **Setter Injection** - via setter methods
- **Field Injection** - via `@Autowired` on field (not recommended)

## 3. Inversion of Control (IoC)
Object creation is controlled by **Spring Container** instead of the developer.
- Container manages object lifecycle using XML config or annotations
- `ApplicationContext` loads and manages all beans

## 4. @Autowired
Auto-injects Spring-managed beans. Matches by type, then by name.

## 5. Bean Scopes in Spring
| Scope | Description |
|-------|-------------|
| **singleton** (default) | One instance per Spring container |
| **prototype** | New instance every time requested |
| **request** | One per HTTP request (web) |
| **session** | One per HTTP session (web) |
| **application** | One per ServletContext |

## 6. Spring Boot Application Configuration File
- `application.properties` or `application.yml`
- Profile-specific: `application-dev.yml`, `application-prod.yml`

## 7. Spring Boot Flow (Layered)
```
Client → Controller → Service → Repository → Database
```
- **Controller** (`@RestController`) - Handle HTTP requests
- **Service** (`@Service`) - Business logic
- **Repository** (`@Repository`) - Data access (JPA)

## 8. Spring Security
- Filter-based security chain
- `SecurityFilterChain` configured via `SecurityConfig`
- **JWT Authentication**: Client sends token in header → filter validates → sets SecurityContext
- Restrict endpoints using `.requestMatchers("/admin/**").hasRole("ADMIN")`

## 9. How to secure APIs?
- **JWT Tokens** - Stateless authentication
- **OAuth 2.0** - Authorization framework
- **HTTPS/SSL** - Encrypt communication
- **API Key** - Simple key-based auth
- **Rate Limiting** - Prevent abuse

## 10. How to secure credentials/passwords?
- **Spring Cloud Config** with encryption
- **Vault** (HashiCorp)
- **Environment variables**
- **AWS Secrets Manager / Azure Key Vault**

## 11. Custom Exception Handling
```java
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(404).body(new ErrorResponse(ex.getMessage()));
    }
}
```

## 12. Circular Dependency Resolution
- `@Lazy` on one bean
- Use setter injection
- Redesign architecture

## 13. Spring Boot Annotations Summary
| Annotation | Purpose |
|-----------|---------|
| `@SpringBootApplication` | Main class (auto-config + scan) |
| `@RestController` | REST controller |
| `@RequestMapping` | Base URL |
| `@GetMapping/@PostMapping` | HTTP methods |
| `@PathVariable` | URL path parameter |
| `@RequestBody` | Request JSON body |
| `@Autowired` | Dependency injection |
| `@Service` | Business layer |
| `@Repository` | Data layer |
| `@Component` | Generic bean |
| `@Configuration` | Config class |
| `@Value` | Inject property values |

