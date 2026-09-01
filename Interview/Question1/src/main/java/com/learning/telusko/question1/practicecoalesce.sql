use testdb;

CREATE TABLE customer_order_details(
                                       customer_id VARCHAR(20),
                                       customer_name VARCHAR(20),
                                       order_id VARCHAR(20),
                                       order_price INT
);

INSERT INTO customer_order_details
VALUES
    ('C1098', 'PRADEEP', 'O3006', 20000),
    ('C1098', 'PRADEEP', 'O3010', 5000),
    ('C1098', 'PRADEEP', 'O3016', 600),
    ('C1100', 'KIRAN', 'O3068', 1000),
    ('C1100', 'KIRAN', 'O3075', 200),
    ('C1195', 'PRANAV', 'O3072', 6000),
    ('C1195', 'PRANAV', 'O3045', 80000),
    ('C2026', 'BUTCHI RAJU', 'O3056', 100000),
    ('C2026', 'BUTCHI RAJU', 'O3058', 20000);

INSERT INTO customer_order_details VALUES
                                       ('C3001', 'AMIT', 'O4001', NULL),
                                       ('C3002', 'SNEHA', 'O4002', NULL),
                                       ('C1098', 'PRADEEP', 'O4003', NULL);

SELECT * FROM customer_order_details;

SELECT customer_id , MAX(order_price) AS HighestPurchase
FROM customer_order_details
GROUP BY customer_id
ORDER BY MAX(order_price) DESC;

select sum(order_price), min(order_price), max(order_price) from customer_order_details;

select sum(order_price), min(order_price), max(order_price),count(order_id) from customer_order_details
where order_id IN( 'O3056','O4003', 'O4002' );

select sum(order_price), min(order_price), max(order_price), count(order_id) from customer_order_details
where order_id IN( 'O4003', 'O4002' );

select
    coalesce(sum(order_price),0),
    coalesce(count(order_id)),
    coalesce(max(order_price),0),
    coalesce(min(order_price),0)
from customer_order_details
where order_id in ('O3056','O4003', 'O4002');


select
    coalesce(sum(order_price),0),
    coalesce(count(*)),  -- alternatively we can also use count(order_id)
    coalesce(max(order_price),0),
    coalesce(min(order_price),0)
from customer_order_details
where order_id in ('O4003', 'O4002' );


/*
Query 1 (No COALESCE): PostgreSQL scans the index, finds zero matching rows, and outputs
a single row containing blank values: [NULL, NULL, NULL]. If your application code
expects numeric objects, this can crash your mapping code with a NullPointerException.

Query 2 (With COALESCE): PostgreSQL scans the index, finds zero matching rows, and
triggers the COALESCE default logic, cleanly outputting a concrete
row of zeros: [0, 0, 0, 0].

*/

/*
The main difference between COUNT(*) and COUNT(order_id) :
comes down to how they handle blank (NULL) values and performance.

COUNT(*) counts the total number of rows in the result set, including rows that contain
NULL values or duplicates.

COUNT(order_id) counts only the rows where the order_id column is NOT NULL.
*/