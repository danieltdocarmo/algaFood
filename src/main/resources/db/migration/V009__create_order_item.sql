CREATE TABLE order_item(
    id UUID NOT NULL PRIMARY KEY,
    quantity decimal NOT NULL,
    note varchar(255),
    total decimal,
    created_at timestamp not null,
    updated_at timestamp not null
)