package com.geekbrains.services;

import com.geekbrains.repositories.ProductsRepository;
import com.geekbrains.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private static ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }


    public static List<Product> filter(Double min, Double max) {
        if(min != null && max != null) {
            return productsRepository.findAllByCostBetween(min, max);
        } else if(min == null && max != null) {
            min = 0D;
            return productsRepository.findAllByCostBetween(min, max);
        } else if(min != null & max == null) {
            max = Double.MAX_VALUE;
            return productsRepository.findAllByCostBetween(min, max);
        } else {
            return (List<Product>) productsRepository.findAll();
        }

    }

    public List<Product> getAllProducts() {
        return (List<Product>)productsRepository.findAll();
    }

    public Product saveOrUpdate(Product product) {
        return productsRepository.save(product);
    }


}
