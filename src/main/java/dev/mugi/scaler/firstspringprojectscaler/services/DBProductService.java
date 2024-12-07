package dev.mugi.scaler.firstspringprojectscaler.services;

import dev.mugi.scaler.firstspringprojectscaler.exceptions.ProductNotFoundException;
import dev.mugi.scaler.firstspringprojectscaler.model.Category;
import dev.mugi.scaler.firstspringprojectscaler.model.Product;
import dev.mugi.scaler.firstspringprojectscaler.repositories.CategoryRepository;
import dev.mugi.scaler.firstspringprojectscaler.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class DBProductService implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public DBProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Product getProductDetails(Long id) throws ProductNotFoundException {
        Optional<Product> productOptionalFromDb = productRepository.findById(id);

        Product productFromDb = productOptionalFromDb.get();

        System.out.println(productFromDb.getTitle());

        return productFromDb;
    }

    @Override
    public Product createProduct(String title, String description, String image, double price, String categoryName) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setImageURL(image);
        product.setPrice(price);

        Category categoryFromDatabase = categoryRepository.findByName(categoryName);

        if (categoryFromDatabase == null) {
            Category newCategory = new Category();
            newCategory.setName(categoryName);

            categoryFromDatabase = newCategory;

//          category = categoryRepository.save(category);
        }

        product.setCategory(categoryFromDatabase);

        return productRepository.save(product);
    };

    @Override
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    };
}
