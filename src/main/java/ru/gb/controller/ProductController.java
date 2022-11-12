package ru.gb.controller;

import ru.gb.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("productList", productService.getProductList());
        return "products";
    }

    @GetMapping("/show_form")
    public String showFormPage() {
        return "product_form";
    }

    @PostMapping("/product_add")
    public String addProduct(@RequestParam Long id,@RequestParam String title, @RequestParam String cost) {
        Product product = new Product(id, title,Double.valueOf(cost));
        productService.add(product);
        return "redirect:/products";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam Long id, Model model) {
        productService.deleteById(id);
        model.addAttribute("productList", productService.getProductList());
        return "redirect:/products";
    }
}
