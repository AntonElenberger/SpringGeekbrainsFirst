package com.geekbrains.repositories;

import com.geekbrains.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductsRepository extends PagingAndSortingRepository<Product, Long> {
    List<Product> findAllByCostBetween(Double min, Double max);
    Page<Product> findAllProducts(Pageable pageable);

}
