package com.revature.dtos;

import javax.validation.constraints.*;
import com.revature.models.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private int id;
    private int userId;

    public OrderDTO(Order order) {
        this.setId(order.getId());
    }
}
