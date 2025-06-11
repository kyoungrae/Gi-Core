create table SITE_SENT_MAIL_MANAGEMENT
(
    EMAIL_ID             VARCHAR2(7)  not null
        constraint SITE_SENT_MAIL_MANAGEMENT_SITE_SCHEDULED_MAIL_MAIL_ID_FK
            references SITE_SCHEDULED_MAIL,
    ID                   NUMBER(10)   not null
        constraint SITE_SENT_MAIL_MANAGEMENT_COMMON_USER_ID_FK
            references COMMON_USER,
    STATE_CODE           VARCHAR2(10) not null,
    LATEST_SENT_DATE     DATE,
    LATEST_FROM_EMAIL    VARCHAR2(255),
    LATEST_TO_EMAIL      VARCHAR2(255),
    FAILURE_REASON_CODE  VARCHAR2(10),
    SYSTEM_CREATE_USERID VARCHAR2(32) not null,
    SYSTEM_CREATE_DATE   DATE         not null,
    SYSTEM_UPDATE_USERID VARCHAR2(32),
    SYSTEM_UPDATE_DATE   DATE
)
/

comment on table SITE_SENT_MAIL_MANAGEMENT is '메일발송관리'
/

comment on column SITE_SENT_MAIL_MANAGEMENT.EMAIL_ID is '메일ID(SEQ)'
/

comment on column SITE_SENT_MAIL_MANAGEMENT.ID is '유저ID'
/

comment on column SITE_SENT_MAIL_MANAGEMENT.STATE_CODE is '상태코드'
/

comment on column SITE_SENT_MAIL_MANAGEMENT.LATEST_SENT_DATE is '발송일자'
/

comment on column SITE_SENT_MAIL_MANAGEMENT.LATEST_FROM_EMAIL is '발신 이메일 주소'
/

comment on column SITE_SENT_MAIL_MANAGEMENT.LATEST_TO_EMAIL is '수신 이메일 주소'
/

comment on column SITE_SENT_MAIL_MANAGEMENT.FAILURE_REASON_CODE is '발송 실패 사유 코드'
/

comment on column SITE_SENT_MAIL_MANAGEMENT.SYSTEM_CREATE_USERID is '작성자ID'
/

comment on column SITE_SENT_MAIL_MANAGEMENT.SYSTEM_CREATE_DATE is '작성일자'
/

comment on column SITE_SENT_MAIL_MANAGEMENT.SYSTEM_UPDATE_USERID is '수정자ID'
/

comment on column SITE_SENT_MAIL_MANAGEMENT.SYSTEM_UPDATE_DATE is '수정일자'
/