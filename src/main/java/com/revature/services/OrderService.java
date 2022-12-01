package com.revature.services;

import com.revature.dtos.ProductInfo;
import com.revature.models.Order;
import com.revature.models.Product;
import com.revature.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    OrderRepository orderRepository;

    public List<Order> findPreviousOrders(int userId) {

        return orderRepository.findPreviousOrdersByUserId(userId);
    }

}
