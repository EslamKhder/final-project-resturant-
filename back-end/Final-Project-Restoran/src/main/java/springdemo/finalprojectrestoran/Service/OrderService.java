package springdemo.finalprojectrestoran.Service;


import springdemo.finalprojectrestoran.dto.OrdersDto;
import springdemo.finalprojectrestoran.model.Orders;

import java.util.List;

public interface OrderService {

     String saveOrder(OrdersDto ordersDto);
}
