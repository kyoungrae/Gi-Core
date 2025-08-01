create table COMMON_USER_GROUP
(
    GROUP_ID             VARCHAR2(32)  not null,
    USER_EMAIL           VARCHAR2(255) not null,
    USER_ID              VARCHAR2(255) not null,
    OFFICE_CODE          VARCHAR2(7)   not null,
    SYSTEM_CREATE_DATE   DATE          not null,
    SYSTEM_CREATE_USERID VARCHAR2(32)  not null,
    SYSTEM_UPDATE_DATE   DATE,
    SYSTEM_UPDATE_USERID VARCHAR2(32),
    ID                   NUMBER(10)    not null,
    constraint COMMON_USER_GROUP_PK
        primary key (ID, GROUP_ID)
)
/

comment on column COMMON_USER_GROUP.GROUP_ID is '그룹아이디'
/

comment on column COMMON_USER_GROUP.USER_EMAIL is '사용자 email'
/

comment on column COMMON_USER_GROUP.USER_ID is '사용자 ID'
/

comment on column COMMON_USER_GROUP.OFFICE_CODE is '소속코드'
/

comment on column COMMON_USER_GROUP.SYSTEM_CREATE_DATE is '작성일자'
/

comment on column COMMON_USER_GROUP.SYSTEM_CREATE_USERID is '작성자ID'
/

comment on column COMMON_USER_GROUP.SYSTEM_UPDATE_DATE is '수정일자'
/

comment on column COMMON_USER_GROUP.SYSTEM_UPDATE_USERID is '수정자ID'
/

INSERT INTO COMMON_USER_GROUP (GROUP_ID, USER_EMAIL, USER_ID, OFFICE_CODE, SYSTEM_CREATE_DATE, SYSTEM_CREATE_USERID, SYSTEM_UPDATE_DATE, SYSTEM_UPDATE_USERID, ID) VALUES ('system', 'go66go66@giens.co.kr', 'go66go66', '0000000', TIMESTAMP '2024-11-08 17:17:25', 'go66go66@giens.co.kr', null, null, 1);
INSERT INTO COMMON_USER_GROUP (GROUP_ID, USER_EMAIL, USER_ID, OFFICE_CODE, SYSTEM_CREATE_DATE, SYSTEM_CREATE_USERID, SYSTEM_UPDATE_DATE, SYSTEM_UPDATE_USERID, ID) VALUES ('system', 'shmoon@giens.co.kr', 'shmoon', '0000000', TIMESTAMP '2024-11-08 17:17:25', 'go66go66@giens.co.kr', null, null, 1955);
INSERT INTO COMMON_USER_GROUP (GROUP_ID, USER_EMAIL, USER_ID, OFFICE_CODE, SYSTEM_CREATE_DATE, SYSTEM_CREATE_USERID, SYSTEM_UPDATE_DATE, SYSTEM_UPDATE_USERID, ID) VALUES ('system', 'apages@giens.co.kr', 'apages', '0000000', TIMESTAMP '2024-11-08 17:17:25', 'go66go66@giens.co.kr', null, null, 1953);
INSERT INTO COMMON_USER_GROUP (GROUP_ID, USER_EMAIL, USER_ID, OFFICE_CODE, SYSTEM_CREATE_DATE, SYSTEM_CREATE_USERID, SYSTEM_UPDATE_DATE, SYSTEM_UPDATE_USERID, ID) VALUES ('system', 'joo717@giens.co.kr', 'joo717', '0000000', TIMESTAMP '2024-11-08 17:17:25', 'go66go66@giens.co.kr', null, null, 1954);
INSERT INTO COMMON_USER_GROUP (GROUP_ID, USER_EMAIL, USER_ID, OFFICE_CODE, SYSTEM_CREATE_DATE, SYSTEM_CREATE_USERID, SYSTEM_UPDATE_DATE, SYSTEM_UPDATE_USERID, ID) VALUES ('system', 'sooyeonbae@giens.co.kr', 'sooyeonbae', '0000000', TIMESTAMP '2024-11-08 17:17:25', 'go66go66@giens.co.kr', null, null, 1956);
INSERT INTO COMMON_USER_GROUP (GROUP_ID, USER_EMAIL, USER_ID, OFFICE_CODE, SYSTEM_CREATE_DATE, SYSTEM_CREATE_USERID, SYSTEM_UPDATE_DATE, SYSTEM_UPDATE_USERID, ID) VALUES ('system', 'giens@giens.co.kr', 'giens', '0000000', TIMESTAMP '2024-11-08 17:17:25', 'go66go66@giens.co.kr', null, null, 1957);
