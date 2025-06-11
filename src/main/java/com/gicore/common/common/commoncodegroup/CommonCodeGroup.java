package com.gicore.common.common.commoncodegroup;

import com.gicore.common.common.Common;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Arrays;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "COMMON_CODE_GROUP")
public class CommonCodeGroup extends Common {
    @Transient
    private String keys = Arrays.toString(new String[]{"group_id"});


    /***<pre> group_id :  </pre> */
    @Id
    private String group_id;

    /***<pre> group_name :  </pre> */
    private String group_name;

    /***<pre> use_yn :  </pre> */
    private String use_yn;

    /***<pre> comment : 설명 </pre> */
    private String comment;



    /***<pre> group_id :  </pre> */
    @Transient
    private String _group_id;

    /***<pre> group_name :  </pre> */
    @Transient
    private String _group_name;

    /***<pre> use_yn :  </pre> */
    @Transient
    private String _use_yn;


}