package com.example.main.service;

import com.example.main.model.Product;
import com.example.main.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository repo;

    public List<Product> getAllProduct() {
        return repo.findAll();
    }

    public void addProduct(Product product) {
            repo.save(product);
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(new Product());
    }
}
