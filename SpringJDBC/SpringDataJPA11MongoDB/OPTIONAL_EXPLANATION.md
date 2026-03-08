# Understanding Optional<Customer> Return Type

## What Does Optional<Customer> Return?

`Optional` is a Java class that wraps a value that **may or may not exist**. It's a safe way to handle null values.

### It returns ONE of TWO things:

1. **Optional.of(customer)** - If a customer with that cusNo is found
   - Contains the `Customer` object
   - You can access it with `.get()`

2. **Optional.empty()** - If NO customer with that cusNo is found
   - Represents "nothing found"
   - You should NOT call `.get()` on this (will throw exception)

---

## How to Use It in Your Service

Here's how you would typically use `findByCusNo()`:

```java
// Example in your CustomerServiceImpl

@Override
public String findCustomerByCustNo(String custNo) {
    // Call the repository method
    Optional<Customer> optionalCustomer = repo.findByCusNo(custNo);
    
    // Check if customer exists
    if (optionalCustomer.isPresent()) {
        Customer customer = optionalCustomer.get();
        System.out.println("Found customer: " + customer.getName());
        return "Customer found: " + customer;
    } else {
        return "No customer found with cusNo: " + custNo;
    }
}
```

---

## Different Ways to Handle Optional

### Method 1: Using isPresent() and get()
```java
Optional<Customer> result = repo.findByCusNo("C001");
if (result.isPresent()) {
    Customer customer = result.get();
    // do something with customer
} else {
    // handle not found case
}
```

### Method 2: Using ifPresentOrElse() (Java 9+)
```java
repo.findByCusNo("C001").ifPresentOrElse(
    customer -> System.out.println("Found: " + customer),
    () -> System.out.println("Not found")
);
```

### Method 3: Using orElse()
```java
Customer customer = repo.findByCusNo("C001").orElse(null);
// Returns the customer if found, or null if not found
```

### Method 4: Using orElseThrow()
```java
Customer customer = repo.findByCusNo("C001").orElseThrow(
    () -> new CustomerNotFoundException("Customer not found")
);
```

---

## Why Use Optional Instead of Just Returning null?

❌ **Old Way (Using null):**
```java
Customer findByCustNo(String custNo);  // Returns Customer or null

Customer c = repo.findByCustNo("C001");
c.getName();  // ❌ NullPointerException if c is null!
```

✅ **New Way (Using Optional):**
```java
Optional<Customer> findByCusNo(String custNo);

Optional<Customer> c = repo.findByCusNo("C001");
if (c.isPresent()) {
    c.get().getName();  // ✅ Safe! Won't crash
}
```

---

## TL;DR

When you call `repo.findByCusNo("C001")`:
- **It returns an `Optional` object** (not the customer directly)
- **You must check if it's empty or present first** using `.isPresent()`
- **Only then use `.get()` to retrieve the actual Customer object**
- **This prevents NullPointerException errors**

