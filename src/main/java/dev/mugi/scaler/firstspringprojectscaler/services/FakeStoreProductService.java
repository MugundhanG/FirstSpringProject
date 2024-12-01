package dev.mugi.scaler.firstspringprojectscaler.services;

import dev.mugi.scaler.firstspringprojectscaler.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class FakeStoreProductService implements ProductService {
    @Override
    public Product getProductDetails(Long id) {
        return null;
    }
}
