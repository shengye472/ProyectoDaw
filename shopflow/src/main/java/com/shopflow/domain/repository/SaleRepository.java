package com.shopflow.domain.repository;

import com.shopflow.domain.model.Sale;

import java.util.List;
import java.util.Optional;

public interface SaleRepository {
    void save(Sale venta);

    List<Sale> findAll(int page, int pageSize);

    Optional<Sale> findById(Integer id);

    void deleteById(Integer id);

    int count();
}
