create global temporary table HTE_COMMON_USER
(
    ID          NUMBER(10),
    RN_         NUMBER(10) not null
        primary key,
    EMAIL       VARCHAR2(255 char),
    OFFICE_CODE VARCHAR2(7),
    PASSWORD    VARCHAR2(255 char),
    ROLE        VARCHAR2(255 char),
    USER_ID     VARCHAR2(255 char)
)
    on commit delete rows
/

