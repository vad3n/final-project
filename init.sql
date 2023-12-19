DROP TABLE IF EXISTS employees;
CREATE TABLE IF NOT EXISTS employees (
    id SERIAL PRIMARY KEY,
    first_name TEXT,
    last_name TEXT
);

INSERT INTO employees VALUES (1, 'Karen', 'May');

SELECT * FROM employees;