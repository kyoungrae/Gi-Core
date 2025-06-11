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
@Table(name = "SITE_BANNER_IMAGE")
public class SiteBannerImage extends Common {
    @Transient
	private String keys = Arrays.toString(new String[]{"uuid"});

    @Id

    /***<pre> uuid : 공통파일UUID </pre> */
	private String uuid;

    /***<pre> banner_image_number : 순번 </pre> */
	private Integer banner_image_number;

    /***<pre> use_yn : 사용여부 </pre> */
	private String use_yn;

    /***<pre> system_create_date : 작성일자 </pre> */
	private Date system_create_date;

    /***<pre> system_create_userid : 작성자ID </pre> */
	private String system_create_userid;

    /***<pre> system_update_date : 수정일자 </pre> */
	private Date system_update_date;

    /***<pre> system_update_userid : 수정자ID </pre> */
	private String system_update_userid;



    /***<pre> uuid : 공통파일UUID </pre> */
    @Transient
	private String _uuid;

    /***<pre> banner_image_number : 순번 </pre> */
    @Transient
	private Integer _banner_image_number;

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