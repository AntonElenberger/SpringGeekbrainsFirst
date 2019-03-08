package com.geekbrains.springthymeleafeboot.repositories;

import com.geekbrains.springthymeleafeboot.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    Page<Product> findAllByCostBetween(Pageable pageable, double minCost, double maxCost);
    Product findOneByTitle(String title);
}
