package com.jida.tijian.controller;

import com.jida.tijian.domain.Orders;
import com.jida.tijian.dto.ResponseObject;
import com.jida.tijian.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController
 *
 */
@RestController
public class ReportController {

    @Autowired
    ReportService reportService;


    //  axios异步请求：1.判断订单的状态，未归档才需要做这件事，做之前再看看有没有报告模板，有就不用重复创建了

    /**
     * 创建体检报告模板
     * @param
     * @return
     */
    @RequestMapping("/createReportTemplate")
    public ResponseObject createReportTemplate(@RequestBody Orders orders){
        return reportService.createReportTemplate(orders);
    }

}
