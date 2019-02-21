package com.geekbrains.services;

import com.geekbrains.dao.ProductsRepository;
import com.geekbrains.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private static ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public static List<Product> getAllProducts() {
        return (List<Product>)productsRepository.findAll();
    }
}
