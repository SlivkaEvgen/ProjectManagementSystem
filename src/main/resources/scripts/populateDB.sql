USE jdbs;

INSERT INTO companies(id,name)
VALUES (1,'GoIT'),
       (2,'StarsIT'),
       (3,'UpIT');

INSERT INTO customers(id,name, budget,company_id)
VALUES (1,'RichMan1', 100000,1),
       (2,'RichMan2', 200000,2),
       (3,'RichMan3', 300000,3);


INSERT INTO developers(id,name, age, gender, email, number_phone,company_id)
VALUES (1,'Вася', 35, 'Male', 'abc@com.ua', 8765431,1),
       (2,'Коля', 25, 'Male', 'abc1@com.ua', 8765432,2),
       (3,'Костя', 26, 'Male', 'abc2@com.ua', 8765433,3),
        (4,'Витя', 27, 'Male', 'abc3@com.ua', 8765434,1),
        (5,'Юра', 28, 'Male', 'abc4@com.ua', 8765435,2),
        (6,'Ира', 29, 'Female', 'abc5@com.ua', 8765436,3),
        (7,'Дима', 30, 'Male', 'abc6@com.ua', 8765437,3),
        (8,'Катя', 32, 'Female', 'abc7@com.ua', 8765438,2),
        (9,'Антон', 33, 'Male', 'abc8@com.ua', 8765439,1),
        (10,'Лена', 36, 'Female', 'abc9@com.ua', 8765440,3),
        (11,'Маша', 40, 'Female', 'abc10@com.ua', 8765441,2),
        (12,'Миша', 42, 'Male', 'abc11@com.ua', 8765442,1);

INSERT INTO skills(id,activities, level)
VALUES (1,'Java', 'Senior'),
       (2,'JS', 'Senior'),
       (3,'C++', 'Senior'),
       (4,'C#', 'Senior'),
       (5, 'Java', 'Middle'),
       (6, 'JS', 'Middle'),
       (7, 'C++', 'Middle'),
       (8, 'C#', 'Middle'),
       (9, 'Java', 'Junior'),
       (10, 'JS', 'Junior'),
       (11, 'C++', 'Junior'),
       (12, 'C#', 'Junior');

INSERT INTO developers_skills(developer_id, skills_id)
VALUES (1,1),
       (2,5),
       (3,9),
       (4,3),
       (5,8),
       (6,7),
       (7,6),
       (8,5),
       (9,4),
       (10,3),
       (11,2),
       (12,1);

INSERT INTO projects(id,name,company_id,customer_id)
VALUES (1,'Bot',1,1),
       (2,'Car',2,2),
       (3,'School',3,3);

INSERT INTO developers_projects(developer_id, project_id)
VALUES (1,1),
       (2,2),
       (3,3),
       (4,1),
       (5,2),
       (6,3),
       (7,3),
       (8,2),
       (9,1),
       (10,3),
       (11,2),
       (12,1);

UPDATE developers
SET salary = 7600
WHERE name = 'Вася';

UPDATE developers
SET salary = 6660
WHERE name = 'Коля';

UPDATE developers
SET salary = 3600
WHERE name = 'Костя';

UPDATE developers
SET salary = 5600
WHERE name = 'Витя';

UPDATE developers
SET salary = 3600
WHERE name = 'Юра';

UPDATE developers
SET salary = 1750
WHERE name = 'Ира';

UPDATE developers
SET salary = 2750
WHERE name = 'Дима';

UPDATE developers
SET salary = 2550
WHERE name = 'Катя';

UPDATE developers
SET salary = 4750
WHERE name = 'Антон';

UPDATE developers
SET salary = 2250
WHERE name = 'Лена';

UPDATE developers
SET salary = 5550
WHERE name = 'Маша';

UPDATE developers
SET salary = 8750
WHERE name = 'Миша';


UPDATE projects
SET cost = 50000
WHERE id = 1;

UPDATE projects
SET cost = 25000
WHERE id = 2;

UPDATE projects
SET cost = 70000
WHERE id = 3;


SELECT  SUM(developers.salary) AS sum_salary,projects.name
FROM developers_projects
         inner join developers on developers_projects.developer_id = developers.id
         inner join projects on developers_projects.project_id = projects.id
GROUP BY projects.name
ORDER BY MAX(sum_salary) limit 1;

select activities,SUM(developers.salary) AS totalSalary
from developers_skills
         inner join developers on developers_skills.developer_id = developers.id
         inner join skills on developers_skills.skills_id = skills.id
WHERE activities = 'Java';

SELECT projects.name,MIN(projects.cost) AS min_cost
FROM projects
GROUP BY projects.name
ORDER BY min_cost limit 1;

SELECT projects.name,MIN(projects.cost) AS min_cost,AVG(developers.salary) AS avg_salary
FROM developers_projects
         inner join developers on developers_projects.developer_id = developers.id
         inner join projects on developers_projects.project_id = projects.id
GROUP BY projects.name
ORDER BY min_cost limit 1;



