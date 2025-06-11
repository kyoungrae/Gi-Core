create table SITE_BANNER_IMAGE
(
    UUID                 VARCHAR2(36)   not null
        primary key,
    BANNER_IMAGE_NUMBER  NUMBER(4)      not null
        constraint SITE_BANNER_IMAGE_PK
            unique,
    USE_YN               CHAR default 0 not null,
    SYSTEM_CREATE_DATE   DATE           not null,
    SYSTEM_CREATE_USERID VARCHAR2(32)   not null,
    SYSTEM_UPDATE_DATE   DATE,
    SYSTEM_UPDATE_USERID VARCHAR2(32)
)
/

comment on table SITE_BANNER_IMAGE is '사이트 배너이미지 관리'
/

comment on column SITE_BANNER_IMAGE.UUID is '공통파일UUID'
/

comment on column SITE_BANNER_IMAGE.BANNER_IMAGE_NUMBER is '순번'
/

comment on column SITE_BANNER_IMAGE.USE_YN is '사용여부'
/

comment on column SITE_BANNER_IMAGE.SYSTEM_CREATE_DATE is '작성일자'
/

comment on column SITE_BANNER_IMAGE.SYSTEM_CREATE_USERID is '작성자ID'
/

comment on column SITE_BANNER_IMAGE.SYSTEM_UPDATE_DATE is '수정일자'
/

comment on column SITE_BANNER_IMAGE.SYSTEM_UPDATE_USERID is '수정자ID'
/