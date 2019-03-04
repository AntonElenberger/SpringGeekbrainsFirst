package com.geekbrains.dao;

import com.geekbrains.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends CrudRepository <Product, Long> {
//    List<Product> findAll();
}
