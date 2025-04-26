package com.shopflow.persistence.dao.jpa.repository;

import com.shopflow.persistence.dao.jpa.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductJpaRepository extends JpaRepository<ProductEntity, Integer> {


    ProductEntity findByBarCode(String barCode);
}
