package com.gicore.common.common.menu;

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
@Table(name = "COMMON_ACCESS_GROUP_MENU_LIST")
public class CommonAccessGroupMenuList extends Common {
    @Transient
	private String keys = Arrays.toString(new String[]{"menu_code","access_rights_group_id"});

    @Id

    /***<pre> menu_code :  </pre> */
	private String menu_code;

    /***<pre> access_rights_group_id :  </pre> */
	private String access_rights_group_id;

    /***<pre> system_create_date :  </pre> */
	private Date system_create_date;

    /***<pre> system_create_userid :  </pre> */
	private String system_create_userid;

    /***<pre> system_update_date :  </pre> */
	private Date system_update_date;

    /***<pre> system_update_userid :  </pre> */
	private String system_update_userid;



    /***<pre> menu_code :  </pre> */
    @Transient
	private String _menu_code;

    /***<pre> access_rights_group_id :  </pre> */
    @Transient
	private String _access_rights_group_id;

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

    // - - -
    private String access_right_group;
}