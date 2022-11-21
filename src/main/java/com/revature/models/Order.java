package com.revature.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @JoinColumn(name = "user.userId")
    private int UserId;

    @Column
    @JoinColumn(name = "productId")
    private int[] productIds;

    @Column
    private int[] quantities;

    @Column
    private double subtotal;

}