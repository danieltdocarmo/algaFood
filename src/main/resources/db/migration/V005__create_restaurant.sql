CREATE TABLE restaurant(
    id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    delivery_tax DECIMAL NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    kitchen_id UUID FOREIGN KEY REFERENCES kitchen(id)
    --relation paymentform
)   