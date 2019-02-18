package com.geekbrains.repositiries;

import com.geekbrains.entities.Product;
import org.springframework.stereotype.Component;

//create ArrayList with products, they will be shown from it through and added too.

@Component
public class ProductRepository {

    public Product findProductById(Long id) {
        Product product = new Product();
        product.setId(id);
        product.setTitle("Test");
        product.setCost(1.0);
        return product;
    }




}
