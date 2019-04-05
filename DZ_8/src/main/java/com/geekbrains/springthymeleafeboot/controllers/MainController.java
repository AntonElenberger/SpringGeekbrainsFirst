package com.geekbrains.springthymeleafeboot.controllers;

import com.geekbrains.springthymeleafeboot.entities.Product;
import com.geekbrains.springthymeleafeboot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class MainController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String showHomePage(Model model,
                               @RequestParam(value = "min", required = false) Double min,
                               @RequestParam(value = "max",required = false) Double max) {
        Page<Product> page = productService.getProductByCost(PageRequest.of(0, 5), min, max);
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        model.addAttribute("page", page);
        return "index";
    }

    @GetMapping("/info")
    public String showInfoPage(Model model) {
        return "info";
    }

    @GetMapping("/product/edit/{id}")
    public String addProduct(Model model, @PathVariable("id") Long id) {
        Product product = productService.finOneById(id);
        if(product == null) product = new Product();
        model.addAttribute("product", product);
        return "edit-product";
    }

    @GetMapping("/international")
    public String internationalPage() {
        return "international";
    }

    @PostMapping("/product/edit")
    public String AddProduct(@Valid @ModelAttribute("product") Product product,
                             BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) return "edit-product";
        Product existing = productService.findOneByTitle(product.getTitle());
        if(existing != null && !product.getId().equals(existing.getId())) {
            model.addAttribute("product", product);
            model.addAttribute("productCreationError", "Product title already exists");
            return "edit-product";
        }
        productService.saveOrUpdate(product);
        return "redirect:/";
    }
}
