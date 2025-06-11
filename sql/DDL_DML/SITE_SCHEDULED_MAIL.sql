create table SITE_SCHEDULED_MAIL
(
    MAIL_ID              VARCHAR2(7)    not null
        primary key,
    TITLE                VARCHAR2(255)  not null,
    CONTENT              VARCHAR2(4000) not null,
    SCHEDULED_YN         CHAR           not null,
    SCHEDULED_YMD        CHAR(8),
    SCHEDULED_TIME_CODE  VARCHAR2(10),
    STATE_CODE           VARCHAR2(10)   not null,
    FAILURE_REASON_CODE  VARCHAR2(10),
    SYSTEM_CREATE_USERID VARCHAR2(32)   not null,
    SYSTEM_CREATE_DATE   DATE           not null,
    SYSTEM_UPDATE_USERID VARCHAR2(32),
    SYSTEM_UPDATE_DATE   DATE
)
/

comment on table SITE_SCHEDULED_MAIL is '메일관리'
/

comment on column SITE_SCHEDULED_MAIL.MAIL_ID is '메일ID(SEQ)'
/

comment on column SITE_SCHEDULED_MAIL.TITLE is '메일제목'
/

comment on column SITE_SCHEDULED_MAIL.CONTENT is '메일내용'
/

comment on column SITE_SCHEDULED_MAIL.SCHEDULED_YN is '예약여부'
/

comment on column SITE_SCHEDULED_MAIL.SCHEDULED_YMD is '예약일자'
/

comment on column SITE_SCHEDULED_MAIL.SCHEDULED_TIME_CODE is '예약시간코드'
/

comment on column SITE_SCHEDULED_MAIL.STATE_CODE is '상태코드'
/

comment on column SITE_SCHEDULED_MAIL.FAILURE_REASON_CODE is '실패사유코드'
/

comment on column SITE_SCHEDULED_MAIL.SYSTEM_CREATE_USERID is '작성자ID'
/

comment on column SITE_SCHEDULED_MAIL.SYSTEM_CREATE_DATE is '작성일자'
/

comment on column SITE_SCHEDULED_MAIL.SYSTEM_UPDATE_USERID is '수정자ID'
/

comment on column SITE_SCHEDULED_MAIL.SYSTEM_UPDATE_DATE is '수정일자'
/