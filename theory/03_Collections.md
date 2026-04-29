# Collections - Interview Questions

## 1. HashMap Internal Working
- Uses **array of Node (bucket)** + linked list/tree
- `put(key, value)`: calculates `hashCode()` → index = `hash & (n-1)` → stores in bucket
- **Collision**: Same index → linked list. If list > 8 nodes → converts to **Red-Black Tree** (Java 8+)
- `get(key)`: hash → bucket index → traverse list/tree using `equals()`
- **Load factor**: 0.75 (default). Rehashing at 75% capacity (doubles size)

## 2. HashMap vs ConcurrentHashMap
| HashMap | ConcurrentHashMap |
|---------|-------------------|
| Not thread-safe | Thread-safe |
| Allows one null key, multiple null values | No null key or value |
| Fails with ConcurrentModificationException | No CME |
| No locking | Segment-level locking (Java 7) / CAS + synchronized (Java 8) |

## 3. ConcurrentHashMap Internal Working (Java 8)
- Uses **CAS (Compare-And-Swap)** for reads (lock-free)
- Uses **synchronized** on individual bucket (node) for writes
- No segment locking (unlike Java 7)
- Multiple threads can read simultaneously

## 4. LinkedList vs ArrayList
| ArrayList | LinkedList |
|-----------|------------|
| Dynamic array | Doubly linked list |
| Fast random access O(1) | Slow random access O(n) |
| Slow insert/delete in middle O(n) | Fast insert/delete O(1) |
| Better for read-heavy | Better for write-heavy |
| Less memory | More memory (prev/next pointers) |

**When to use**: ArrayList for frequent access/search. LinkedList for frequent insertions/deletions.

## 5. HashSet Internal Working
- Internally uses a **HashMap** where the element is the key and a dummy `PRESENT` object is the value
- `add(e)` → `map.put(e, PRESENT)`
- Uniqueness guaranteed by `hashCode()` + `equals()`

## 6. Why String is preferred as HashMap key?
- **Immutable** → hashCode never changes after creation
- **hashCode is cached** → no re-computation
- Implements `equals()` and `hashCode()` properly

## 7. Difference between Map and Set
| Map | Set |
|-----|-----|
| Key-Value pairs | Only values |
| Keys are unique | Elements are unique |
| HashMap, TreeMap, LinkedHashMap | HashSet, TreeSet, LinkedHashSet |

## 8. Which collection for natural sorting order?
- **TreeSet** (for unique elements, sorted)
- **TreeMap** (for key-value, sorted by key)
- Both use Red-Black Tree internally

## 9. Implementation classes for Set
- `HashSet` - unordered, uses HashMap
- `LinkedHashSet` - insertion order
- `TreeSet` - sorted order (natural/comparator)

