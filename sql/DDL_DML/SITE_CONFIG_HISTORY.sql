create table SITE_CONFIG_HISTORY
(
    CONFIG_GROUP_ID      VARCHAR2(100)  not null,
    CONFIG_KEY           VARCHAR2(500)  not null,
    CONFIG_VALUE         VARCHAR2(100)  not null,
    DESCRIPTION          VARCHAR2(500),
    USE_YN               CHAR default 0 not null,
    SYSTEM_CREATE_DATE   DATE,
    SYSTEM_CREATE_USERID VARCHAR2(32),
    SYSTEM_UPDATE_DATE   DATE,
    SYSTEM_UPDATE_USERID VARCHAR2(32)
)
/

comment on column SITE_CONFIG_HISTORY.CONFIG_GROUP_ID is '설정그룹ID'
/

comment on column SITE_CONFIG_HISTORY.CONFIG_KEY is '설정 키'
/

comment on column SITE_CONFIG_HISTORY.CONFIG_VALUE is '설정 값'
/

comment on column SITE_CONFIG_HISTORY.DESCRIPTION is '설명'
/

comment on column SITE_CONFIG_HISTORY.USE_YN is '사용여부'
/

comment on column SITE_CONFIG_HISTORY.SYSTEM_CREATE_DATE is '작성일자'
/

comment on column SITE_CONFIG_HISTORY.SYSTEM_CREATE_USERID is '작성자ID'
/

comment on column SITE_CONFIG_HISTORY.SYSTEM_UPDATE_DATE is '수정일자'
/

comment on column SITE_CONFIG_HISTORY.SYSTEM_UPDATE_USERID is '수정자ID'
/