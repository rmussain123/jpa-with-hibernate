insert into course(id, name) values(10001, 'JPA in 50 steps');
insert into course(id, name) values(10002, 'Spring in 50 steps');
insert into course(id, name) values(10003, 'Spring boot in 50 steps');


insert into student(id, name) values (20001, 'Adam');
insert into student(id, name) values (20002, 'Yusuf');
insert into student(id, name) values (20003, 'Looth');


insert into passport(id, number) values (40001, 'E12345');
insert into passport(id, number) values (40002, 'E67890');
insert into passport(id, number) values (40003, 'E87654');

insert into review(id, rating, description,course_id) values (50001, '3', 'Good course', 10001);
insert into review(id, rating, description,course_id) values (50002, '4',  'Nice course', 10001);
insert into review(id, rating, description,course_id) values (50003, '5', 'Well course', 10003);


insert into student_course(student_id, course_id) values(20001,10001);
insert into student_course(student_id, course_id) values(20002,10001);
insert into student_course(student_id, course_id) values(20003,10001);
insert into student_course(student_id, course_id) values(20001,10003);