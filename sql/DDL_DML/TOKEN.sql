create table TOKEN
(
    EXPIRED    NUMBER(1)  not null
        check (expired in (0, 1)),
    ID         NUMBER(10) not null
        primary key,
    REVOKED    NUMBER(1)  not null
        check (revoked in (0, 1)),
    USER_ID    NUMBER(10)
        constraint FKBQINKU6F8QXLPSN6OPSGPVO38
            references "_user" (),
    TOKEN      VARCHAR2(255 char)
        unique,
    TOKEN_TYPE VARCHAR2(255 char)
        check (token_type in ('AUTHORIZATION'))
)
/