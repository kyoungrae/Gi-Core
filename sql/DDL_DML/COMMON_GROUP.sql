create table COMMON_GROUP
(
    GROUP_ID             VARCHAR2(32)  not null
        constraint PK_COMMON_GROUP
            primary key,
    GROUP_NAME           VARCHAR2(100) not null,
    GROUP_LEVEL          VARCHAR2(1)   not null,
    TOP_GROUP_ID         VARCHAR2(32),
    USE_YN               CHAR,
    SYSTEM_CREATE_DATE   DATE          not null,
    SYSTEM_CREATE_USERID VARCHAR2(32)  not null,
    SYSTEM_UPDATE_DATE   DATE,
    SYSTEM_UPDATE_USERID VARCHAR2(32)
)
/

comment on table COMMON_GROUP is '공통그룹'
/

comment on column COMMON_GROUP.GROUP_ID is '그룹아이디'
/

comment on column COMMON_GROUP.GROUP_NAME is '그룹이름'
/

comment on column COMMON_GROUP.GROUP_LEVEL is '그룹레벨'
/

comment on column COMMON_GROUP.TOP_GROUP_ID is '상위 그룹아이디'
/

comment on column COMMON_GROUP.USE_YN is '사용여부'
/

comment on column COMMON_GROUP.SYSTEM_CREATE_DATE is '작성일자'
/

comment on column COMMON_GROUP.SYSTEM_CREATE_USERID is '작성자ID'
/

comment on column COMMON_GROUP.SYSTEM_UPDATE_DATE is '수정일자'
/

comment on column COMMON_GROUP.SYSTEM_UPDATE_USERID is '수정자ID'
/

INSERT INTO COMMON_GROUP (GROUP_ID, GROUP_NAME, GROUP_LEVEL, TOP_GROUP_ID, USE_YN, SYSTEM_CREATE_DATE, SYSTEM_CREATE_USERID, SYSTEM_UPDATE_DATE, SYSTEM_UPDATE_USERID) VALUES ('admin', '업무 관리자', '0', null, '1', TIMESTAMP '2024-11-08 15:43:57', 'go66go66@giens.co.kr', null, null);
INSERT INTO COMMON_GROUP (GROUP_ID, GROUP_NAME, GROUP_LEVEL, TOP_GROUP_ID, USE_YN, SYSTEM_CREATE_DATE, SYSTEM_CREATE_USERID, SYSTEM_UPDATE_DATE, SYSTEM_UPDATE_USERID) VALUES ('system-group', '시스템 관리자', '0', null, '1', TIMESTAMP '2024-11-08 15:47:44', 'go66go66@giens.co.kr', null, null);
INSERT INTO COMMON_GROUP (GROUP_ID, GROUP_NAME, GROUP_LEVEL, TOP_GROUP_ID, USE_YN, SYSTEM_CREATE_DATE, SYSTEM_CREATE_USERID, SYSTEM_UPDATE_DATE, SYSTEM_UPDATE_USERID) VALUES ('system', '시스템 관리자', '1', 'system-group', '1', TIMESTAMP '2025-02-04 16:42:57', 'sooyeonbae@giens.co.kr', null, null);
