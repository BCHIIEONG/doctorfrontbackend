package com.jida.tijian.service;

import com.jida.tijian.domain.Cidetailedreport;
import com.jida.tijian.domain.Cireport;
import com.jida.tijian.domain.Orders;
import com.jida.tijian.dto.ResponseObject;
import com.jida.tijian.mapper.CheckitemdetailedMapper;
import com.jida.tijian.mapper.CidetailedreportMapper;
import com.jida.tijian.mapper.CireportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.xml.ws.Response;
import java.util.List;

/**
 * 体检报告业务类
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    CireportMapper cireportMapper;
    @Autowired
    CheckitemdetailedMapper checkitemdetailedMapper;
    @Autowired
    CidetailedreportMapper cidetailedreportMapper;

    /**
     * 创建体检报告模板
     */
    @Override
    @Transactional  //要么都成功，要么都失败，失败就回滚
    public ResponseObject createReportTemplate(Orders orders){  //参数：orderId smId
        /*
        1.判断该订单是否已经创建报告模板?
        已经创建，就直接返回结果，告诉前端
        没有创建，创建就行了
        2.怎么创建？
         */

        //1.判断该订单是否已经创建报告模板?
      List<Cireport> cireportList= cireportMapper.selectByOrderId(orders.getOrderId());
      if(cireportList.size()>0){
          return new ResponseObject(ResponseObject.SUCCESS_STATUS,ResponseObject.SUCCESS_DESC);
      }else{
          //2.怎么创建？
          //根据套餐编号查大项往报告表中插入数据
        List<Cireport> cireports=cireportMapper.selectBySmId(orders.getSmId());

        for(Cireport cireport:cireports){
                cireport.setOrderId(orders.getOrderId());
            cireportMapper.insert(cireport);
        }

        //int a=10/0; //你们可以测试事务的效果

        //根据大项查小项往报告详情表中插入数据
         List<Cidetailedreport> cidetailedreports=checkitemdetailedMapper.selectBySmId(orders.getSmId());

        for(Cidetailedreport cd:cidetailedreports){
            cd.setOrderId(orders.getOrderId());
            cidetailedreportMapper.insertSelective(cd);
        }
          return new ResponseObject(ResponseObject.SUCCESS_STATUS,ResponseObject.SUCCESS_DESC);
      }







    }

}
