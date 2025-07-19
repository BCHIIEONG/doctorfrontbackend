package com.jida.tijian.service;

import com.jida.tijian.dto.OrderListRequestDto;
import com.jida.tijian.dto.ResponseObject;

public interface OrdersService {
    ResponseObject ordersList(OrderListRequestDto orderListRequestDto);
}
