CREATE TABLE city(
    id UUID NOT NULL PRIMARY KEY,
    name varchar(200),
    state_id UUID NOT NULL,
    CONSTRAINT fk_state FOREIGN KEY(state_id) REFERENCES STATE(id)
)