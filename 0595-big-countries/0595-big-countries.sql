-- Write your PostgreSQL query statement below

SELECT name,population,area
FROM World
WHERE name not in (
    SELECT name
    FROM World
    WHERE area<3000000 AND population<25000000
);