create table SITE_POPUP_NOTICE_TARGET_GROUP
(
    NOTICE_ID            VARCHAR2(7)  not null
        constraint SITE_POPUP_NOTICE_TARGET_GROUP_SITE_POPUP_NOTICE_NOTICE_ID_FK
            references SITE_POPUP_NOTICE
                on delete cascade,
    GROUP_ID             VARCHAR2(32) not null
        constraint SITE_POPUP_NOTICE_TARGET_GROUP_COMMON_GROUP_GROUP_ID_FK
            references COMMON_GROUP,
    SYSTEM_CREATE_DATE   DATE         not null,
    SYSTEM_CREATE_USERID VARCHAR2(32) not null,
    SYSTEM_UPDATE_DATE   DATE,
    SYSTEM_UPDATE_USERID VARCHAR2(32)
)
/

comment on table SITE_POPUP_NOTICE_TARGET_GROUP is '사이트 공지팝업 대상'
/