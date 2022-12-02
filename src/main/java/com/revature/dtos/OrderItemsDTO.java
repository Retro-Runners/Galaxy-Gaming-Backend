package com.revature.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemsDTO {

    private double price;
    private int quantity;
    private int orderId;
    private int productId;
}
