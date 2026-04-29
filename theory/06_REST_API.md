# REST API - Interview Questions

## 1. RESTful Principles
- **Stateless** - No session stored on server
- **Client-Server** separation
- **Uniform Interface** - Standard HTTP methods
- **Cacheable** - Responses can be cached
- **Layered System** - Client doesn't know intermediaries
- **Resource-based** - Everything is a resource with URI

## 2. GET vs POST
| GET | POST |
|-----|------|
| Retrieve data | Create/submit data |
| Data in URL params | Data in request body |
| Idempotent | Not idempotent |
| Can be cached | Not cached |
| Bookmarkable | Not bookmarkable |

**Can we perform GET using POST?** Yes, technically possible but violates REST principles.

## 3. PUT vs PATCH
| PUT | PATCH |
|-----|-------|
| Full update (replace entire resource) | Partial update (modify specific fields) |
| Must send complete object | Send only changed fields |
| Idempotent | Can be idempotent |

## 4. POST vs PUT
| POST | PUT |
|------|-----|
| Create new resource | Update/replace existing resource |
| Not idempotent | Idempotent |
| Server generates ID | Client specifies ID |

## 5. SOAP vs REST
| SOAP | REST |
|------|------|
| Protocol | Architectural style |
| XML only | JSON, XML, text |
| WSDL contract | No strict contract |
| Heavy, more overhead | Lightweight |
| Built-in security (WS-Security) | Uses HTTPS, OAuth, JWT |
| Strict standards | Flexible |

## 6. REST vs RESTful
- **REST** = Architectural style/principles
- **RESTful** = API that follows REST principles

## 7. REST API Protocols
- **HTTP/HTTPS** - Communication protocol
- **JSON/XML** - Data format
- **OAuth 2.0 / JWT** - Authentication
- **SSL/TLS** - Encryption

## 8. Login API - POST or GET?
**POST** - because credentials should be in request body (not URL). GET exposes data in URL/logs.

## 9. GraphQL API
- Single endpoint for all queries
- Client specifies exactly what data it needs
- Reduces over-fetching and under-fetching
- Alternative to REST for complex data requirements

## 10. Disadvantages of RestTemplate
- **Synchronous** - blocks thread
- **Deprecated** in Spring 5.x (use WebClient)
- No reactive support
- **WebClient** is non-blocking, supports both sync & async

## 11. What are prerequisites for developing an API?
- Define resource/endpoint URIs
- Choose HTTP methods
- Define request/response DTOs
- Authentication mechanism
- Error handling strategy
- API documentation (Swagger/OpenAPI)

