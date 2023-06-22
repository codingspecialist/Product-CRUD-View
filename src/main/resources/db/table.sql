create table product(
    id int primary KEY auto_increment,
    name varchar(20) NOT null UNIQUE,
    price INT NOT null,
    qty INT NOT null,
    created_at TIMESTAMP NOT null
);