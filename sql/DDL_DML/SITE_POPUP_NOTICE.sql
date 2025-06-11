create table SITE_POPUP_NOTICE
(
    NOTICE_ID            VARCHAR2(7)           not null
        primary key,
    TITLE                VARCHAR2(255)         not null,
    CONTENT              VARCHAR2(4000)        not null,
    START_YMD            CHAR(8)               not null,
    END_YMD              CHAR(8)               not null,
    START_TIME_CODE      VARCHAR2(10)          not null,
    END_TIME_CODE        VARCHAR2(10)          not null,
    LEFT                 NUMBER(4) default '0' not null,
    TOP                  NUMBER(4) default '0' not null,
    WIDTH                NUMBER(4) default '0' not null,
    HEIGHT               NUMBER(4) default '0' not null,
    USE_YN               CHAR                  not null,
    SYSTEM_CREATE_DATE   DATE                  not null,
    SYSTEM_CREATE_USERID VARCHAR2(32)          not null,
    SYSTEM_UPDATE_DATE   DATE,
    SYSTEM_UPDATE_USERID VARCHAR2(32)
)
/

comment on table SITE_POPUP_NOTICE is '사이트 공지팝업'
/

comment on column SITE_POPUP_NOTICE.NOTICE_ID is '그룹ID'
/

comment on column SITE_POPUP_NOTICE.TITLE is '제목'
/

comment on column SITE_POPUP_NOTICE.CONTENT is '내용'
/

comment on column SITE_POPUP_NOTICE.START_YMD is '시작일자'
/

comment on column SITE_POPUP_NOTICE.END_YMD is '종료일자'
/

comment on column SITE_POPUP_NOTICE.START_TIME_CODE is '시작시간코드'
/

comment on column SITE_POPUP_NOTICE.END_TIME_CODE is '종료시간코드'
/

comment on column SITE_POPUP_NOTICE.LEFT is '수평위치%'
/

comment on column SITE_POPUP_NOTICE.TOP is '수직위치%'
/

comment on column SITE_POPUP_NOTICE.WIDTH is '너비px'
/

comment on column SITE_POPUP_NOTICE.HEIGHT is '높이px'
/

comment on column SITE_POPUP_NOTICE.USE_YN is '사용여부'
/

comment on column SITE_POPUP_NOTICE.SYSTEM_CREATE_DATE is '작성일자'
/

comment on column SITE_POPUP_NOTICE.SYSTEM_CREATE_USERID is '작성자ID'
/

comment on column SITE_POPUP_NOTICE.SYSTEM_UPDATE_DATE is '수정일자'
/

comment on column SITE_POPUP_NOTICE.SYSTEM_UPDATE_USERID is '수정자ID'
/