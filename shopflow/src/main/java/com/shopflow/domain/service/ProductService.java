package com.shopflow.domain.service;

import com.shopflow.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    Optional<Product> findByBarCode(String barCode);
}
