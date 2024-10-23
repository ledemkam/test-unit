create table if not exists customers(
                                        id  int auto_increment primary key ,
                                        email varchar(100) unique not null
    );