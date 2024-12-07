package dev.mugi.scaler.firstspringprojectscaler.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String title;
    private String description;
    private double price;
    private String imageURL;

    @ManyToOne(cascade = {CascadeType.PERSIST})

    private Category category;
}
