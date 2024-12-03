package dev.mugi.scaler.firstspringprojectscaler.dtos;


import dev.mugi.scaler.firstspringprojectscaler.model.Category;
import dev.mugi.scaler.firstspringprojectscaler.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreCreateProductDto {
    String title;
    double price;
    String category;
    String description;
    String image;
}
