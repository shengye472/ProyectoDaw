package com.shopflow.domain.service;

import com.shopflow.domain.model.Sale;

import java.util.List;
import java.util.Optional;

public interface SaleService {
    void save(Sale venta);

    List<Sale> findAll(int page, int pageSize);

    Optional<Sale> findById(Integer id);

    void deleteById(Integer id);

    int count();
}
