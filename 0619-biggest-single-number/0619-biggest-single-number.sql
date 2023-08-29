WITH cte AS(
SELECT MAX(num) as num
FROM MyNumbers as mn
GROUP BY num
HAVING COUNT(num) = 1)

SELECT CASE WHEN 
COUNT(*) > 0 
THEN MAX(num) 
ELSE NULL 
END AS num 
FROM cte;