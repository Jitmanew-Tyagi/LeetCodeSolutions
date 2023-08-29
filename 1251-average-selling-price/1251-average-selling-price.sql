WITH temp AS(
SELECT 
    p.product_id as pid, 
    p.price as price,
    u.units as units
FROM 
    Prices as p
INNER JOIN 
    UnitsSold as u
ON 
    p.product_id = u.product_id
WHERE
    u.purchase_date BETWEEN p.start_date AND p.end_date
)


SELECT
    pid as product_id, 
    ROUND(SUM(price*units) / SUM(units), 2) AS average_price
FROM 
    temp
GROUP BY
    pid