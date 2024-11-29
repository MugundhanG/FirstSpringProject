package dev.mugi.scaler.firstspringprojectscaler.controllers;

import dev.mugi.scaler.firstspringprojectscaler.model.Product;
import dev.mugi.scaler.firstspringprojectscaler.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public void getAllProducts() {

    }

    @GetMapping("/products/id")
    public Product getProductDetails(@PathVariable("id") long id) {
        return null;
    }

    public void createProduct() {

    }

}
