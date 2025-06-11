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
@Table(name = "SITE_SCHEDULED_MAIL")
public class SiteScheduledMail extends Common {
    @Transient
	private String keys = Arrays.toString(new String[]{"mail_id"});

    @Id

    /***<pre> mail_id : 메일ID(SEQ) </pre> */
	private String mail_id;

    /***<pre> title : 메일제목 </pre> */
	private String title;

    /***<pre> content : 메일내용 </pre> */
	private String content;

    /***<pre> scheduled_yn : 예약여부 </pre> */
	private String scheduled_yn;

    @Transient
    /***<pre> scheduled_yn : 예약여부 </pre> */
	private String scheduled_yn_name;

    /***<pre> scheduled_ymd : 예약일자 </pre> */
	private String scheduled_ymd;

    /***<pre> scheduled_time : 예약시간 </pre> */
	private String scheduled_time;

    /***<pre> state_code : 상태코드 </pre> */
	private String state_code;

    /***<pre> state_code : 상태코드 </pre> */
    @Transient
	private String state_code_name;

    /***<pre> failure_reason_code : 실패사유코드 </pre> */
	private String failure_reason_code;

    /***<pre> failure_reason_code : 실패사유코드 </pre> */
    @Transient
    private String failure_reason_code_name;

    /***<pre> system_create_userid : 작성자ID </pre> */
	private String system_create_userid;

    /***<pre> system_create_date : 작성일자 </pre> */
	private Date system_create_date;

    /***<pre> system_update_userid : 수정자ID </pre> */
	private String system_update_userid;

    /***<pre> system_update_date : 수정일자 </pre> */
	private Date system_update_date;

    /***<pre> target_group_list : 대상그룹 </pre> */
    @Transient
    private List<String> target_group_list;

    /***<pre> target_group_list : 대상그룹 </pre> */
    @Transient
    private String target_group;

    /***<pre> uuid : 첨부파일 </pre> */
    @Transient
    private String uuid;



    /***<pre> mail_id : 메일ID(SEQ) </pre> */
    @Transient
	private String _mail_id;

    /***<pre> title : 메일제목 </pre> */
    @Transient
	private String _title;

    /***<pre> content : 메일내용 </pre> */
    @Transient
	private String _content;

    /***<pre> scheduled_yn : 예약여부 </pre> */
    @Transient
	private String _scheduled_yn;

    /***<pre> scheduled_ymd : 예약일자 </pre> */
    @Transient
	private String _scheduled_ymd;

    /***<pre> scheduled_time : 예약시간 </pre> */
    @Transient
	private String _scheduled_time;

    /***<pre> state_code : 상태코드 </pre> */
    @Transient
	private String _state_code;

    /***<pre> failure_reason_code : 실패사유코드 </pre> */
    @Transient
	private String _failure_reason_code;

    /***<pre> system_create_userid : 작성자ID </pre> */
    @Transient
	private String _system_create_userid;

    /***<pre> system_create_date : 작성일자 </pre> */
    @Transient
	private Date _system_create_date;

    /***<pre> system_update_userid : 수정자ID </pre> */
    @Transient
	private String _system_update_userid;

    /***<pre> system_update_date : 수정일자 </pre> */
    @Transient
	private Date _system_update_date;


}