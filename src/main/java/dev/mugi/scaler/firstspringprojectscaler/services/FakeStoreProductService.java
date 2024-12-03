package dev.mugi.scaler.firstspringprojectscaler.services;

import dev.mugi.scaler.firstspringprojectscaler.dtos.CreateProductRequestDto;
import dev.mugi.scaler.firstspringprojectscaler.dtos.FakeStoreCreateProductDto;
import dev.mugi.scaler.firstspringprojectscaler.dtos.FakeStoreProductDto;
import dev.mugi.scaler.firstspringprojectscaler.model.Category;
import dev.mugi.scaler.firstspringprojectscaler.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductDetails(Long id) {
        FakeStoreProductDto responseDto =
                restTemplate.getForObject(
                        "https://fakestoreapi.com/products/" + id,
                        FakeStoreProductDto.class);


        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate
                .getForEntity("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);

        if(responseEntity.getStatusCode() == HttpStatusCode.valueOf(404)) {
            //Handling 404 exception
        } else if(responseEntity.getStatusCode() == HttpStatusCode.valueOf(500)) {
            //FE and BE are not working properly
        }

        return responseEntity.getBody().toProduct();
    }

    @Override
    public Product createProduct(String title, String description, String image, double price, String category) {

        FakeStoreCreateProductDto requestDto = new FakeStoreCreateProductDto();
        requestDto.setTitle(title);
        requestDto.setDescription(description);
        requestDto.setImage(image);
        requestDto.setPrice(price);
        requestDto.setCategory(category);

        FakeStoreProductDto responseDto =  restTemplate.postForObject(
                "https://fakestoreapi.com/products", requestDto, FakeStoreProductDto.class);

        return responseDto.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] responseDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products", FakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto dto : responseDto) {
            products.add(dto.toProduct());
        }

        return products;
    }
}
