CREATE TABLE order(
    id UUID NOT NULL PRIMARY KEY,
    sub_total decimal,
    total decimal,
    created_at timestamp not null,
    updated_at timestamp not null
)