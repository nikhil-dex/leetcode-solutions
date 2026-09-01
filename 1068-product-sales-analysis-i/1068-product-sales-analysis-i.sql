-- Write your PostgreSQL query statement below

SELECT n.product_name,p.year,p.price
FROM Product n
JOIN Sales p
ON n.product_id = p.product_id;