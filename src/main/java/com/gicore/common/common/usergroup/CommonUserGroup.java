package com.gicore.common.common.usergroup;

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
@Table(name = "COMMON_USER_GROUP")
public class CommonUserGroup extends Common {
    @Transient
	private String keys = Arrays.toString(new String[]{"group_id","user_email"});

    /***<pre> id : id </pre> */
    @Id
    private Integer id;

    /***<pre> group_id : 그룹아이디 </pre> */
	private String group_id;


    /***<pre> user_email : 사용자 email </pre> */
	private String user_email;

    /***<pre> user_id : 사용자 ID </pre> */
	private String user_id;

    /***<pre> office_code : 소속코드 </pre> */
	private String office_code;

    /***<pre> system_create_date : 작성일자 </pre> */
	private Date system_create_date;

    /***<pre> system_create_userid : 작성자ID </pre> */
	private String system_create_userid;

    /***<pre> system_update_date : 수정일자 </pre> */
	private Date system_update_date;

    /***<pre> system_update_userid : 수정자ID </pre> */
	private String system_update_userid;



    /***<pre> group_name : 그룹이름 </pre> */
    @Transient
	private String group_name;
    
    /***<pre> user_name : 사용자이름 </pre> */
    @Transient
	private String user_name;

    /***<pre> group_id : 그룹아이디 </pre> */
    @Transient
	private String _group_id;

    /***<pre> user_email : 사용자 email </pre> */
    @Transient
	private String _user_email;

    /***<pre> user_id : 사용자 ID </pre> */
    @Transient
	private String _user_id;

    /***<pre> office_code : 소속코드 </pre> */
    @Transient
	private String _office_code;

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