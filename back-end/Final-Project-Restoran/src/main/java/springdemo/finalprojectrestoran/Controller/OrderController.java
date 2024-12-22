package springdemo.finalprojectrestoran.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import springdemo.finalprojectrestoran.Service.OrderService;
import springdemo.finalprojectrestoran.dto.OrdersDto;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/saveOrder")
    ResponseEntity<Void> SaveOrder(@RequestBody OrdersDto ordersDto) {
       orderService.saveOrder(ordersDto);
       return ResponseEntity.created(URI.create("/orders/saveOrder")).build();
    }
}
