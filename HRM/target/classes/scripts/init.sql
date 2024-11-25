-- CREATE DATABASE IF NOT EXISTS hrm;

CREATE TABLE functie
(
    id   INT NOT NULL AUTO_INCREMENT,
    naam VARCHAR(256) UNIQUE NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE afdeling
(
    id   INT NOT NULL AUTO_INCREMENT,
    naam VARCHAR(256) UNIQUE NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE werknemer
(
    id  INT NOT NULL AUTO_INCREMENT,
    voornaam varchar(256) not null,
    achternaam varchar(256) not null,
    extensie varchar(256) not null,
    telefoon varchar(256) not null,
    afdeling int not null ,
    functie int not null ,
    PRIMARY KEY (id),
    FOREIGN KEY (functie) REFERENCES functie(id) ON DELETE CASCADE ,
    FOREIGN KEY (afdeling) REFERENCES afdeling(id) ON DELETE CASCADE

);

CREATE TABLE rol
(
    id INT NOT NULL AUTO_INCREMENT ,
    naam VARCHAR(256) UNIQUE NOT NULL ,
    PRIMARY KEY (id)
);

CREATE TABLE  if not exists werknemer_rol -- Link werknemer met  tol with 2 foreign keys.
(
    werknemerid INT NOT NULL  ,
    rollid INT NOT NULL  ,
    FOREIGN KEY (werknemerid) REFERENCES werknemer(id) ON DELETE CASCADE ,
    FOREIGN KEY (rollid) REFERENCES rol(id) ON DELETE CASCADE ,
    PRIMARY KEY (werknemerid,rollid) -- composite primary key
);



 /*

CREATE TABLE Employees (
                           employee_id INT PRIMARY KEY AUTO_INCREMENT,
                           employee_name VARCHAR(100) NOT NULL
);

-- Create the "Projects" table
CREATE TABLE Projects (
                          project_id INT PRIMARY KEY AUTO_INCREMENT,
                          project_name VARCHAR(100) NOT NULL
);

-- Create the "Assignments" table with two foreign keys
CREATE TABLE Assignments (
                             employee_id INT,
                             project_id INT,
                             assignment_date DATE NOT NULL,
                             FOREIGN KEY (employee_id) REFERENCES Employees(employee_id) ON DELETE CASCADE,
                             FOREIGN KEY (project_id) REFERENCES Projects(project_id) ON DELETE CASCADE,
                             PRIMARY KEY (employee_id, project_id) -- Composite primary key
);

-- Insert data into "Employees"
INSERT INTO Employees (employee_name)
VALUES ('Alice'), ('Bob'), ('Charlie');

-- Insert data into "Projects"
INSERT INTO Projects (project_name)
VALUES ('Project A'), ('Project B'), ('Project C');

-- Insert data into "Assignments"
INSERT INTO Assignments (employee_id, project_id, assignment_date)
VALUES
    (1, 1, '2024-01-01'),
    (2, 2, '2024-02-01'),
    (3, 3, '2024-03-01'),
    (1, 2, '2024-01-15');
*/
select * from afdeling;