WITH t1 AS (
    SELECT 
        *
    FROM 
        Students
    CROSS JOIN
        Subjects
), 

t2 AS (
    SELECT 
        student_id, 
        subject_name, 
        COUNT(*) as attended_exams
    FROM 
        Examinations as e
    GROUP BY
        student_id,
        subject_name
)

SELECT 
    t1.student_id,
    t1.student_name,
    t1.subject_name,
    CASE WHEN t2.attended_exams IS NULL THEN 0 ELSE t2.attended_exams END AS attended_exams
FROM 
    t1
LEFT JOIN 
    t2
ON 
    t1.student_id = t2.student_id
    AND
    t1.subject_name = t2.subject_name
ORDER BY
    t1.student_id,
    t1.subject_name;