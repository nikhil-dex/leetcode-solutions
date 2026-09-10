
SELECT name
FROM Employee
WHERE id in (
SELECT managerId
FROM Employee
GROUP BY managerId
HAVING count(id)>=5);