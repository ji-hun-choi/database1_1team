use team1;

drop table book;
create table book (
num int primary key auto_increment,
bname char(20) not null,
author char(20) not null,
genre char(20) not null,
rent Boolean not null
);

drop table Person;
create table Person (
id char(20) primary key,
name char(20) not null,
pwd char(30) not null,
address char(100),
phone_num char(14) not null,
admin_check Boolean not null
);

drop table Rent;
create table Rent (
r_num int primary key auto_increment,
b_num int not null,
p_id char(20) not null,
start_day date not null,
end_day date not null,
r_return date,
foreign key(b_num) references book(num),
foreign key(p_id) references Person(id)
);

drop table Noticeboard;
create table Noticeboard (
num int primary key auto_increment,
title char(50) not null,
content char(200),
p_id char(20) not null,
foreign key(p_id) references Person(id)
);