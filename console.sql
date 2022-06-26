create table users (
    id int auto_increment primary key,
    first_name varchar(100) not null ,
    last_name varchar(50) not null,
    email varchar(100) not null  unique,
    password varchar(100) not null
)


select * from users;

drop table  users;