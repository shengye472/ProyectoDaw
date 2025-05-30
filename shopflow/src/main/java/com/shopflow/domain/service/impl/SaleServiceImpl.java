package com.shopflow.domain.service.impl;

import com.shopflow.common.annotation.DomainService;
import com.shopflow.domain.model.Sale;
import com.shopflow.domain.repository.SaleRepository;
import com.shopflow.domain.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@DomainService
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public void save(Sale venta) {
        saleRepository.save(venta);
    }

    @Override
    public List<Sale> findAll(int page, int pageSize) {
        return saleRepository.findAll(page, pageSize);
    }

    @Override
    public Optional<Sale> findById(Integer id) {
        return saleRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        saleRepository.deleteById(id);
    }

    @Override
    public int count() {
        return saleRepository.count();
    }
}
