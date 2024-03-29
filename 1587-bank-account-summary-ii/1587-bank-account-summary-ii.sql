SELECT
    SUM(t.amount) AS balance,
    u.name
FROM 
    Transactions as t
JOIN 
    Users as u 
    ON t.account = u.account
GROUP BY
    t.account
HAVING  
    balance > 10000;