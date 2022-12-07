package com.revature.services;

import com.revature.models.Product;
import com.revature.models.User;
import com.revature.repositories.ProductRepository;
import com.revature.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ProductServiceTest {


    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    private List<Product> items;
    private Product item1;
    private Product item1FromDb;
    private Product item2;
    private Product item3;

    @BeforeEach
    public void populateObjects() {
        item1=new Product(5, "First Person Shooter", "https://upload.wikimedia.org/wikipedia/en/1/14/DuckHuntBox.jpg", "Duck Hunt", 37.99, 5, "NES", "Game");
        item2=new Product(3, "Strategy", "https://upload.wikimedia.org/wikipedia/en/thumb/7/7d/Tetris_NES_cover_art.jpg/220px-Tetris_NES_cover_art.jpg", "Tetris",19.95,4, "NES", "Game");
        item3 = new Product();
        //item3.setId();
        item1FromDb=new Product(5, "First Person Shooter", "https://upload.wikimedia.org/wikipedia/en/1/14/DuckHuntBox.jpg", "Duck Hunt", 37.99, 5, "NES", "Game");


        items = new ArrayList<Product>();
        items.add(item1);
        items.add(item2);

    }

    @Test
    void givenProductRepo_getProducts_returnsAllProducts() {
        // define your stubbing behavior

       Mockito.when(productRepository.findAll()).thenReturn(items);


        List<Product> dbItems = productRepository.findAll();

        Assertions.assertEquals(item1, dbItems.get(0));
        Assertions.assertEquals(item1.getId(), dbItems.get(0).getId());
        Assertions.assertEquals(item1.getQuantity(), dbItems.get(0).getQuantity());
        Assertions.assertEquals(item1.getName(), dbItems.get(0).getName());
        Assertions.assertEquals(item1.getType(), dbItems.get(0).getType());
        Assertions.assertEquals(item1.getImage(), dbItems.get(0).getImage());
        Assertions.assertEquals(item1.getConsole(), dbItems.get(0).getConsole());
        Assertions.assertEquals(item1.getDescription(), dbItems.get(0).getDescription());
        Assertions.assertEquals(item2, dbItems.get(1));
        Assertions.assertEquals(item2.getId(), dbItems.get(1).getId());
        Assertions.assertEquals(item2.getQuantity(), dbItems.get(1).getQuantity());
        Assertions.assertEquals(item2.getName(), dbItems.get(1).getName());
        Assertions.assertEquals(item2.getType(), dbItems.get(1).getType());
        Assertions.assertEquals(item2.getImage(), dbItems.get(1).getImage());
        Assertions.assertEquals(item2.getConsole(), dbItems.get(1).getConsole());
        Assertions.assertEquals(item2.getDescription(), dbItems.get(1).getDescription());

    }
    @Test
    void givenProduct_saveProductToList_returnsProductAddedToList() {
        Mockito.when(productRepository.save(item1)).thenReturn(item1FromDb);

        Product returnedProductAddedToDb = productRepository.save(item1);

        Assertions.assertEquals(item1FromDb, returnedProductAddedToDb);
        Assertions.assertEquals(item1FromDb.getId(), returnedProductAddedToDb.getId());
        Assertions.assertEquals(item1FromDb.getQuantity(), returnedProductAddedToDb.getQuantity());
        Assertions.assertEquals(item1FromDb.getName(), returnedProductAddedToDb.getName());
        Assertions.assertEquals(item1FromDb.getType(), returnedProductAddedToDb.getType());
        Assertions.assertEquals(item1FromDb.getImage(), returnedProductAddedToDb.getImage());
        Assertions.assertEquals(item1FromDb.getConsole(), returnedProductAddedToDb.getConsole());
        Assertions.assertEquals(item1FromDb.getDescription(), returnedProductAddedToDb.getDescription());
    }
    @Test
    void givenProductList_saveProductListToDB_returnsProductListAddedToDb() {

        Mockito.when(productRepository.saveAll(items)).thenReturn(items);


    }
}
