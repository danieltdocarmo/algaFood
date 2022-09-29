CREATE TABLE restaurant(
    id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    delivery_tax DECIMAL NOT NULL,
    cep VARCHAR(200),
    street VARCHAR(200),
    street_number INTEGER,
    square VARCHAR(200),
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    kitchen_id UUID,
    city_id UUID,
    CONSTRAINT fk_kitchen FOREIGN KEY(kitchen_id) REFERENCES kitchen(id),
    CONSTRAINT fk_city FOREIGN KEY(city_id) REFERENCES city(id)
)   