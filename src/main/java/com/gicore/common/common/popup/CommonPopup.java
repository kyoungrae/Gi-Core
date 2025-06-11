package com.gicore.common.common.popup;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gicore.common.common.Common;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Arrays;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "COMMON_POPUP")
public class CommonPopup extends Common {

	@Transient
	private String keys = Arrays.toString(new String[]{"popup_id", "popup_input_index"});

   	@Id
    /***<pre> popup_id : 팝업 ID </pre> */
	@JsonProperty("popup_id")
	private String popup_id;

    /***<pre> popup_name : 팝업 이름 </pre> */
	private String popup_name;

	/***<pre> popup_input_index : 팝업 내 Input INDEX </pre> */
	private String popup_input_index;

	/***<pre> popup_input_id : 팝업 내 Input ID </pre> */
	private String popup_input_id;

	/***<pre> popup_label_name : 팝업 내 Input 라벨 이름 </pre> */
	private String popup_label_name;

	/***<pre> popup_search_button_id : 팝업 내 검색버튼 ID </pre> */
	private String popup_search_button_id;

	/***<pre> popup_type : 팝업 타입(1: 그리드, 2:솔리드 등) </pre> */
	private String popup_type;

	@Transient
	private String[] popup_ids;



}