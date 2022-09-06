CREATE TABLE kitchen(
    id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(255),
    created_at TIMESTAMP not null,
    updated_at TIMESTAMP not null
)