package com.revature.controllers;


import com.revature.annotations.Authorized;
import com.revature.models.Order;
import com.revature.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Authorized
    @PutMapping
    public List<Order> createOrder() {

    }




    @GetMapping("/{userId}")
    public List<Order> findPreviousOrders(@PathVariable int userId) {

        return orderService.findPreviousOrders(userId);
    }
}