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
start_day char(20) not null,
end_day char(20) not null,
r_return char(20),
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

insert into Person(id, name, pwd,address, phone_num, admin_check) values('admin', "지훈", "1", "서울시 성동", "6714", true);
insert into Person(id, name, pwd,address, phone_num, admin_check) values('p1', "고객1", "1", "서울시", "1036", false);
insert into Person(id, name, pwd,address, phone_num, admin_check) values('p2', "고객2", "2", "서울시", "9603", false);
insert into Person(id, name, pwd,address, phone_num, admin_check) values('p3', "고객3", "3", "서울시", "8806", false);
insert into book(bname, author, genre,rent) values("책이름1","최지훈","비어있음",false);
insert into rent(r_num,b_num,p_id,start_day,end_day,r_return) values (0,1,"a2","2020","2020",null);

select * from person;
select * from book;
select * from noticeboard;
select * from rent;
select * from rent where p_id=12 order by r_num;
update person set title="제목1", content="내용1" where num="5";


select * from rent inner join person where id="123";
delete from person where name="1";

select * from person where name="1" and phone_num="123456";

select *from rent where p_id='12' order by r_num;

update person set id = "13" where name = "1";
select * from person inner join rent;
delete from person where id="";

select r_num from person inner join rent where id = 123;