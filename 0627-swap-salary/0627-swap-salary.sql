UPDATE 
    Salary
SET 
    sex = CASE
        WHEN sex = 'm' THEN 'f'
        When sex = 'f' THEN 'm'
    END