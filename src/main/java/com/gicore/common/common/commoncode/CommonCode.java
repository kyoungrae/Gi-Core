package com.gicore.common.common.commoncode;

import com.gicore.common.common.Common;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Transient;

import java.util.Arrays;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "COMMON_CODE")
public class CommonCode extends Common {
    @Transient
    private String keys = Arrays.toString(new String[]{"code_id","group_id"});

    @Id

    /***<pre> code_id : 코드ID </pre> */
    private String code_id;

    /***<pre> group_id : 그룹ID </pre> */
    private String group_id;

    /***<pre> code_name : 그룹명 </pre> */
    private String code_name;

    /***<pre> code_number : 노출순서 </pre> */
    private String code_number;

    /***<pre> use_yn : 사용여부 </pre> */
    private String use_yn;


    /***<pre> code_id : 코드ID </pre> */
    @Transient
    private String _code_id;

    /***<pre> group_id : 그룹ID </pre> */
    @Transient
    private String _group_id;

    /***<pre> code_name : 그룹명 </pre> */
    @Transient
    private String _code_name;

    /***<pre> code_number : 노출순서 </pre> */
    @Transient
    private String _code_number;

    /***<pre> use_yn : 사용여부 </pre> */
    @Transient
    private String _use_yn;
}