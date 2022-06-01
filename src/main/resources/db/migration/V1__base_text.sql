create table users
(
    id       bigserial primary key,
    username varchar   not null unique,
    url      varchar   not null
);
create table categories
(
    id    bigserial primary key,
    names varchar   not null unique,
    url   varchar   not null
);

create table statistics
(
    id         bigserial primary key,
    reputation integer   not null ,
    views      integer   not null ,
    bookmarks  integer   not null ,
    comments    integer   not null
);

create table articles
(
    id           bigserial primary key,
    user_id      bigint    not null references users (id),
    statistic_id bigint    not null references statistics (id),
    publishDate  timestamp not null,
    title        varchar   not null,
    description  varchar   not null,
    url          varchar   not null
/*    unique (user_id, title)*/
);

create table articles_categories
(
    article_id    bigint not null references articles (id),
    category_id bigint not null references categories (id)
);



