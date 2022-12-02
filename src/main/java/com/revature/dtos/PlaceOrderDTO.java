package com.revature.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.revature.models.Order;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlaceOrderDTO {

    private int id;
    private int userId;
    private double subtotal;

    public PlaceOrderDTO(Order order) {
        this.setId(order.getId());
        this.setUserId(order.getUser());
        this.setSubtotal(order.getSubtotal());
    }
}
