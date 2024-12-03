package dev.mugi.scaler.firstspringprojectscaler.controllers;

import dev.mugi.scaler.firstspringprojectscaler.dtos.CreateProductRequestDto;
import dev.mugi.scaler.firstspringprojectscaler.model.Product;
import dev.mugi.scaler.firstspringprojectscaler.services.FakeStoreProductService;
import dev.mugi.scaler.firstspringprojectscaler.services.ProductService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") Long id) {
        return productService.getProductDetails(id);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequestDto requestDto) {

        Product product = productService.createProduct(
                requestDto.getTitle(),
                requestDto.getDescription(),
                requestDto.getImage(),
                requestDto.getPrice(),
                requestDto.getCategory()
        );

        ResponseEntity<Product> responseEntity = new ResponseEntity<>(product, HttpStatusCode.valueOf(201));

        return responseEntity;
    }

}
