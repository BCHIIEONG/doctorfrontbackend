package com.jida.tijian.service;

import com.jida.tijian.domain.Orders;
import com.jida.tijian.dto.ResponseObject;
import org.springframework.transaction.annotation.Transactional;

public interface ReportService {
    @Transactional
        //要么都成功，要么都失败，失败就回滚
    ResponseObject createReportTemplate(Orders orders);
}
