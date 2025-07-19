package com.jida.tijian.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jida.tijian.dto.OrderListRequestDto;
import com.jida.tijian.dto.OrderListResponseDto;
import com.jida.tijian.dto.ResponseObject;
import com.jida.tijian.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersMapper ordersMapper;

    @Override
    public ResponseObject ordersList(OrderListRequestDto orderListRequestDto){

        PageHelper.startPage(orderListRequestDto.getPageNumber(),orderListRequestDto.getPageSize());

        List<OrderListResponseDto> orderListResponseDtoList= ordersMapper.ordersList(orderListRequestDto);

        //分页相关的结果：总记录数  总页数
        PageInfo<OrderListResponseDto> pageinfo=new PageInfo<>(orderListResponseDtoList);

        /**
         返回给前端的结果：
         ResponseObject：
               status:200
               desc: 成功
               数据：
                   分页相关数据
                       总记录数：24
                        总页数：3
                       当前页：1
                   订单列表数据
                       orderListResponseDtoList
         */

        return new ResponseObject(ResponseObject.SUCCESS_STATUS,ResponseObject.SUCCESS_DESC,pageinfo);
    }

}