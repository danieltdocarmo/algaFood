CREATE TABLE product(
    id UUID NOT NULL PRIMARY KEY,
    name varchar(200) not null,
    description varchar(200),
    price decimal,
    is_active boolean,
    restaurant_id UUID FOREIGN KEY REFERENCES restaurant(id)
)