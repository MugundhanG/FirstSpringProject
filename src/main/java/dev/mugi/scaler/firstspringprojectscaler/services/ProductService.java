package dev.mugi.scaler.firstspringprojectscaler.services;

import dev.mugi.scaler.firstspringprojectscaler.dtos.CreateProductRequestDto;
import dev.mugi.scaler.firstspringprojectscaler.exceptions.ProductNotFoundException;
import dev.mugi.scaler.firstspringprojectscaler.model.Product;

import java.util.List;

public interface ProductService {
    public Product getProductDetails(Long id) throws ProductNotFoundException;

    public Product createProduct(String title, String description, String image, double price, String Category);

    public List<Product> getAllProducts();
}
