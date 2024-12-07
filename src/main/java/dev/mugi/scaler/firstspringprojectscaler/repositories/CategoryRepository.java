package dev.mugi.scaler.firstspringprojectscaler.repositories;

import dev.mugi.scaler.firstspringprojectscaler.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(String name);

}
