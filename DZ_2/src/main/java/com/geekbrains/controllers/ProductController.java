package com.geekbrains.controllers;


import com.geekbrains.entities.Product;
import com.geekbrains.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    // http://localhost:8189/app/products/showProductById?id=5
    @RequestMapping(path="/showProductById", method= RequestMethod.GET)
    public String showProductById(Model model, @RequestParam Long id) {
        Product product = productService.findProductById(id);
        model.addAttribute("product", product);
        return "product-form-result";
    }

    // http://localhost:8189/app/products/processForm
    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("product") Product product) {
        return "product-form-result";
    }

    // http://localhost:8189/app/products/showForm
    @RequestMapping("/showForm")
    public String showSimpleForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "product-form";
    }
}
