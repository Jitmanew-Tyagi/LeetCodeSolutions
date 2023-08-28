SELECT a.firstName, a.lastName, b.city, b.state
FROM Person as a
LEFT JOIN Address as b
ON a.personId = b.personId;
