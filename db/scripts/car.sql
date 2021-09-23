create table car
(
    id          serial primary key,
    brand_id    int  not null references mark (id),
    body_id     int  not null references body (id),
    photo_id    int  not null references photo (id),
    user_id     int references user (id),
    mark_id     int not null references mark (id)
);
