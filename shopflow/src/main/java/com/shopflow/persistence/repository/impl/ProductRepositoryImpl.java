package com.shopflow.persistence.repository.impl;

import com.shopflow.domain.model.Product;
import com.shopflow.domain.repository.ProductRepository;
import com.shopflow.persistence.dao.ProductDao;
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
    public List<Product> findAll(int page, int pageSize) {
        return productDao.findAll(page, pageSize);
    }

    @Override
    public Optional<Product> findByBarCode(String barCode) {
        return productDao.findByBarCode(barCode);
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public void deleteByCodeBar(String codeBar) {
        productDao.deleteByCodeBar(codeBar);
    }

    @Override
    public int count() {
        return productDao.count();
    }
}
