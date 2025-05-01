package com.shopflow.persistence.dao.jpa.mapper;

import com.shopflow.domain.model.Product;
import com.shopflow.persistence.dao.jpa.model.ProductEntity;

public class ProductJpaMapper {

    public static ProductJpaMapper INSTANCE = new ProductJpaMapper();

    public Product toProduct(ProductEntity productEntity) {
        Product product = new Product();
        product.setId(productEntity.getId());
        product.setBarCode(productEntity.getBarCode());
        product.setName(productEntity.getName());
        product.setPrice_sell(productEntity.getPrice_sell());
        product.setPrice_buy(productEntity.getPrice_buy());
        product.setStock(productEntity.getStock());
        return product;
    }

    public ProductEntity toProductEntity(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(product.getId());
        productEntity.setBarCode(product.getBarCode());
        productEntity.setName(product.getName());
        productEntity.setPrice_sell(product.getPrice_sell());
        productEntity.setPrice_buy(product.getPrice_buy());
        productEntity.setStock(product.getStock());
        return productEntity;
    }
}
