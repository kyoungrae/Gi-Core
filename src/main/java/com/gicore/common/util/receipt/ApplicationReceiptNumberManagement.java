package com.gicore.common.util.receipt;

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
@Table(name = "APPLICATION_RECEIPT_NUMBER_MANAGEMENT")
public class ApplicationReceiptNumberManagement extends Common {
	@Transient
	private String keys = Arrays.toString(new String[]{"receipt_year","receipt_code"});

   @Id

    /***<pre> receipt_year : 접수년도 </pre> */
	private String receipt_year;

    /***<pre> receipt_code : 구분코드 </pre> */
	private String receipt_code;

    /***<pre> receipt_name : 접수명 </pre> */
	private String receipt_name;

    /***<pre> last_sequence_number : 마지막 시퀀스 번호 </pre> */
	private String last_sequence_number;

    /***<pre> receipt_year : 접수년도 </pre> */
	@Transient
	private String _receipt_year;

    /***<pre> receipt_code : 구분코드 </pre> */
	@Transient
	private String _receipt_code;

    /***<pre> receipt_name : 접수명 </pre> */
	@Transient
	private String _receipt_name;

    /***<pre> _last_sequence_number : 마지막 시퀀스 번호 </pre> */
	@Transient
	private String _last_sequence_number;


}