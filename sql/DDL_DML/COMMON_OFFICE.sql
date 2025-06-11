create table COMMON_OFFICE
(
    TOP_OFFICE_CODE      VARCHAR2(7)   not null,
    OFFICE_NAME          VARCHAR2(100) not null,
    OFFICE_CODE          VARCHAR2(7)   not null,
    OFFICE_TYPE          VARCHAR2(100),
    OFFICE_TYPE_CODE     VARCHAR2(4),
    SYSTEM_CREATE_USERID VARCHAR2(32),
    SYSTEM_CREATE_DATE   DATE,
    SYSTEM_UPDATE_USERID VARCHAR2(32),
    SYSTEM_UPDATE_DATE   DATE
)
/

comment on table COMMON_OFFICE is '기관'
/

comment on column COMMON_OFFICE.TOP_OFFICE_CODE is '최상위 코드'
/

comment on column COMMON_OFFICE.OFFICE_NAME is '기관명'
/

comment on column COMMON_OFFICE.OFFICE_CODE is '기관코드'
/

comment on column COMMON_OFFICE.OFFICE_TYPE is '기관유형'
/

comment on column COMMON_OFFICE.OFFICE_TYPE_CODE is '등록관청 구분부호'
/

comment on column COMMON_OFFICE.SYSTEM_CREATE_USERID is '생성자ID'
/

comment on column COMMON_OFFICE.SYSTEM_CREATE_DATE is '생성일자'
/

comment on column COMMON_OFFICE.SYSTEM_UPDATE_USERID is '수정자ID'
/

comment on column COMMON_OFFICE.SYSTEM_UPDATE_DATE is '수정일자'
/

create unique index COMMON_DEPT_PK
    on COMMON_OFFICE (OFFICE_CODE)
/

alter table COMMON_OFFICE
    add constraint COMMON_OFFICE_CODE_PK
        primary key (OFFICE_CODE)
/

INSERT INTO COMMON_OFFICE (TOP_OFFICE_CODE, OFFICE_NAME, OFFICE_CODE, OFFICE_TYPE, OFFICE_TYPE_CODE, SYSTEM_CREATE_USERID, SYSTEM_CREATE_DATE, SYSTEM_UPDATE_USERID, SYSTEM_UPDATE_DATE) VALUES ('0000000', '지아이이엔에스', '0000000', '개발조직', '1', null, null, null, null);
