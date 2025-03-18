package com.shopflow.domain.service.impl;

import com.shopflow.common.annotation.DomainService;
import com.shopflow.domain.model.Product;
import com.shopflow.domain.repository.ProductRepository;
import com.shopflow.domain.service.ProductService;

import java.util.List;
import java.util.Optional;

@DomainService
public class ProductServiceImpl  implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findByBarCode(String barCode) {
        return productRepository.findByBarCode(barCode);
    }
}
