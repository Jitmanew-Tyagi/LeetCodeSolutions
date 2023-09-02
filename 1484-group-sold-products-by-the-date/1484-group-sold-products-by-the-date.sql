SELECT
    a.sell_date,
    COUNT(DISTINCT a.product) as num_sold,
    GROUP_CONCAT(DISTINCT(a.product) ORDER BY a.product) AS products
FROM
    Activities as a
GROUP BY
    sell_date