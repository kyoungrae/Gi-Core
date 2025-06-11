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
@Table(name = "SITE_SCHEDULED_MAIL_TARGET_GROUP")
public class SiteScheduledMailTargetGroup extends Common {
    @Transient
	private String keys = Arrays.toString(new String[]{});

    @Id

    /***<pre> mail_id : 메일ID </pre> */
	private String mail_id;

    /***<pre> group_id : 그룹ID </pre> */
	private String group_id;

    /***<pre> group_name : 그룹ID </pre> */
    @Transient
	private String group_name;

    /***<pre> system_create_date : 작성일자 </pre> */
    private Date system_create_date;

    /***<pre> system_create_userid : 작성자ID </pre> */
    private String system_create_userid;

    /***<pre> system_update_date : 수정일자 </pre> */
    private Date system_update_date;

    /***<pre> system_update_userid : 수정자ID </pre> */
    private String system_update_userid;



    /***<pre> mail_id : 메일ID </pre> */
    @Transient
	private String _mail_id;

    /***<pre> group_id : 그룹ID </pre> */
    @Transient
	private String _group_id;
    /***<pre> group_id : 그룹ID </pre> */
    @Transient
	private String _group_name;

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