package dev.mugi.scaler.firstspringprojectscaler.repositories;

import dev.mugi.scaler.firstspringprojectscaler.model.Product;
import dev.mugi.scaler.firstspringprojectscaler.projections.ProductTitleAndDesc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product save(Product product);


    Optional<Product> findById(Long id);

    List<Product> findAll();

    Optional<Product> findByTitleAndCategory_name(String title, String category);

    @Query("select p from Product p where p.category.name = :categoryName")
    List<Product> getProductData(@Param("categoryName") String categoryName);

    @Query(value = "select * from product where id = :id", nativeQuery = true)
    Product getProductData2(@Param("id") Long id);

    @Query(value = "select title, description from product where id = :id", nativeQuery = true)
    ProductTitleAndDesc getProductData3(@Param("id") Long id);

}
