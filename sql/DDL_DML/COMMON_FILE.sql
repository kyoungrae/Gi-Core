create table COMMON_FILE
(
    UUID                 VARCHAR2(36) not null
        constraint PK_COMMON_FILE
            primary key,
    FILE_DESCRIPTION     VARCHAR2(100),
    SYSTEM_CREATE_DATE   DATE         not null,
    SYSTEM_CREATE_USERID VARCHAR2(32) not null,
    SYSTEM_UPDATE_DATE   DATE,
    SYSTEM_UPDATE_USERID VARCHAR2(32)
)
/

comment on table COMMON_FILE is '공통파일'
/

comment on column COMMON_FILE.UUID is '공통아이디'
/

comment on column COMMON_FILE.FILE_DESCRIPTION is '파일 메모'
/

comment on column COMMON_FILE.SYSTEM_CREATE_DATE is '작성일'
/

comment on column COMMON_FILE.SYSTEM_CREATE_USERID is '작성자 아이디'
/

comment on column COMMON_FILE.SYSTEM_UPDATE_DATE is '수정일자'
/

comment on column COMMON_FILE.SYSTEM_UPDATE_USERID is '수정자 아이디'
/
