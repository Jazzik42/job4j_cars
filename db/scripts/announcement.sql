create table announcement(
    id serial primary key,
    description text,
    car_id int not null unique references car(id),
    owner_id int not null unique references owner(id),
    user_id int not null references user (id)
)