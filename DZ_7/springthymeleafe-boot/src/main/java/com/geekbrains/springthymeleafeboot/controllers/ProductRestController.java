package com.geekbrains.springthymeleafeboot.controllers;

import com.geekbrains.springthymeleafeboot.entities.Product;
import com.geekbrains.springthymeleafeboot.services.ProductService;
import com.geekbrains.springthymeleafeboot.utils.ProductErrorResponce;
import com.geekbrains.springthymeleafeboot.utils.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class ProductRestController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{productId")
    public Product getProductById (@PathVariable Long productId) {
        return productService.getProductById(productId);
    }

    @GetMapping("/products")
    public List<Product> getALlProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        product.setId(0L);
        product = productService.saveOrUpdate(product);
        return product;
    }

    @PutMapping(path = "/products", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Product updateProduct(@RequestBody Product product) {
        product = productService.saveOrUpdate(product);
        return product;
    }

    @DeleteMapping("/products/{productId}")
    public int deleteProductById(@PathVariable Long productId) {
        productService.delete(productId);
        return HttpStatus.OK.value();
    }

    @ExceptionHandler
    public ResponseEntity<ProductErrorResponce> handleException(ProductNotFoundException exc) {
        ProductErrorResponce productErrorResponce = new ProductErrorResponce();
        productErrorResponce.setStatus(HttpStatus.NOT_FOUND.value());
        productErrorResponce.setMessage(exc.getMessage());
        productErrorResponce.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(productErrorResponce, HttpStatus.NOT_FOUND);
    }
}
