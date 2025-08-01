create table SITE_SCHEDULED_MAIL_TARGET_GROUP
(
    MAIL_ID  VARCHAR2(7)  not null
        constraint SITE_SCHEDULED_MAIL_TARGET_GROUP_SITE_SCHEDULED_MAIL_MAIL_ID_FK
            references SITE_SCHEDULED_MAIL,
    GROUP_ID VARCHAR2(32) not null
        constraint SITE_SCHEDULED_MAIL_TARGET_GROUP_COMMON_GROUP_GROUP_ID_FK
            references COMMON_GROUP
)
/

comment on table SITE_SCHEDULED_MAIL_TARGET_GROUP is '메일 해당 그룹'
/

comment on column SITE_SCHEDULED_MAIL_TARGET_GROUP.MAIL_ID is '메일ID'
/

comment on column SITE_SCHEDULED_MAIL_TARGET_GROUP.GROUP_ID is '그룹ID'
/