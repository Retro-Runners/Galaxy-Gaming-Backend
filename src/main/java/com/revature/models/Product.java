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
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity; // inventory
    private String price;
    private String description;
    private String image;
    private String name;
    private String type; // Console, Accessory,  Game
    private String console; // NES, SNES, GBA, N64, GC
}
