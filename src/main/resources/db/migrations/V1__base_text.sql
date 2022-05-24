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
CREATE TABLE categories
(
    id      BIGSERIAL  PRIMARY KEY,
    name    VARCHAR    NOT NULL,
    url     VARCHAR    NOT NULL
);
CREATE TABLE statistic
(
    id          BIGSERIAL PRIMARY KEY,
    reputation  INTEGER,
    views       INTEGER,
    bookmarks   INTEGER,
    comment     INTEGER,
);



