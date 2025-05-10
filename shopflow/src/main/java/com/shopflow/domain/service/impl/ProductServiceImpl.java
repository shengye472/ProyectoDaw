package com.shopflow.domain.service.impl;

import com.shopflow.common.annotation.DomainService;
import com.shopflow.domain.model.Product;
import com.shopflow.domain.repository.ProductRepository;
import com.shopflow.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@DomainService
public class ProductServiceImpl  implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findByBarCode(String codeBar) {
        return productRepository.findByBarCode(codeBar);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteByCodeBar(String codeBar) {
        productRepository.deleteByCodeBar(codeBar);
    }
}
