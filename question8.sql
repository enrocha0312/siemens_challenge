Use Siemens;
CREATE TABLE Dogs (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE Cats (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);
INSERT INTO Dogs (name) VALUES 
('Tobi'), 
('Tobi'), 
('Ariel'), 
('Laika'), 
('Peri');

INSERT INTO Cats (name) VALUES 
('Felix'), 
('Crepúsculo'), 
('Aurora');

/*first of all: it's necessary to have the union of the two tables*/

SELECT name FROM Dogs
UNION
SELECT name FROM Cats;

/*o union removes the repeated elements inside each table, let's see how it works
if we have the same name for dog and cat*/
INSERT INTO Dogs (name) VALUES ('Aurora');

SELECT name FROM Dogs
UNION
SELECT name FROM Cats;

/*the union still does not repeat, so we need just the union clause
I confess that I didn't remember this fact, I was ready to use the result as subquery
and create a Select distinct on that */
SELECT name FROM Dogs
UNION
SELECT name FROM Cats;

