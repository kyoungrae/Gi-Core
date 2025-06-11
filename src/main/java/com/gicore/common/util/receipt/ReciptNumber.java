package com.gicore.common.util.receipt;

import com.gicore.common.util.userinfo.UserInfo;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@RequiredArgsConstructor
public class ReciptNumber {
    private final ApplicationReceiptNumberManagementMapper applicationReceiptNumberManagementMapper;
    public String getReciptNumber(String receiptCode) throws Exception{
        String receiptNum;
        int reqYear;
        UserInfo userInfo = new UserInfo();
        String userEmail = userInfo.getUserEmail();

        var param = ApplicationReceiptNumberManagement.builder()
                .receipt_code(receiptCode)
                .build();
        try{
            List<ApplicationReceiptNumberManagement> list = applicationReceiptNumberManagementMapper.SELECT(param);
            reqYear = Integer.parseInt(list.get(0).getReceipt_year());
        }catch (Exception e){
            throw new Exception("error for Application Receipt Number List");
        }

        int nowYear = LocalDate.now().getYear();

        var param2 = ApplicationReceiptNumberManagement.builder()
                .receipt_year(String.valueOf(reqYear))
                .receipt_code(receiptCode)
                .system_create_userid(userEmail)
                .build();

        var param3 = ApplicationReceiptNumberManagement.builder()
                .receipt_year(String.valueOf(nowYear))
                .receipt_code(receiptCode)
                .build();

        if(nowYear != reqYear){
            try {
                applicationReceiptNumberManagementMapper.INSERT_APPLICATION_RECEIPT_NUMBER_HISTORY(param2);
                applicationReceiptNumberManagementMapper.UPDATE(param3);
                List<ApplicationReceiptNumberManagement> receiptList = applicationReceiptNumberManagementMapper.SELECT_RECEIPT_NUMBER(param);
                receiptNum = receiptList.get(0).getReceipt_number();
            }catch (Exception e){
                throw new Exception("error for Application Receipt Number history Insert");
            }
        }else{
            try{
                List<ApplicationReceiptNumberManagement> receiptList = applicationReceiptNumberManagementMapper.SELECT_RECEIPT_NUMBER(param);
                receiptNum = receiptList.get(0).getReceipt_number();

            }catch (Exception e){
                throw new Exception("error for Application Receipt Number");
            }
        }
        return receiptNum;
    }
    public void updateReceiptYear(){

    }
    public void deleteSequence(){

    }
}
