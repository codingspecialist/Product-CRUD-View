create table product(
                        product_id int primary KEY auto_increment,
                        product_name varchar(20) NOT null UNIQUE,
                        product_price INT NOT null,
                        product_qty INT NOT null,
                        created_at TIMESTAMP NOT null
);