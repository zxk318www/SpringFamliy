CREATE TABLE t_coffee(
   Id bigint not null auto_increment,
   name varchar (255),
   price bigint not null,
   create_time timestamp,
    update_time timestamp,
    primary key (id)
);