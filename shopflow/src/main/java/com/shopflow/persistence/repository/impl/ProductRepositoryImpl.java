package com.shopflow.persistence.repository.impl;

import com.shopflow.domain.model.Product;
import com.shopflow.domain.repository.ProductRepository;
import com.shopflow.persistance.dao.ProductDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductDao productDao;

    public ProductRepositoryImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Optional<Product> findByBarCode(String barCode) {
        return productDao.findByBarCode(barCode);
    }
}
