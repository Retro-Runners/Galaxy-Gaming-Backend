package com.revature.services;

import com.revature.models.Order;
import com.revature.repositories.OrderRepository;
import com.revature.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OrderService {

    OrderRepository orderRepository;

    public List<Order> findPreviousOrders(int userId) {
        if(userId != null) return orderRepository.findPreviousOrdersByUserId(userId);
    }
}
