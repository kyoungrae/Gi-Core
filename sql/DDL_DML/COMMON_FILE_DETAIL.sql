create table COMMON_FILE_DETAIL
(
    FILE_ID              VARCHAR2(36)   not null,
    UUID                 VARCHAR2(36)   not null
        constraint FK_COMMON_FILE_DETAIL
            references COMMON_FILE,
    FILE_NAME            VARCHAR2(3000) not null,
    FILE_SIZE            VARCHAR2(10)   not null,
    FILE_EXTENSION       VARCHAR2(50)   not null,
    FILE_PATH            VARCHAR2(1000) not null,
    FILE_DESCRIPTION     VARCHAR2(1000),
    SYSTEM_CREATE_DATE   DATE           not null,
    SYSTEM_CREATE_USERID VARCHAR2(32)   not null,
    SYSTEM_UPDATE_DATE   DATE,
    SYSTEM_UPDATE_USERID VARCHAR2(32),
    MENU_CODE            VARCHAR2(10),
    constraint PK_COMMON_FILE_DETAIL
        primary key (FILE_ID, UUID)
)
/

comment on table COMMON_FILE_DETAIL is '공통 첨부파일 테이블'
/

comment on column COMMON_FILE_DETAIL.FILE_ID is '파일아이디'
/

comment on column COMMON_FILE_DETAIL.UUID is '공통아이디'
/

comment on column COMMON_FILE_DETAIL.FILE_NAME is '파일이름'
/

comment on column COMMON_FILE_DETAIL.FILE_SIZE is '파일크기'
/

comment on column COMMON_FILE_DETAIL.FILE_EXTENSION is '파일확장자'
/

comment on column COMMON_FILE_DETAIL.FILE_PATH is '파일경로'
/

comment on column COMMON_FILE_DETAIL.FILE_DESCRIPTION is '파일메모'
/

comment on column COMMON_FILE_DETAIL.SYSTEM_CREATE_DATE is '작성일자'
/

comment on column COMMON_FILE_DETAIL.SYSTEM_CREATE_USERID is '작성자 아이디'
/

comment on column COMMON_FILE_DETAIL.SYSTEM_UPDATE_DATE is '수정일자'
/

comment on column COMMON_FILE_DETAIL.SYSTEM_UPDATE_USERID is '수정자 아이디'
/

comment on column COMMON_FILE_DETAIL.MENU_CODE is '메뉴코드(common_menu tbl)'
/