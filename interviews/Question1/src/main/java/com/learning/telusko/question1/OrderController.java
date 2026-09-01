package com.learning.telusko.question1;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/summary")
    public ResponseEntity<OrderSummaryResponse> getOrderSummary(@Valid @RequestBody OrderSummaryRequest request){
        OrderSummaryResponse summaryResponse =orderService.getSummary(request);
        return  ResponseEntity.ok(summaryResponse);
    }
}

/**
 *  ResponseEntity.ok(summaryResponse);
 */