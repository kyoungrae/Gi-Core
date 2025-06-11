package com.gicore.common.common.site;

import com.gicore.common.common.Common;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "SITE_POPUP_NOTICE")
public class SitePopupNotice extends Common {
    @Transient
	private String keys = Arrays.toString(new String[]{"notice_id"});

    @Id

    /***<pre> notice_id : 그룹ID </pre> */
	private String notice_id;

    /***<pre> title : 제목 </pre> */
	private String title;

    /***<pre> content : 내용 </pre> */
	private String content;

    /***<pre> start_ymd : 시작일자 </pre> */
	private String start_ymd;

    /***<pre> end_ymd : 종료일자 </pre> */
	private String end_ymd;

    /***<pre> start_time_code : 시작시간코드 </pre> */
	private String start_time_code;

    /***<pre> end_time_code : 종료시간코드 </pre> */
	private String end_time_code;

    /***<pre> left : X좌표 </pre> */
	private Integer left;

    /***<pre> top : Y좌표 </pre> */
	private Integer top;

    /***<pre> width : 너비px </pre> */
	private Integer width;

    /***<pre> height : 높이px </pre> */
	private Integer height;

    /***<pre> use_yn : 사용여부 </pre> */
	private String use_yn;

    /***<pre> use_yn : 사용여부 </pre> */
	private String use_yn_name;

    /***<pre> system_create_date : 작성일자 </pre> */
	private Date system_create_date;

    /***<pre> system_create_userid : 작성자ID </pre> */
	private String system_create_userid;

    /***<pre> system_update_date : 수정일자 </pre> */
	private Date system_update_date;

    /***<pre> system_update_userid : 수정자ID </pre> */
	private String system_update_userid;


    /***<pre> target_group_list : 대상그룹리스트 </pre> */
	@Transient
    private List<String> target_group_list;

    /***<pre> user_email : 이메일(검색용) */
	@Transient
    private String user_email;



    /***<pre> notice_id : 그룹ID </pre> */
    @Transient
	private String _notice_id;

    /***<pre> title : 제목 </pre> */
    @Transient
	private String _title;

    /***<pre> content : 내용 </pre> */
    @Transient
	private String _content;

    /***<pre> start_ymd : 시작일자 </pre> */
    @Transient
	private String _start_ymd;

    /***<pre> end_ymd : 종료일자 </pre> */
    @Transient
	private String _end_ymd;

    /***<pre> start_time_code : 시작시간코드 </pre> */
    @Transient
	private String _start_time_code;

    /***<pre> end_time_code : 종료시간코드 </pre> */
    @Transient
	private String _end_time_code;

    /***<pre> left : X좌표 </pre> */
    @Transient
	private Integer _left;

    /***<pre> top : Y좌표 </pre> */
    @Transient
	private Integer _top;

    /***<pre> width : 너비px </pre> */
    @Transient
	private Integer _width;

    /***<pre> height : 높이px </pre> */
    @Transient
	private Integer _height;

    /***<pre> use_yn : 사용여부 </pre> */
    @Transient
	private String _use_yn;

    /***<pre> system_create_date : 작성일자 </pre> */
    @Transient
	private Date _system_create_date;

    /***<pre> system_create_userid : 작성자ID </pre> */
    @Transient
	private String _system_create_userid;

    /***<pre> system_update_date : 수정일자 </pre> */
    @Transient
	private Date _system_update_date;

    /***<pre> system_update_userid : 수정자ID </pre> */
    @Transient
	private String _system_update_userid;


}