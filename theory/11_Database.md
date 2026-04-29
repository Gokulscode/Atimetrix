# Database - Interview Questions

## 1. Indexing
Data structure that improves query speed at the cost of write performance and storage.

**Types:**
- **Clustered Index** - Physically reorders table data (one per table, usually PK)
- **Non-Clustered Index** - Separate structure with pointers to data (multiple per table)
- **Composite Index** - Index on multiple columns
- **Unique Index** - Ensures uniqueness

**When to use**: Frequently queried columns, WHERE/JOIN/ORDER BY columns.

## 2. Primary Key vs Unique Key
| Primary Key | Unique Key |
|-------------|------------|
| Only one per table | Multiple per table |
| No NULL allowed | One NULL allowed |
| Creates clustered index | Creates non-clustered index |

## 3. SQL Joins
- **INNER JOIN** - Matching rows from both tables
- **LEFT JOIN** - All from left + matching from right
- **RIGHT JOIN** - All from right + matching from left
- **FULL JOIN** - All rows from both tables
- **SELF JOIN** - Table joined with itself
- **CROSS JOIN** - Cartesian product

## 4. SQL: Count students per department
```sql
SELECT department_name, COUNT(*) AS student_count
FROM students
GROUP BY department_name;
```

## 5. SQL: Get department name from student table
```sql
SELECT s.name, d.department_name
FROM students s
JOIN departments d ON s.dept_id = d.id;
```

## 6. Database Optimization
- Add **indexes** on frequently queried columns
- Use **query execution plan** (EXPLAIN)
- Avoid **SELECT ***
- Use **pagination** (LIMIT/OFFSET)
- **Connection pooling** (HikariCP)
- **Caching** (Redis, second-level cache)
- **Database replication** for read scaling
- Optimize JOINs, avoid N+1 queries

## 7. SELECT vs UPDATE statement
- **SELECT**: Read-only, doesn't modify data, can use shared locks
- **UPDATE**: Modifies data, acquires exclusive lock on rows

## 8. Stored Procedures vs Functions
| Stored Procedure | Function |
|-----------------|----------|
| Can return 0 or multiple values | Must return one value |
| Can have OUT params | Only IN params |
| Can call functions | Cannot call procedures |
| Cannot use in SELECT | Can use in SELECT |

## 9. NoSQL Databases
- **MongoDB** - Document store (JSON-like)
- **Couchbase** - Document + key-value
- No fixed schema, flexible structure
- Better for unstructured/semi-structured data
- Horizontal scaling easier

**MongoDB vs Oracle:**
| MongoDB | Oracle |
|---------|--------|
| No SQL, document-based | SQL, relational |
| No relationships/joins | Full JOIN support |
| Schema-less | Fixed schema |
| Easy horizontal scaling | Vertical scaling |

## 10. How to choose a database?
Based on:
- Client/business requirements
- Data structure (structured → SQL, unstructured → NoSQL)
- Read/write patterns
- Scalability needs
- ACID compliance requirements

