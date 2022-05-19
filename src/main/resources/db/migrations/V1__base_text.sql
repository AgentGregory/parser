CREATE TABLE users
(
    id       BIGSERIAL PRIMARY KEY,
    username VARCHAR   NOT NUll ,
    url      VARCHAR   NOT NUll
);
CREATE TABLE articles
    {
    id       BIGSERIAL PRIMARY KEY,
    user_id  BIGINT    NOT NULL references users (id),
    username VARCHAR   NOT NUll ,
    url      VARCHAR   NOT NUll
    };

INSERT INTO users (username) VALUES ('papich'),('obama'),('putin');

