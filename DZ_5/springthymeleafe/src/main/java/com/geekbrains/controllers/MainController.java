package com.geekbrains.controllers;


import com.geekbrains.entities.Product;
import com.geekbrains.repositories.ProductsRepository;
import com.geekbrains.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class MainController {
    private ProductService productService;
    private ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

//    @RequestMapping(path = "/", method = RequestMethod.GET)
//    public String showHomePage(
//            @RequestParam(value = "min", required = false) Double min,
//            @RequestParam(value = "max", required = false) Double max,
//            Model model
//    ) {
//        model.addAttribute("products", ProductService.filter(min, max));
//        return "index";
//    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getProducts(
            @PageableDefault(size = 10) Pageable pageable,
            Model model
    ) {
        Page<Product> product = productsRepository.findAllProducts(pageable);
        model.addAttribute("products", product);
        return "index";
    }

    @GetMapping("/info")
    public String showInfoPage(Model model) {
        return "info";
    }

    @GetMapping("/product/add")
    public String addProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "add-product";
    }

    @PostMapping("/product/add")
    public String addProduct(Model model, @ModelAttribute("product") Product product) {
        productService.saveOrUpdate(product);
        return "redirect:/";
    }
}
