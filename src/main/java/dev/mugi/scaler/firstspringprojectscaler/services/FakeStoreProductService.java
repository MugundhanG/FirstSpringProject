package dev.mugi.scaler.firstspringprojectscaler.services;

import dev.mugi.scaler.firstspringprojectscaler.dtos.FakeStoreCreateProductDto;
import dev.mugi.scaler.firstspringprojectscaler.dtos.FakeStoreResponseProductDto;
import dev.mugi.scaler.firstspringprojectscaler.exceptions.ProductNotFoundException;
import dev.mugi.scaler.firstspringprojectscaler.model.Product;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public Product getProductDetails(Long id) throws ProductNotFoundException {
        FakeStoreResponseProductDto responseDto =
                restTemplate.getForObject(
                        "https://fakestoreapi.com/products/" + id,
                        FakeStoreResponseProductDto.class);


        ResponseEntity<FakeStoreResponseProductDto> responseEntity = restTemplate
                .getForEntity("https://fakestoreapi.com/products/" + id, FakeStoreResponseProductDto.class);

        if(responseEntity.getStatusCode() == HttpStatusCode.valueOf(404)) {
            //Handling 404 exception
        } else if(responseEntity.getStatusCode() == HttpStatusCode.valueOf(500)) {
            //FE and BE are not working properly
        }

        FakeStoreResponseProductDto responseBody = responseEntity.getBody();

        if(responseBody == null) {
            throw new ProductNotFoundException("Product Not Found");
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

        FakeStoreResponseProductDto responseDto =  restTemplate.postForObject(
                "https://fakestoreapi.com/products", requestDto, FakeStoreResponseProductDto.class);

        return responseDto.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreResponseProductDto[] responseDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products", FakeStoreResponseProductDto[].class);

        List<Product> products = new ArrayList<>();
        for(FakeStoreResponseProductDto dto : responseDto) {
            products.add(dto.toProduct());
        }

        return products;
    }

//    @Override
//    public void deleteProduct(Long id) throws ProductNotFoundException {
////        restTemplate.delete(id);
//    }
}
