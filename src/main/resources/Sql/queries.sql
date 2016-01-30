#List of sql queries for this project
drop database if exists course_ware;
create databse course_ware;
drop table if exists course
drop table if exists lesson
drop table if exists users_info
create table course (
                      course_id bigint not null auto_increment, 
                      course_name varchar(255), 
                      primary key (course_id))

create table lesson(
                    lesson_id bigint not null auto_increment,
                    lesson_name varchar(255), 
                    lesson_number integer, 
                    course_id bigint, 
                    primary key (lesson_id))
create table users_info(
                       user_id bigint not null auto_increment, 
                       password varchar(255), primary key (user_id))
alter table lesson add constraint FK_6go38xat645pq7m62rp5byakj foreign key (course_id) references course (course_id)

#insert some example data into tables
insert into course(course_name) values ('Java');
insert into lesson(lesson_name,lesson_number,course_id) values ('OOPS Concepts',1,1);
insert into lesson(lesson_name,lesson_number,course_id) values ('Classes and Objects',2,1);