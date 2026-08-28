-- Write your PostgreSQL query statement below

SELECT c.name
FROM Customer c
WHERE c.id not in (
    SELECT id 
    FROM Customer
    WHERE referee_id=2
);