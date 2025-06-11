create global temporary table HTE_TOKEN
(
    EXPIRED    NUMBER(1),
    ID         NUMBER(10),
    REVOKED    NUMBER(1),
    RN_        NUMBER(10) not null
        primary key,
    USER_ID    NUMBER(10),
    TOKEN      VARCHAR2(255 char),
    TOKEN_TYPE VARCHAR2(255 char)
)
    on commit delete rows
/

