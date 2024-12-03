package dev.mugi.scaler.firstspringprojectscaler.dtos;

import dev.mugi.scaler.firstspringprojectscaler.model.Category;
import dev.mugi.scaler.firstspringprojectscaler.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;

    public Product toProduct() {
        Product product = new Product();
        product.setId(getId());
        product.setTitle(getTitle());
        product.setDescription(getDescription());
        product.setPrice(getPrice());
        product.setImageURL(getImage());

        Category category = new Category();
        category.setName(getCategory());

        product.setCategory(category);

        return product;
    }
}
