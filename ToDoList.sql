CREATE DATABASE ToDoApp;
USE todoapp;
Create table Tasks
(
id int Primary key auto_increment,
description_ varchar(400),
due_date date,
completed bool,
category_id int,
Foreign key (category_id) references Category(id)
);
create table Categories 
(
id int primary key auto_increment,
name_ varchar(100)
);
alter table category rename to categories;
alter table categories rename column name to name_;

INSERT INTO Categories (name_) VALUES ('Lavoro');
INSERT INTO Categories (name_) VALUES ('Casa');
INSERT INTO Categories (name_) VALUES ('Sport');
INSERT INTO Categories (name_) VALUES ('Tempo libero');

-- Inserimento dati nella tabella Tasks
INSERT INTO Tasks (description_, due_date, completed, category_id) 
VALUES ('Scrivere report settimanale', '2024-02-28', false, 1);

INSERT INTO Tasks (description_, due_date, completed, category_id) 
VALUES ('Fare la spesa', '2024-03-01', false, 2);

INSERT INTO Tasks (description_, due_date, completed, category_id) 
VALUES ('Pulire il bagno', '2024-03-01', true, 2);

INSERT INTO Tasks (description_, due_date, completed, category_id) 
VALUES ('Finire consenga per il collega Franco', '2024-03-05', false, 1);

INSERT INTO Tasks (description_, due_date, completed, category_id) 
VALUES ('Completare task manager', '2024-03-05', true, 1);

INSERT INTO Tasks (description_, due_date, completed, category_id) 
VALUES ('Andare in palestra', '2024-03-02', true, 3);

INSERT INTO Tasks (description_, due_date, completed, category_id) 
VALUES ('Andare a correre', '2024-03-02', false, 3);

INSERT INTO Tasks (description_, due_date, completed, category_id) 
VALUES ('Uscire con gli amici', '2024-03-03', false, 4);
