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
@Table(name = "SITE_POPUP_NOTICE_TARGET_GROUP")
public class SitePopupNoticeTargetGroup extends Common {
    @Transient
	private String keys = Arrays.toString(new String[]{});

    @Id

    /***<pre> notice_id :  </pre> */
	private String notice_id;

    /***<pre> group_id :  </pre> */
	private String group_id;

    /***<pre> system_create_date :  </pre> */
	private Date system_create_date;

    /***<pre> system_create_userid :  </pre> */
	private String system_create_userid;

    /***<pre> system_update_date :  </pre> */
	private Date system_update_date;

    /***<pre> system_update_userid :  </pre> */
	private String system_update_userid;



    /***<pre> notice_id :  </pre> */
    @Transient
	private String _notice_id;

    /***<pre> group_id :  </pre> */
    @Transient
	private String _group_id;

    /***<pre> system_create_date :  </pre> */
    @Transient
	private Date _system_create_date;

    /***<pre> system_create_userid :  </pre> */
    @Transient
	private String _system_create_userid;

    /***<pre> system_update_date :  </pre> */
    @Transient
	private Date _system_update_date;

    /***<pre> system_update_userid :  </pre> */
    @Transient
	private String _system_update_userid;


}