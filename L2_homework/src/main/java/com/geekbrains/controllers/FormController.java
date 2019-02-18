package com.geekbrains.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
    @RequestMapping("/showSimpleForm")
    public String showSimpleForm() {
        return "myform";
    }

    @RequestMapping(path="/advProcessForm", method= RequestMethod.GET)
    public String advProcessForm(@RequestParam("productId") String prodId, Model model) {
        prodId = "Product: " + prodId;
        model.addAttribute("attrProdId", prodId);
        return "myform-result-adv";
    }
}
