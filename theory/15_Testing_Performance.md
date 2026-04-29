# Testing - Interview Questions

## 1. Unit Testing with JUnit & Mockito
```java
@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
    @Mock
    private EmployeeRepository repository;
    
    @InjectMocks
    private EmployeeService service;
    
    @Test
    void shouldReturnEmployee() {
        when(repository.findById(1L)).thenReturn(Optional.of(new Employee("John")));
        Employee result = service.getById(1L);
        assertEquals("John", result.getName());
        verify(repository, times(1)).findById(1L);
    }
}
```

## 2. How to mock Spring REST endpoints?
```java
@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private EmployeeService service;
    
    @Test
    void testGetEmployee() throws Exception {
        when(service.getById(1L)).thenReturn(new Employee("John"));
        mockMvc.perform(get("/api/employees/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John"));
    }
}
```

## 3. What is Spy in Mockito?
- **Mock**: Completely fake object, all methods return defaults
- **Spy**: Real object with ability to override specific methods
```java
List<String> spyList = spy(new ArrayList<>());
spyList.add("one"); // real method called
when(spyList.size()).thenReturn(100); // override specific method
```

## 4. How to write test cases for Kafka?
- Use `@EmbeddedKafka` for integration tests
- Use `KafkaTemplate` to send, `@KafkaListener` to consume
- Verify message consumption with `CountDownLatch`

## 5. Exception Handling in Java
- **Checked**: Must handle (IOException, SQLException) - `try-catch` or `throws`
- **Unchecked**: Runtime exceptions (NullPointerException, ArrayIndexOutOfBounds)
- **Error**: JVM-level (OutOfMemoryError, StackOverflowError)

## 6. Time Complexity
- **O(1)** - HashMap get/put
- **O(log n)** - Binary search, TreeMap
- **O(n)** - Linear search, single loop
- **O(n log n)** - Merge sort, Tim sort
- **O(n²)** - Nested loops, bubble sort

## 7. How to optimize a for loop running 100,000 times?
- Use **parallel streams**
- Use **batch processing**
- Use **ExecutorService** with thread pool
- Reduce operations inside loop
- Use appropriate data structures (HashMap for lookups instead of linear search)

