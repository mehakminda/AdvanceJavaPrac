package com.learning.telusko.question1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderSummaryRepository extends JpaRepository<Order, Long> {

    // Using Spring Data JPA Constructor Expression for efficient mapping
    @Query("Select new com.learning.telusko.question1.OrderSummaryResponse(" +
            "coalesce(sum(o.totalAmount ),0.0)," +
            "coalesce(min(o.totalAmount ),0.0)," +
            "coalesce(max(o.totalAmount ),0.0)," +
            "count(o.id))" +
            "from Order o where o.id in :orderIds")
    OrderSummaryResponse getOrderSummaryByIds(@Param("orderIds") List<Long> orderIds);
}



// Note: Ensure your id column in PostgreSQL has a primary key or B-tree index
// so that the IN clause runs in \(O(\log N)\) time.

/**
 * coalesce function: The SQL COALESCE() function evaluates a list of arguments from left to right
 * and returns the first non-null value it encounters.
 *
 *
 * 1. Providing a Default/Fallback Value: If a column might contain missing data,
 * you can use COALESCE to display a user-friendly default string instead of an ugly blank NULL
 *
 * SELECT
 *     employee_name,
 *     COALESCE(phone_number, 'No Phone Provided') AS contact_number
 * FROM employees;
 * If an employee lacks a phone number, the result set will display "No Phone Provided"
 *
 *
 * 2. Prioritizing Multiple Contact Methods : You can chain multiple columns together.
 * The function stops as soon as it finds data.
 * SELECT
 *     user_name,
 *     COALESCE(work_email, personal_email, 'N/A') AS primary_contact
 * FROM users;
 * This checks for a work email first. If missing, it grabs the personal email. If both are missing, it defaults to 'N/A'.
 *
 *
 *3. Preventing Broken Mathematical Calculations : In SQL, any math operation involving a
 * NULL results in a NULL (e.g., 500 + NULL = NULL). You can wrap optional numeric columns in
 * COALESCE to treat nulls as zero.
 *
 * SELECT
 *     employee_name,
 *     salary + COALESCE(bonus, 0) AS total_compensation
 * FROM employees;
 * This ensures employees with no bonus still have their total compensation calculated correctly.
 *
 *
 *
 * Write an sql query to get total amount, min/max, count
 * select count(total_amount), min(total_amount), sum (total_amount), max(total_amount) from orders WHERE
 *     order_id IN (101, 102, 103, 104, 105);
 */


/**
 * What is the use of adding class in select query:
 * SELECT new com.example.orders.dto.OrderSummaryResponse( (or) SELECT new DTO()
 *
 *
 * The moment the database finishes the math, the numbers are instantly dropped into your clean
 * Java Record constructor, ready to be sent straight to the user.
 *
 * what if we dont use SELECT new com.example.orders.dto.OrderSummaryResponse( and instead write a generat query?
 * If you drop the SELECT new ... expression and just write a generic query like
 * SELECT SUM(o.amount), COUNT(o.id), MIN(o.amount), MAX(o.amount) ...,
 * Spring Data JPA will not automatically know how to map those results into your neat
 * OrderSummaryResponse Java object.
 *
 * we can do but we will have to add logic in service layer to cast those values in response object
 */

/***
 * o.totalAmount will match the java object or the table column name?
 * o.totalAmount matches the Java object field name, not the database table column name.
 * When you write queries using @Query, you are writing JPQL (Java Persistence Query Language)[or HQL].
 *
 * JPQL looks only at your Java classes and variables.
 * Hibernate looks at the @Column(name = "total_amount") annotation behind the scenes and
 * translates o.totalAmount into total_amount right before sending it to PostgreSQL.
 */

/**
 * Quick Rule of Thumb for Your Code
 * In your Repository @Query (JPQL): Always use o.totalAmount because JPQL talks exclusively
 * to your Java object fields.
 * If you ever switch to a Native SQL Query (nativeQuery = true): You must use total_amount
 * because Native SQL bypasses Java and talks directly to the database columns.
 */


/**
 * why is this query efficient?
 * Our original solution uses database-level aggregation functions (COUNT, SUM, MIN, MAX) combined
 * with a custom Java Record projection.
 */