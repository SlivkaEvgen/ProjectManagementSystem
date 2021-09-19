# DROP DATABASE IF EXISTS homework;
# CREATE DATABASE IF NOT EXISTS homework;
# USE homework;
# CREATE TABLE IF NOT EXISTS companies
# (
#     id   INT PRIMARY KEY AUTO_INCREMENT,
#     name VARCHAR(40) NOT NULL,
#     city VARCHAR(40) NOT NULL
# );
#
# CREATE TABLE IF NOT EXISTS customers
# (
#     id     INT PRIMARY KEY AUTO_INCREMENT,
#     name   VARCHAR(40) NOT NULL,
#     city   VARCHAR(40) NOT NULL,
#     budget DECIMAL     NOT NULL
# );
#
# CREATE TABLE IF NOT EXISTS developers
# (
#     id           INT PRIMARY KEY AUTO_INCREMENT,
#     name         VARCHAR(30)            NOT NULL,
#     age          INT                    NOT NULL,
#     gender       ENUM ('Male','Female') NOT NULL,
#     email        VARCHAR(30)            NOT NULL,
#     salary       BIGINT(10)             NOT NULL,
#     company_id  INT NOT NULL,
#     FOREIGN KEY (company_id) REFERENCES companies (id) ON DELETE CASCADE
# );
#
# CREATE TABLE IF NOT EXISTS skills
# (
#     id         INT PRIMARY KEY AUTO_INCREMENT,
#     activities ENUM ('Java','C++','C#','JS')     NOT NULL,
#     level      ENUM ('Junior','Middle','Senior') NOT NULL
# );
#
# CREATE TABLE IF NOT EXISTS projects
# (
#     id          INT PRIMARY KEY AUTO_INCREMENT,
#     name        VARCHAR(40) NOT NULL,
#     cost        DECIMAL,
#     first_date  datetime default CURRENT_TIMESTAMP,
#     company_id  INT         NOT NULL,
#     customer_id INT         NOT NULL,
#     FOREIGN KEY (company_id) REFERENCES companies (id) ON DELETE CASCADE,
#     FOREIGN KEY (customer_id) REFERENCES customers (id) ON DELETE CASCADE
# );
#
# CREATE TABLE IF NOT EXISTS developers_projects
# (
#     developer_id int NOT NULL,
#     project_id   int NOT NULL,
#     PRIMARY KEY (developer_id, project_id),
#     FOREIGN KEY (developer_id) REFERENCES developers (id) ON DELETE CASCADE,
#     FOREIGN KEY (project_id) REFERENCES projects (id) ON DELETE CASCADE
# );
#
# CREATE TABLE IF NOT EXISTS developers_skills
# (
#     developer_id int NOT NULL,
#     skill_id    int NOT NULL,
#     PRIMARY KEY (developer_id, skill_id),
#     FOREIGN KEY (developer_id) REFERENCES developers (id) ON DELETE CASCADE,
#     FOREIGN KEY (skill_id) REFERENCES skills (id) ON DELETE CASCADE
# );
#
#
#
