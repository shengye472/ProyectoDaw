package com.shopflow.persistence.repository.impl;

import com.shopflow.domain.model.Sale;
import com.shopflow.domain.repository.SaleRepository;
import com.shopflow.persistence.dao.SaleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SaleRepositoryImpl implements SaleRepository {

    @Autowired
    private SaleDao saleDao;

    @Override
    public void save(Sale venta) {
        saleDao.save(venta);
    }

    @Override
    public List<Sale> findAll() {
        return saleDao.findAll();
    }

    @Override
    public Optional<Sale> findById(Integer id) {
        return saleDao.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        saleDao.deleteById(id);
    }
}
