package com.shopflow.domain.service;

import com.shopflow.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll(int page, int pageSize);

    Optional<Product> findByBarCode(String codeBar);

    void save(Product product);

    void deleteByCodeBar(String data);

    int count();
}
