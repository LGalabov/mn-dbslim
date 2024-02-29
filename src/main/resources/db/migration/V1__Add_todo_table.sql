CREATE TABLE todo
(
    id   serial PRIMARY KEY,
    note varchar(255) NOT NULL,
    date timestamp    NOT NULL DEFAULT NOW()
);
