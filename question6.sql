Use SIEMENS;
CREATE TABLE Students (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL,
    Value INT NOT NULL
);
CREATE TABLE Notes (
    Grade INT PRIMARY KEY,
    Min_Value INT NOT NULL,
    Max_Value INT NOT NULL
);
INSERT INTO Notes (Grade, Min_Value, Max_Value) VALUES
(1, 0, 9),
(2, 10, 19),
(3, 20, 29),
(4, 30, 39),
(5, 40, 49),
(6, 50, 59),
(7, 60, 69),
(8, 70, 79),
(9, 80, 89),
(10, 90, 100);
Select * from Notes;
INSERT INTO Students (ID, Name, Value) VALUES
(1, 'Julia', 81),
(2, 'Carol', 68),
(3, 'Maria', 99),
(4, 'Andreia', 78),
(5, 'Jaqueline', 63),
(6, 'Marcela', 88);
Select * from Students;
/*RULES FOR THE FINAL QUERY
1-THE NAME FROM STUDENTS WHOSE GRADE IS LOWER THAN 8 MUST NO APPEAR
2-DESCENDING ORDER BY GRADE
3-IF STUDENTS RECEIVE THE SAME GRADE, SO SORT THEM BY NAME
4-IF THE GRADE IS LESS THE 8, USE "NULL" AS NAME AND LIST THEM IN GRADES IN DESCENDING ORDER
5-FOR STUDENTS WITH THE SAME GRADE AND LOWER THAN 8, SORT THEM BY GRADES IN ASCENDING ORDER
*/
/*rule 1 - grades */
SELECT s.Name, n.Grade, s.Value
FROM Students s
JOIN Notes n 
ON s.Value BETWEEN n.Min_Value AND n.Max_Value
WHERE n.GRADE>=8;
/*adding rule 2*/
SELECT s.Name, n.Grade, s.Value
FROM Students s
JOIN Notes n 
ON s.Value BETWEEN n.Min_Value AND n.Max_Value
WHERE n.GRADE>=8
ORDER BY n.GRADE DESC;
/*adding rule 3*/
SELECT s.Name, n.Grade, s.Value
FROM Students s
JOIN Notes n 
ON s.Value BETWEEN n.Min_Value AND n.Max_Value
WHERE n.GRADE>=8
ORDER BY n.GRADE DESC, s.NAME;
/*adding rule 4*/
SELECT 
    CASE WHEN n.Grade >= 8 THEN s.Name ELSE NULL END AS Name,
    n.Grade, 
    s.Value
FROM Students s
JOIN Notes n 
ON s.Value BETWEEN n.Min_Value AND n.Max_Value
ORDER BY n.Grade DESC, Name;
/*Adding rule 5 and final adjustments 
to have the rules for grades greater than 8 and other rules for grandes lower than 8*/ 


/*FINAL QUERY*/
SELECT 
    CASE WHEN n.Grade >= 8 THEN s.Name ELSE NULL END AS Name,
    n.Grade,
    s.Value
FROM Students s
JOIN Notes n 
ON s.Value BETWEEN n.Min_Value AND n.Max_Value
ORDER BY 
    CASE WHEN n.Grade >= 8 THEN n.Grade END DESC,  
    CASE WHEN n.Grade >= 8 THEN s.Name END ASC,   
    CASE WHEN n.Grade < 8 THEN n.Grade END ASC; 

/*the question shows another output, but I think that it was an error, because it specifies
ascending order by name for equal grades(alphabetical order). Nevertheless, to produce the result which
is showed on the example, just change the sort rule for name desc*/

SELECT 
    CASE WHEN n.Grade >= 8 THEN s.Name ELSE NULL END AS Name,
    n.Grade,
    s.Value
FROM Students s
JOIN Notes n 
ON s.Value BETWEEN n.Min_Value AND n.Max_Value
ORDER BY 
    CASE WHEN n.Grade >= 8 THEN n.Grade END DESC,  
    CASE WHEN n.Grade >= 8 THEN s.Name END DESC,   
    CASE WHEN n.Grade < 8 THEN n.Grade END ASC; 