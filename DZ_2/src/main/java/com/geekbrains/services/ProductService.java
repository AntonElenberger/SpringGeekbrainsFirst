package com.geekbrains.services;


import com.geekbrains.entities.Product;
import com.geekbrains.repositiries.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Product findProductById(Long id) {
        Product product = productRepository.findProductById(id);
        return product;
    }

}
