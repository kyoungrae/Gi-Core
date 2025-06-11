package com.gicore.common.util.receipt;

import com.gicore.common.common.CommonMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApplicationReceiptNumberManagementMapper extends CommonMapper<ApplicationReceiptNumberManagement> {
    void INSERT_APPLICATION_RECEIPT_NUMBER_HISTORY(ApplicationReceiptNumberManagement param);
    List<ApplicationReceiptNumberManagement> SELECT_RECEIPT_NUMBER(ApplicationReceiptNumberManagement param);
}