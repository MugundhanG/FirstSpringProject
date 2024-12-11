package dev.mugi.scaler.firstspringprojectscaler;

import dev.mugi.scaler.firstspringprojectscaler.model.Category;
import dev.mugi.scaler.firstspringprojectscaler.model.Product;
import dev.mugi.scaler.firstspringprojectscaler.projections.ProductTitleAndDesc;
import dev.mugi.scaler.firstspringprojectscaler.repositories.CategoryRepository;
import dev.mugi.scaler.firstspringprojectscaler.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class FirstSpringProjectScalerApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void test1() {
        Optional<Product> productOptional = productRepository
                .findByTitleAndCategory_name("iPhone", "phones");

        System.out.println(productOptional.get().getTitle());

    }

    @Test
    public void test2() {
        List<Product> productOptional = productRepository
                .getProductData("phones");

        System.out.println(productOptional.get(0).getTitle());

    }

    @Test
    public void test3() {
        Product productOptional = productRepository
                .getProductData2(1L);

        System.out.println(productOptional.getTitle());

    }

    @Test
    public void test4() {
        ProductTitleAndDesc productOptional = productRepository
                .getProductData3(1L);

        System.out.println(productOptional.getTitle() + " " + productOptional.getDescription());
    }

    @Test
    @Transactional
    public void testFetchTypes() {
        Optional<Category> category = categoryRepository.findById(1L);
        System.out.println(category.get().getName());
        System.out.println(category.get().getProducts());
    }

    @Test
    @Transactional
    public void nplus1Problem() {
        List<Category> categories = categoryRepository.findAll();

        for(Category category : categories) {
            for(Product product : category.getProducts()) {
                System.out.println(product.getTitle() + " " + product.getDescription());
            }
        }
    }

}
