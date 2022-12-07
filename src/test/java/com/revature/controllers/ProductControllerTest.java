package com.revature.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.revature.dtos.ProductInfo;
import com.revature.models.Product;
import com.revature.services.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpSession;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    private List<Product> productList;
    private Product newProduct;
    private Product dataDBProduct;

    private Optional<Product> optionalProduct;
    private int id = 1;
    private String type = "Console";
    private String console = "N64";
    private String name = "Nintendo64 Gaming Console";
    private double price = 150;
    private int quantity = 10;
    private String description = "The best gaming console in the world";
    private String image = "";

    @BeforeEach
    public void populateProduct() {
        newProduct = new Product();
        newProduct.setId(id);
        newProduct.setType(type);
        newProduct.setConsole(console);
        newProduct.setName(name);
        newProduct.setPrice(price);
        newProduct.setQuantity(quantity);
        newProduct.setDescription(description);
        newProduct.setImage(image);

        dataDBProduct = new Product();
        dataDBProduct.setId(id);
        newProduct.setType(type);
        newProduct.setConsole(console);
        newProduct.setName(name);
        newProduct.setPrice(price);
        newProduct.setQuantity(quantity);
        newProduct.setDescription(description);
        newProduct.setImage(image);
    }

    // the upsert function inputs new product into products table
    @Test
    public void AddingProduct_ReturnsProduct() {

        Mockito.when(productService.save(newProduct)).thenReturn(dataDBProduct);

        ResponseEntity<Product> finalProduct = productController.upsert(newProduct);

        Assertions.assertEquals(dataDBProduct.getId(), finalProduct.getBody().getId());
        Assertions.assertEquals(dataDBProduct.getType(), finalProduct.getBody().getType());
        Assertions.assertEquals(dataDBProduct.getConsole(), finalProduct.getBody().getConsole());
        Assertions.assertEquals(dataDBProduct.getName(), finalProduct.getBody().getName());
        Assertions.assertEquals(dataDBProduct.getPrice(), finalProduct.getBody().getPrice());
        Assertions.assertEquals(dataDBProduct.getQuantity(), finalProduct.getBody().getQuantity());
        Assertions.assertEquals(dataDBProduct.getDescription(), finalProduct.getBody().getDescription());
        Assertions.assertEquals(dataDBProduct.getImage(), finalProduct.getBody().getImage());

    }

    // seeing if get inventory can return the list of products and their quantities
    @Test
    public void GetInventory_ReturnsProducts() {

        Mockito.when(productService.findAll()).thenReturn(productList);

        ResponseEntity<List<Product>> inventoryList = productController.getInventory();

        Assertions.assertEquals(ResponseEntity.ok(productList), inventoryList);

    }

    // seeing if getproductbyid can return products
    @Test
    public void ProductId_ReturnsProducts() {

        Mockito.when(productService.findById(id)).thenReturn(Optional.of(dataDBProduct));

        ResponseEntity<Product> finalProduct = productController.getProductById(id);

        Assertions.assertEquals(dataDBProduct.getId(), finalProduct.getBody().getId());
        Assertions.assertEquals(dataDBProduct.getType(), finalProduct.getBody().getType());
        Assertions.assertEquals(dataDBProduct.getConsole(), finalProduct.getBody().getConsole());
        Assertions.assertEquals(dataDBProduct.getName(), finalProduct.getBody().getName());
        Assertions.assertEquals(dataDBProduct.getPrice(), finalProduct.getBody().getPrice());
        Assertions.assertEquals(dataDBProduct.getQuantity(), finalProduct.getBody().getQuantity());
        Assertions.assertEquals(dataDBProduct.getDescription(), finalProduct.getBody().getDescription());
        Assertions.assertEquals(dataDBProduct.getImage(), finalProduct.getBody().getImage());

    }

    // testing the delete function
    @Test
    public void Delete_ReturnsProductToBeDeleted() {

        Mockito.when(productService.findById(id)).thenReturn(optionalProduct);

        ResponseEntity<Product> finalProduct = productController.deleteProduct(id);

        Assertions.assertEquals(dataDBProduct.getId(), finalProduct.getBody().getId());
        Assertions.assertEquals(dataDBProduct.getType(), finalProduct.getBody().getType();
        Assertions.assertEquals(dataDBProduct.getConsole(), finalProduct.getBody().getConsole());
        Assertions.assertEquals(dataDBProduct.getName(), finalProduct.getBody().getName());
        Assertions.assertEquals(dataDBProduct.getPrice(), finalProduct.getBody().getPrice());
        Assertions.assertEquals(dataDBProduct.getQuantity(), finalProduct.getBody().getQuantity());
        Assertions.assertEquals(dataDBProduct.getDescription(), finalProduct.getBody().getDescription());
        Assertions.assertEquals(dataDBProduct.getImage(), finalProduct.getBody().getImage());

    }

    // testing the purchase function
    @Test
    public void Purchase_Returns() {

    }

}