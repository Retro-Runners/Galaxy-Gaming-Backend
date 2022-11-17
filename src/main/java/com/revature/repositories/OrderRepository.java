package com.revature.repositories;

import com.revature.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {


    List<Order> findPreviousOrdersByUserId(int userId);



}
