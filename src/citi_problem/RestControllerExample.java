package citi_problem;

/**
 * Problem: Write REST controller with all required annotations and explain its use.
 * Asked in: Yogesh, Ayesha rounds
 *
 * NOTE: This is a Spring Boot controller template. Requires Spring Boot to compile/run.
 */
public class RestControllerExample {

    /*
    @RestController                      // Marks class as REST controller (@Controller + @ResponseBody)
    @RequestMapping("/api/employees")    // Base URL mapping
    public class EmployeeController {

        @Autowired                       // Injects EmployeeService bean
        private EmployeeService employeeService;

        @GetMapping                      // GET /api/employees
        public ResponseEntity<List<Employee>> getAllEmployees() {
            return ResponseEntity.ok(employeeService.findAll());
        }

        @GetMapping("/{id}")             // GET /api/employees/{id}
        public ResponseEntity<Employee> getById(@PathVariable Long id) {
            return employeeService.findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @PostMapping                     // POST /api/employees
        public ResponseEntity<Employee> create(@Valid @RequestBody Employee employee) {
            Employee saved = employeeService.save(employee);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        }

        @PutMapping("/{id}")             // PUT /api/employees/{id} - Full update
        public ResponseEntity<Employee> update(@PathVariable Long id,
                                                @Valid @RequestBody Employee employee) {
            employee.setId(id);
            return ResponseEntity.ok(employeeService.save(employee));
        }

        @PatchMapping("/{id}")           // PATCH /api/employees/{id} - Partial update
        public ResponseEntity<Employee> partialUpdate(@PathVariable Long id,
                                                       @RequestBody Map<String, Object> updates) {
            return ResponseEntity.ok(employeeService.partialUpdate(id, updates));
        }

        @DeleteMapping("/{id}")          // DELETE /api/employees/{id}
        public ResponseEntity<Void> delete(@PathVariable Long id) {
            employeeService.delete(id);
            return ResponseEntity.noContent().build();
        }
    }
    */

    public static void main(String[] args) {
        System.out.println("See comments above for REST controller template with annotations.");
        System.out.println("Key Annotations:");
        System.out.println("  @RestController - REST controller");
        System.out.println("  @RequestMapping - Base URL");
        System.out.println("  @GetMapping, @PostMapping, @PutMapping, @PatchMapping, @DeleteMapping");
        System.out.println("  @PathVariable - URL path param");
        System.out.println("  @RequestBody - JSON body");
        System.out.println("  @Valid - Bean validation");
        System.out.println("  @Autowired - Dependency injection");
    }
}

