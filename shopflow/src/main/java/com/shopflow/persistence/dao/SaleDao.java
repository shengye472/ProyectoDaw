package com.shopflow.persistence.dao;

import com.shopflow.domain.model.Sale;

import java.util.List;
import java.util.Optional;

public interface SaleDao {
    void save(Sale venta);

    List<Sale> findAll();

    Optional<Sale> findById(Integer id);

    void deleteById(Integer id);
}
