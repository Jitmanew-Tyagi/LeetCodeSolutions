
SELECT 
    p.product_id, 
    ROUND(SUM(p.price*u.units) / SUM(u.units), 2) AS average_price
FROM 
    Prices as p
INNER JOIN 
    UnitsSold as u
ON 
    p.product_id = u.product_id
WHERE
    u.purchase_date BETWEEN p.start_date AND p.end_date
GROUP BY
    product_id;