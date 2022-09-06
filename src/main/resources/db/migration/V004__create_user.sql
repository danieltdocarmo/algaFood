CREATE TABLE user(
    id UUID NOT NULL PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    password varchar(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
)