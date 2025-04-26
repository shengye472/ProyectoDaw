package com.shopflow.persistence.dao.jpa.mapper;

import com.shopflow.domain.model.Product;
import com.shopflow.persistence.dao.jpa.model.ProductEntity;

public class ProductJpaMapper {

    public static ProductJpaMapper INSTANCE = new ProductJpaMapper();

    public Product toProduct(ProductEntity productEntity) {
        Product product = new Product();
        product.setBarCode(productEntity.getBarCode());
        product.setName(productEntity.getName());
        product.setPrice_sell(productEntity.getPrice_sell());
        product.setPrice_buy(productEntity.getPrice_buy());
        product.setStock(productEntity.getStock());
        return product;
    }
}
