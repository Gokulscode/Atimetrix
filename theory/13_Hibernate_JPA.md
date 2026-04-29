# Hibernate & JPA - Interview Questions

## 1. What is Hibernate?
ORM (Object-Relational Mapping) framework. Maps Java objects to database tables.

## 2. Hibernate Cache Levels
- **First-Level Cache** (Session-level) - Enabled by default. Cached within a session.
- **Second-Level Cache** (SessionFactory-level) - Shared across sessions. Uses EhCache/Redis.
- **Query Cache** - Caches query results.

## 3. JPA Repository
Spring Data JPA provides `JpaRepository` with built-in CRUD methods.
```java
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartment(String dept); // derived query
    
    @Query("SELECT e FROM Employee e WHERE e.salary > :sal")
    List<Employee> findHighEarners(@Param("sal") double sal); // custom query
}
```

## 4. JPA Relationships
- `@OneToOne`
- `@OneToMany` / `@ManyToOne`
- `@ManyToMany` (uses join table)

```java
@Entity
public class Department {
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees;
}
```

## 5. Hibernate Annotations for One-to-Many
```java
@Entity
public class Department {
    @Id @GeneratedValue
    private Long id;
    
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> students;
}

@Entity
public class Student {
    @Id @GeneratedValue
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;
}
```

## 6. Caching Solutions (Redis)
- **In-memory** key-value store
- Use `@Cacheable`, `@CacheEvict`, `@CachePut` in Spring Boot
- Great for: session storage, API response caching, rate limiting
- Spring Data Redis for integration

## 7. @Transactional
- Manages database transactions declaratively
- Rollback on `RuntimeException` by default
- `@Transactional(rollbackFor = Exception.class)` for checked exceptions
- Propagation: REQUIRED (default), REQUIRES_NEW, NESTED, etc.

