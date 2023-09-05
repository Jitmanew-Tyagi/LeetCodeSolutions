WITH t1 AS(
    SELECT 
        v.customer_id AS customer_id,
        t.transaction_id AS transaction_id
    FROM
        Visits as v
    LEFT JOIN 
        Transactions as t
    ON
        v.visit_id = t.visit_id
    WHERE
        t.transaction_id IS NULL
)

SELECT
    customer_id,
    COUNT(*) AS count_no_trans
FROM 
    t1
GROUP BY
    customer_id;