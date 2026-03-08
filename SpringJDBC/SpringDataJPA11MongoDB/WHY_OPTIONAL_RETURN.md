# Why findByCusNo() Must Return Optional<Customer>

## The Core Reason: Query Methods Must Return Data

When you call a repository method like `findByCusNo()`, you're **asking the database for something**. If the method returned `void`, you'd get nothing back - the database search result would disappear!

### Analogy:
```
❌ void findByCusNo(String cusNo)  →  "Hey database, find this customer... 
                                      but I don't care what you find"

✅ Optional<Customer> findByCusNo(String cusNo)  →  "Hey database, find this 
                                                     customer and GIVE ME the result"
```

---

## How You Know What It Returns: The Type Declaration Itself

The return type **tells you exactly what will come back**:

### What `Optional<Customer>` means:

```
Optional<Customer>
├─ Optional = "This might be empty OR might contain something"
└─ Customer = "If it contains something, it will be a Customer object"
```

**You know what it returns by reading the method signature:**

```java
Optional<Customer> findByCusNo(String cusNo);
                    ↑
                    This tells you: "You'll get back an Optional wrapper 
                                    containing a Customer (or empty)"
```

---

## Real Example: How the Return Value Works

### Step 1: Call the method
```java
Optional<Customer> result = repo.findByCusNo("C001");
```
At this point, `result` contains either:
- A Customer object wrapped in Optional, OR
- An empty Optional

### Step 2: Check what came back
```java
if (result.isPresent()) {
    // The database FOUND a customer with cusNo "C001"
    Customer customer = result.get();  // Extract the Customer
    System.out.println(customer.getName());  // Use the customer
} else {
    // The database did NOT find a customer with cusNo "C001"
    System.out.println("No customer found");
}
```

---

## What Actually Happens at Runtime

### Scenario 1: Customer EXISTS in database
```
Database contains:
┌─────────────────────┐
│ cusNo: "C001"       │
│ name: "John Doe"    │
│ city: "New York"    │
└─────────────────────┘

When you call: repo.findByCusNo("C001")

Returns: Optional.of(Customer { cusNo: "C001", name: "John Doe", ... })
         └─ Optional CONTAINS the Customer
         
result.isPresent()  →  TRUE
result.get()        →  Customer { cusNo: "C001", name: "John Doe", ... }
```

### Scenario 2: Customer DOES NOT EXIST in database
```
Database contains: (no customer with "C999")

When you call: repo.findByCusNo("C999")

Returns: Optional.empty()
         └─ Optional is EMPTY (no result)

result.isPresent()  →  FALSE
result.get()        →  ❌ Throws exception (don't do this!)
```

---

## Why NOT Just Return Customer (or null)?

### ❌ Bad Old Way:
```java
Customer findByCusNo(String cusNo);  // Returns Customer or null

Customer c = repo.findByCusNo("C001");
c.getName();  // ⚠️ CRASH! NullPointerException if c is null
```

The developer might forget to check for null!

### ✅ Better New Way (with Optional):
```java
Optional<Customer> findByCusNo(String cusNo);

Optional<Customer> c = repo.findByCusNo("C001");
c.get().getName();  // ⚠️ Compiler warns you: "Check isPresent() first!"
```

Optional **forces you** to handle the "not found" case.

---

## Summary: How You Know What It Returns

| You see this... | It means... | What you get back |
|---|---|---|
| `void findByCusNo()` | ❌ Bad - returns nothing | Nothing (NullPointerException risk) |
| `Customer findByCusNo()` | ⚠️ Okay - returns customer or null | Customer object OR null (risky) |
| `Optional<Customer> findByCusNo()` | ✅ Best - returns wrapper | Optional containing Customer OR empty Optional |

**The method signature is your contract - it tells you EXACTLY what type of data will come back!**

---

## Complete Usage Example in Your Service

```java
@Service
public class CustomerServiceImpl implements ICustomerService {
    
    @Autowired
    private ICustomerRepo repo;
    
    // Example method using findByCusNo()
    public Customer getCustomerByCustNo(String custNo) {
        // Call the repository - you KNOW it returns Optional<Customer>
        Optional<Customer> optionalCustomer = repo.findByCusNo(custNo);
        
        // Use one of these approaches:
        
        // Approach 1: Check if present, then get
        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        }
        
        // Approach 2: Use orElse (return null if not found)
        // return optionalCustomer.orElse(null);
        
        // Approach 3: Use orElseThrow (throw exception if not found)
        // return optionalCustomer.orElseThrow(
        //     () -> new CustomerNotFoundException("Customer not found")
        // );
        
        return null;  // Not found
    }
}
```

**Bottom line:** The method signature `Optional<Customer> findByCusNo(String cusNo)` tells you upfront: "I will return an Optional containing a Customer, or an empty Optional." You'll never be surprised!

