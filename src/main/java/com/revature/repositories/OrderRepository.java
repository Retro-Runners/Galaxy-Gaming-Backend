package com.revature.repositories;

public class OrderRepository {

    List<Order> findPreviousOrdersByUserId(int userId);
}
