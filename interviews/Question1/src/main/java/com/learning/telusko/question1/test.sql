CREATE TABLE orders (
                        id BIGINT PRIMARY KEY,
                        total_amount NUMERIC(19,2)
);


INSERT INTO orders (id, total_amount)
VALUES
    (1, 100.50),
    (2, 2500.00),
    (3, NULL),
    (4, 75.25),
    (5, NULL),
    (6, 999.99),
    (7, NULL),
    (8, 150.00),
    (9, 4500.75),
    (10, NULL);