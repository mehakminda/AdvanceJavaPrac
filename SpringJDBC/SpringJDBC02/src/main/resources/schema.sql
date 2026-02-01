create table student(
    id int primary key not null,
    name varchar(45) not null,
    city varchar(44) not null
);

create table course (
    cid int ,
    cname varchar(100),
    primary key (cid)
);