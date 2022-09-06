CREATE TABLE group(
    id integer NOT NULL primary key,
    description VARCHAR(200),
    --many to many with permission
);