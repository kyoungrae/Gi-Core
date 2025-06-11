package com.gicore.common.common.mail;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mail {

    /***<pre> title : 메일제목 </pre> */
    private String title;

    /***<pre> content : 메일내용 </pre> */
    private String content;

    /***<pre> to_email : 받을 이메일 주소 </pre> */
    private List<String> email_list;

    /***<pre> scheduled_time : 예약시간 </pre> */
    private Date scheduled_date;

    /***<pre> uuid : 첨부파일 (test중)</pre> */
    private String uuid;

    /***<pre> mail_id : 대량 발송 시 key가 되는 mail_id</pre> */
    private String mail_id;

}
