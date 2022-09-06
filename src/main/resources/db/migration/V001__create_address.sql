CREATE TABLE address (
    cep varchar(20),
    street varchar(200),
    street_number number,
    square varchar(200),
    city_id UUID FOREIGN KEY REFERENCES city(id)
);