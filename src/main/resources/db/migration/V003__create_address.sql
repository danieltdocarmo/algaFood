CREATE TABLE address (
    cep varchar(20),
    street varchar(200),
    street_number int,
    square varchar(200),
    city_id UUID,
    CONSTRAINT fk_city FOREIGN KEY(city_id) REFERENCES city(id)
);