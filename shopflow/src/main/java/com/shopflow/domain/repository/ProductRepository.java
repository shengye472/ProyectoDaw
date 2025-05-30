package com.shopflow.domain.repository;

import com.shopflow.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll(int page, int pageSize);

    Optional<Product> findByBarCode(String barCode);

    void save(Product product);

    void deleteByCodeBar(String codeBar);

    int count();
}
