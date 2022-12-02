package com.revature.services;

import com.revature.dtos.ProductInfo;
import com.revature.models.Order;
import com.revature.models.Product;
import com.revature.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    OrderItemsService orderItemsService;

    public void placeOrder(int userId, String sessionId) {
        CartDto cartDto = cartService.listCartItems(userId);

        PlaceOrderDto placeOrderDto = new PlaceOrderDto();
        placeOrderDto.setUserId(userId);
        placeOrderDto.setTotalPrice(cartDto.getTotalCost());

        int orderId = saveOrder(placeOrderDto, userId, sessionId);
        List<CartItemDto> cartItemDtoList = cartDto.getcartItems();
        for (CartItemDto cartItemDto : cartItemDtoList) {
            OrderItem orderItem = new OrderItem(
                    orderId,
                    cartItemDto.getProduct().getId(),
                    cartItemDto.getQuantity(),
                    cartItemDto.getProduct().getPrice());
            orderItemsService.addOrderedProducts(orderItem);
        }
        cartService.deleteCartItems(userId);
    }

    public int saveOrder(PlaceOrderDto orderDto, int userId, String sessionID){
        Order order = getOrderFromDto(orderDto,userId,sessionID);
        return orderRepository.save(order).getId();
    }

    private Order getOrderFromDto(PlaceOrderDto orderDto, int userId,String sessionID) {
        Order order = new Order(orderDto,userId,sessionID);
        return order;
    }


    public List<Order> findPreviousOrders(int userId) {

        return orderRepository.findPreviousOrdersByUserId(userId);
    }

}
