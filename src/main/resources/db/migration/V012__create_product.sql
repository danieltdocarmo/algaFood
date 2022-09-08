CREATE TABLE product(
    id UUID NOT NULL PRIMARY KEY,
    name varchar(200) not null,
    description varchar(200),
    price decimal,
    is_active boolean,
    restaurant_id UUID,
    CONSTRAINT fk_restaurant FOREIGN KEY(restaurant_id) REFERENCES restaurant(id)
)