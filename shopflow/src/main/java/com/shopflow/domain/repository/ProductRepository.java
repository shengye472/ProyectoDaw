package com.shopflow.domain.repository;

import com.shopflow.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();

    Optional<Product> findByBarCode(String barCode);
}
