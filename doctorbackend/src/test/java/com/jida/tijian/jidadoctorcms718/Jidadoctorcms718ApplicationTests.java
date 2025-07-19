package com.jida.tijian.jidadoctorcms718;

import com.jida.tijian.dto.OrderListRequestDto;
import com.jida.tijian.dto.OrderListResponseDto;
import com.jida.tijian.mapper.OrdersMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Jidadoctorcms718ApplicationTests {

    @Autowired
    OrdersMapper ordersMapper;

    @Test
    void orderList() {
        OrderListRequestDto orderListRequestDto=new OrderListRequestDto();
       // orderListRequestDto.setSex(1);
       // orderListRequestDto.setState(1);
        orderListRequestDto.setRealName("叶文洁");
      List<OrderListResponseDto> orderListResponseDto= ordersMapper.ordersList(orderListRequestDto);

      for(OrderListResponseDto od:orderListResponseDto){
          System.out.println(od.getOrderId()+","+od.getRealName()+","+od.getHname());
      }
    }

}
