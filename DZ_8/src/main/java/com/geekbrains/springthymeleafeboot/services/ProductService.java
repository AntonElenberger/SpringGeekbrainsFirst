package com.geekbrains.springthymeleafeboot.services;

import com.geekbrains.springthymeleafeboot.entities.Product;
import com.geekbrains.springthymeleafeboot.repositories.ProductRepository;
import com.geekbrains.springthymeleafeboot.utils.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findOneByTitle(String title) {
        return productRepository.findOneByTitle(title);
    }

    public Product finOneById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public Page<Product> getProductByCost(Pageable pageable, Double min, Double max) {
        if (min == null) min = 0.0;
        if (max == null) max = Double.MAX_VALUE;
        return productRepository.findAllByCostBetween(pageable, min, max);
    }

    public Product saveOrUpdate(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(!product.isPresent()) throw new ProductNotFoundException("Product with such id:" + id + " not exists");
        return product.get();
    }

    public void delete(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(!product.isPresent()) throw new ProductNotFoundException("Product with such id:" + id + " not exists");
        productRepository.delete(product.get());
    }
}
