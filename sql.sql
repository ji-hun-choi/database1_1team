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

insert into Person(id, name, pwd,address, phone_num, admin_check) values('abc123', "abc", "123", "¼­¿ï½Ã ¼ºµ¿", "6699", true);
insert into Person(id, name, pwd,address, phone_num, admin_check) values('c1', "c", "1", "¼­¿ï½Ã", "8831", false);
insert into book(bname, author, genre,rent) values("Ã¥","¸¶±Í","ºö",false);
insert into book(bname, author, genre,rent) values("Ã¥2","¸¶±Í1","ºö",false);
insert into book(bname, author, genre,rent) values("Ã¥3","¸¶±Í4","ºö",false);
insert into rent(r_num,b_num,p_id,start_day,end_day,r_return) values (0,1,"123","2020","2020",null);
insert into Noticeboard(title, content, p_id) values ("Á¦¸ñ1", "³»¿ë2", "abc123")
insert into Noticeboard(title, content, p_id) values ("Á¦¸ñ2", "³»¿ë1", "abc123")

select * from person;
select * from book;
select * from noticeboard;

update person set title="Á¦¸ñ1", content="³»¿ë1" where num="5";


select * from rent inner join person where id="123";
delete from person where id="123" and pwd="1234";