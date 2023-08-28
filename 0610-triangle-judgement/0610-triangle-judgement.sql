SELECT *, CASE WHEN (z < x + y) AND (x < y + z) AND (y < x + z)
THEN "Yes" ELSE "No" END as triangle
FROM Triangle;