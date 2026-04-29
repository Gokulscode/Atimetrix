# CI/CD & DevOps - Interview Questions

## 1. CI/CD Pipeline
- **CI (Continuous Integration)**: Auto build + test on every commit
- **CD (Continuous Delivery/Deployment)**: Auto deploy to environments

**Stages**: Checkout → Build → Test → Static Analysis → Deploy

## 2. Jenkins
- Open-source automation server
- Uses **Groovy scripts** (Jenkinsfile) for pipeline definition
- Stages: `checkout`, `build`, `test`, `deploy`
- **Webhook in Git** triggers automatic builds on push

## 3. Docker
- **Containerization** platform
- **Dockerfile**: Instructions to build image
```dockerfile
FROM openjdk:17-jdk-slim
COPY target/app.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
```
**Basic commands**: `docker build`, `docker run`, `docker ps`, `docker stop`, `docker push`

## 4. How to write a Dockerfile for Spring Boot?
```dockerfile
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

## 5. Jenkins vs Tekton
| Jenkins | Tekton |
|---------|--------|
| VM/container-based | Kubernetes-native |
| Groovy scripting | YAML-based |
| Plugin-heavy | Cloud-native |
| Centralized server | Serverless |

## 6. Deployment Process
Code → Git push → Webhook triggers Jenkins → Build (Maven/Gradle) → Run tests → Build Docker image → Push to registry → Deploy to Kubernetes/ECS

## 7. Security & Quality Tools
- **SonarQube** - Code quality, static analysis
- **Checkmarx / Fortify** - Security scanning (SAST)
- **OWASP Dependency Check** - Vulnerability scanning
- **JaCoCo** - Code coverage

## 8. AWS Services
- **EC2** - Virtual servers
- **ECS** - Container orchestration (managed Docker)
- **S3** - Object storage
- **Lambda** - Serverless functions

**ECS vs EC2**: ECS manages containers automatically; EC2 is raw VM where you manage everything.

## 9. How to process 2GB CSV in Spring Boot?
- Use **BufferedReader** with streaming (line by line)
- Use **Spring Batch** for chunk-based processing
- Use **parallel streams** or **multi-threading**
- **Don't load entire file into memory**
```java
try (BufferedReader br = new BufferedReader(new FileReader("large.csv"))) {
    br.lines().parallel().forEach(line -> processLine(line));
}
```

