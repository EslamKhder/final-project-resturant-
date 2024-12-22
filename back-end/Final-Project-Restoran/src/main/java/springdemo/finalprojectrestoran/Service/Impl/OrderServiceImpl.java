package springdemo.finalprojectrestoran.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import springdemo.finalprojectrestoran.Mapper.ClientMapper;
import springdemo.finalprojectrestoran.Mapper.OrderMapper;
import springdemo.finalprojectrestoran.Mapper.ProductMapper;
import springdemo.finalprojectrestoran.Repository.Jwt.ClientRepository;
import springdemo.finalprojectrestoran.Repository.OrdersRepository;
import springdemo.finalprojectrestoran.Repository.ProductRepository;
import springdemo.finalprojectrestoran.Service.Jwt.ClientService;
import springdemo.finalprojectrestoran.Service.OrderService;
import springdemo.finalprojectrestoran.Service.ProductService;
import springdemo.finalprojectrestoran.dto.Jwt.ClientDto;
import springdemo.finalprojectrestoran.dto.OrdersDto;
import springdemo.finalprojectrestoran.dto.ProductDto;
import springdemo.finalprojectrestoran.model.ClientModels.Client;
import springdemo.finalprojectrestoran.model.Orders;
import springdemo.finalprojectrestoran.model.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl  implements OrderService {

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    ClientService clientService;

    @Autowired
    ProductService productService;

//    @Override
//    public void saveOrder(OrdersDto ordersDto) {
//
//        Orders order = OrderMapper.ORDER_MAPPER.toEntity(ordersDto);
//
//        ordersRepository.save(order);
//
//    }

    @Override
    public String saveOrder(OrdersDto ordersDto) {

        List<Product> products = ProductMapper.PRODUCT_MAPPER.toEntityList(productService.findProductsByIds(ordersDto.getProductsIds()));
        // TO DO  get client from auth context
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Client client = null;

        Orders orders = OrderMapper.ORDER_MAPPER.toEntity(ordersDto);
        orders.setClient(client);
        orders.setProducts(products);

        ordersRepository.save(orders);

        return orders.getCode();
    }


}
