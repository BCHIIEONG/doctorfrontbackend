package com.jida.tijian.mapper;

import com.jida.tijian.domain.Orders;
import com.jida.tijian.dto.OrderListRequestDto;
import com.jida.tijian.dto.OrderListResponseDto;

import java.util.List;

public interface OrdersMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    List<OrderListResponseDto> ordersList(OrderListRequestDto orderListRequestDto);
}