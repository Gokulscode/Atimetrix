# Microservices - Interview Questions

## 1. What is Microservices Architecture?
Independent, loosely coupled services that communicate over network. Each service:
- Has its own database
- Can be deployed independently
- Has a single responsibility

## 2. How do microservices communicate?
- **Synchronous**: REST (RestTemplate/WebClient/FeignClient), gRPC
- **Asynchronous**: Message Queues (Kafka, RabbitMQ)

## 3. Advantages of Microservices over Monolithic
- Independent deployment & scaling
- Technology diversity
- Fault isolation
- Easier to understand individual services
- Better team autonomy

## 4. What happens when one microservice fails? (Cascading failure)
Use **Circuit Breaker Pattern** (Resilience4j / Hystrix):
- **CLOSED**: Requests flow normally
- **OPEN**: Requests fail fast (fallback response)
- **HALF-OPEN**: Test if service recovered

Other strategies:
- **Retry Mechanism** with backoff
- **Fallback Response** - return cached/default data
- **Bulkhead Pattern** - isolate resources
- **Event-Driven** - decouple via message queue

## 5. If Service A → B → C, and C fails, how to handle transactions?
**SAGA Pattern**:
- **Choreography**: Each service publishes events, others react and compensate
- **Orchestration**: Central orchestrator manages the flow and rollback

Each service performs compensating transaction to undo previous operations.

## 6. Service Discovery
- **Eureka** (Netflix) - Service registry
- Services register themselves on startup
- Client queries Eureka to find service instances
- Enables **load balancing** across instances

Flow: Client → API Gateway → Eureka lookup → Service instance

## 7. How to determine number of microservice instances?
Based on: traffic load, CPU/memory usage, response time SLAs, auto-scaling policies (Kubernetes HPA).

## 8. API Gateway
Single entry point for all clients. Handles:
- Routing, Load balancing
- Authentication/Authorization
- Rate limiting, Logging

## 9. Two microservices updating same table?
- Use **distributed locking** (Redis lock)
- Use **optimistic locking** (version column in DB)
- Use **event-driven architecture** - queue updates
- Use **@Transactional** with proper isolation level

## 10. Load Balancing & Scaling
- **Client-side** load balancing (Spring Cloud LoadBalancer)
- **Server-side** (Nginx, AWS ALB)
- **Horizontal scaling** - add more instances
- **Vertical scaling** - increase resources

## 11. How to connect to two different databases?
Configure two `DataSource` beans, two `EntityManagerFactory`, two `TransactionManager` with `@Primary` and `@Qualifier`.

## 12. @Transactional and Isolation Levels
- **READ_UNCOMMITTED** - Dirty reads allowed
- **READ_COMMITTED** - No dirty reads
- **REPEATABLE_READ** - No non-repeatable reads
- **SERIALIZABLE** - Full isolation (slowest)

## 13. Circular Dependency (Bean A → B, Bean B → A)
- Use `@Lazy` annotation on one dependency
- Use Setter injection instead of Constructor injection
- Redesign to break the cycle

