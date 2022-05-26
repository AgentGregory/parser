CREATE TABLE users
(
    id       BIGSERIAL PRIMARY KEY,
    username VARCHAR NOT NUll,
    url      VARCHAR NOT NUll
);

CREATE TABLE articles
(
    id       BIGSERIAL PRIMARY KEY,
    user_id  BIGINT  NOT NULL references users (id),
    username VARCHAR NOT NUll,
    url      VARCHAR NOT NUll
);

CREATE TABLE categories
(
    id   BIGSERIAL PRIMARY KEY,
    names VARCHAR NOT NULL,
    url  VARCHAR NOT NULL
);

CREATE TABLE statistics
(
    id         BIGSERIAL PRIMARY KEY,
    reputation INTEGER,
    views      INTEGER,
    bookmarks  INTEGER,
    comment    INTEGER
);

CREATE TABLE articles
(
    id           BIGSERIAL PRIMARY KEY,
    user_id      BIGINT    NOT NULL references users (id),
    statistic_id BIGINT    NOT NULL references statistics (id),
    publishData  TIMESTAMP NOT NULL,
    title        VARCHAR   NOT NULL,
    description  VARCHAR   NOT NULL,
    url          VARCHAR   NOT NULL
    /*UNIQUE (user_id, title)*/
);

CREATE TABLE articles_categories
(
    article_id    BIGINT NOT NULL references articles (id),
    categories_id BIGINT NOT NULL references categories (id)
);



