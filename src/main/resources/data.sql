create table person
(
id integer not null,
name varchar(255) not null,
location varchar(255),
birth_date timestamp,
primary key(id)
);

INSERT INTO "jpa-hibernate".person
(id, "name", "location", birth_date)
VALUES(10001, 'Hussain', 'Chennai', CURRENT_DATE);

INSERT INTO "jpa-hibernate".person
(id, "name", "location", birth_date)
VALUES(10002, 'Srini', 'Salem', CURRENT_DATE);

INSERT INTO "jpa-hibernate".person
(id, "name", "location", birth_date)
VALUES(10003, 'Rajesh', 'US', CURRENT_DATE);

INSERT INTO "jpa-hibernate".person
(id, "name", "location", birth_date)
VALUES(10004, 'Gokul', 'Ambattur', CURRENT_DATE);

INSERT INTO "jpa-hibernate".person
(id, "name", "location", birth_date)
VALUES(10005, 'RV', 'Bangalore', CURRENT_DATE);

INSERT INTO "jpa-hibernate".person
(id, "name", "location", birth_date)
VALUES(10006, 'Subbu', 'Madipakkam', CURRENT_DATE);

select * from person p ;
