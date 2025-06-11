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

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "SITE_SENT_MAIL_MANAGEMENT")
public class SiteSentMailManagement extends Common {
    @Transient
	private String keys = Arrays.toString(new String[]{});

    @Id

    /***<pre> mail_id : 메일ID(SEQ) </pre> */
	private String mail_id;

    /***<pre> title : 메일제목 </pre> */
    @Transient
	private String title;

    /***<pre> id : 유저ID </pre> */
	private Integer id;

    /***<pre> id : 유저ID </pre> */
	@Transient
    private String email;

    /***<pre> id : 유저ID </pre> */
	@Transient
    private String content;

    /***<pre> state_code : 상태코드 </pre> */
	private String state_code;

    /***<pre> state_code : 상태코드 </pre> */
    @Transient
	private String state_code_name;

    /***<pre> latest_sent_date : 발송일자 </pre> */
	private Date latest_sent_date;

    /***<pre> latest_sent_time : 발송시간 </pre> */
	private String latest_sent_time;

    /***<pre> latest_from_email : 발신 이메일 주소 </pre> */
	private String latest_from_email;

    /***<pre> latest_to_email : 수신 이메일 주소 </pre> */
	private String latest_to_email;

    /***<pre> failure_reason_code : 발송 실패 사유 코드 </pre> */
	private String failure_reason_code;

    /***<pre> failure_reason_code : 발송 실패 사유 코드 </pre> */
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



    /***<pre> mail_id : 메일ID(SEQ) </pre> */
    @Transient
	private String _mail_id;

    /***<pre> id : 유저ID </pre> */
    @Transient
	private Integer _id;

    /***<pre> state_code : 상태코드 </pre> */
    @Transient
	private String _state_code;

    /***<pre> latest_sent_date : 발송일자 </pre> */
    @Transient
	private Date _latest_sent_date;

    /***<pre> latest_sent_time : 발송시간 </pre> */
    @Transient
    private String _latest_sent_time;

    /***<pre> latest_from_email : 발신 이메일 주소 </pre> */
    @Transient
	private String _latest_from_email;

    /***<pre> latest_to_email : 수신 이메일 주소 </pre> */
    @Transient
	private String _latest_to_email;

    /***<pre> failure_reason_code : 발송 실패 사유 코드 </pre> */
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

    /***<pre> state_code : 상태코드 </pre> */
    @Transient
    private String _state_code_name;

    /***<pre> failure_reason_code : 발송 실패 사유 코드 </pre> */
    @Transient
    private String _failure_reason_code_name;


}