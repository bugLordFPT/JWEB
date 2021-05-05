create schema if not exists coursedb;
use coursedb;

drop table if exists Trainee;
create table Trainee(
	trainee_account varchar(50),
    password varchar(50),
    trainee_name nvarchar(100),
    primary key (trainee_account)
);

drop table if exists Course;
create table Course (
	trainee_account varchar(50),
    course_code varchar(50),
    course_title nvarchar(50),
    course_type nvarchar(100),
    year int,
    semester nvarchar(50),
    
    primary key (trainee_account, course_code),
    foreign key (trainee_account) references Trainee(trainee_account)
);