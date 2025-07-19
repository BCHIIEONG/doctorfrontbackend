package com.jida.tijian.controller;

import com.jida.tijian.dto.OrderListRequestDto;
import com.jida.tijian.dto.ResponseObject;
import com.jida.tijian.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {
    @Autowired
    OrdersService ordersService;



    @RequestMapping("/ordersList")  //users--->springMVC参数依赖注入--->orderListRequestDto
    public ResponseObject ordersList(@RequestBody OrderListRequestDto orderListRequestDto){
        System.out.println("sex:"+orderListRequestDto.getSex());
        return ordersService.ordersList(orderListRequestDto);
    }

    //思路：controller--》service---》mapper----》sql
    // 需要分页插件（MyBatis提供的）
    //

    /**
     医生端查询订单列表

     请求对象应该怎样定义？

     userId  realName  sex  smId  orderDate  state  pageNumber  pageSize


     响应对象应该怎样定义？

     ResponseObject T

     T？
     Class （o.orderId,o.orderDate,u.userId,u.realName,u.sex,s.sname,h.hpId,hname）
        还有分页相关的数据：总记录数   总页数   当前第几页

     */

    /**

     select
     o.orderId,o.orderDate,o.state,u.userId,u.realName,u.sex,s.smId,s.name as sname,h.hpId,h.name as hname
     from orders o,users u,setmeal s,hospital h

     where o.userId=u.userId
     and
     o.smId=s.smId
     and
     o.hpId=h.hpId
     and
     u.sex=0
     and
     o.state=1
     order by o.orderDate
     */
}