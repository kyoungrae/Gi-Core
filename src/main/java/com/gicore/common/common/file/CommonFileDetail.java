package com.gicore.common.common.file;

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
@Table(name = "COMMON_FILE_DETAIL")
public class CommonFileDetail extends Common {

	@Transient
    private String keys = Arrays.toString(new String[]{"file_id","uuid"});

   @Id

    /***<pre> file_id : 파일아이디 </pre> */
	private String file_id;

    /***<pre> uuid : 공통아이디 </pre> */
	private String uuid;

    /***<pre> file_name : 파일이름 </pre> */
	private String file_name;

    /***<pre> file_size : 파일크기 </pre> */
	private String file_size;

    /***<pre> file_extension : 파일확장자 </pre> */
	private String file_extension;

    /***<pre> file_path : 파일경로 </pre> */
	private String file_path;

    /***<pre> file_description : 파일메모 </pre> */
	private String file_description;


    /***<pre> file_id : 파일아이디 </pre> */
	@Transient
    private String _file_id;

    /***<pre> uuid : 공통아이디 </pre> */
	@Transient
    private String _uuid;

    /***<pre> file_name : 파일이름 </pre> */
	@Transient
    private String _file_name;

    /***<pre> file_size : 파일크기 </pre> */
	@Transient
    private String _file_size;

    /***<pre> file_extension : 파일확장자 </pre> */
	@Transient
    private String _file_extension;

    /***<pre> file_path : 파일경로 </pre> */
	@Transient
    private String _file_path;

    /***<pre> file_description : 파일메모 </pre> */
	@Transient
    private String _file_description;


}