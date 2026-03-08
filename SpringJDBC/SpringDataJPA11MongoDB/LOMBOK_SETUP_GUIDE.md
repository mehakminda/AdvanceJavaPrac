# Why You're Not Getting Setters and Getters

## The Issue
Your `Customer` class uses Lombok's `@Data` annotation which generates getters, setters, toString, equals, and hashCode methods **at compile time**. However, IntelliJ IDEA needs proper configuration to recognize these generated methods.

## Solution: Enable Lombok in IntelliJ IDEA

### Step 1: Install Lombok Plugin
1. Open IntelliJ IDEA
2. Go to **File → Settings** (or **Ctrl+Alt+S**)
3. Navigate to **Plugins**
4. Search for "**Lombok**"
5. Click **Install** (if not already installed)
6. Restart IntelliJ IDEA

### Step 2: Enable Annotation Processing
1. Open **File → Settings** (or **Ctrl+Alt+S**)
2. Navigate to **Build, Execution, Deployment → Compiler → Annotation Processors**
3. Check the box: ✅ **Enable annotation processing**
4. Click **Apply** and **OK**

### Step 3: Rebuild the Project
1. Go to **Build → Rebuild Project**
2. Or use Maven: Right-click on `pom.xml` → **Maven → Reload Project**

## What Was Fixed

1. ✅ **Completed the incomplete method call**: Changed `c.ge` to `c.getId()`
2. ✅ **Fixed repository type mismatch**: Changed `ICustomerRepo extends MongoRepository<Customer,Integer>` to `MongoRepository<Customer,String>` to match the Customer's String ID field
3. ✅ **Added missing repository method**: Added `deleteByCusNo(String cusNo)` method to the repository interface
4. ✅ **Completed the incomplete method**: Fixed `removeDocumentByCustNo()` implementation

## How Lombok Works

The `@Data` annotation on your `Customer` class automatically generates:
- Getters for all fields (`getId()`, `getCusNo()`, `getName()`, `getCity()`)
- Setters for all non-final fields (`setId()`, `setCusNo()`, `setName()`, `setCity()`)
- `toString()` method (already manually overridden in your class)
- `equals()` and `hashCode()` methods

Once Lombok plugin and annotation processing are enabled, IntelliJ will recognize these methods and provide autocomplete for them!

## Verification
After following the steps above, you should be able to:
- Type `customer.get` and see autocomplete suggestions for `getId()`, `getName()`, etc.
- Type `customer.set` and see autocomplete suggestions for `setId()`, `setName()`, etc.

