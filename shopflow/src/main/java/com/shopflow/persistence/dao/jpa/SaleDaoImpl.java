package com.shopflow.persistence.dao.jpa;

import com.shopflow.domain.model.Sale;
import com.shopflow.persistence.dao.DetailDao;
import com.shopflow.persistence.dao.SaleDao;
import com.shopflow.persistence.dao.jpa.mapper.SaleJpaMapper;
import com.shopflow.persistence.dao.jpa.model.SaleEntity;
import com.shopflow.persistence.dao.jpa.repository.SaleJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SaleDaoImpl  implements SaleDao {

    @Autowired
    private DetailDao detailDao;

    @Autowired
    private SaleJpaRepository saleJpaRepository;

    @Override
    public void save(Sale venta) {
        SaleEntity back = saleJpaRepository.save(SaleJpaMapper.INSTANCE.toSaleEntity(venta));
        detailDao.save(venta.getDetails(), back);
    }

    @Override
    public List<Sale> findAll(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return saleJpaRepository.findAll(pageable)
                .stream()
                .map(SaleJpaMapper.INSTANCE::toSale)
                .toList();
    }

    @Override
    public Optional<Sale> findById(Integer id) {
        return saleJpaRepository.findById(id)
                .map(SaleJpaMapper.INSTANCE::toSale);
    }

    @Override
    public void deleteById(Integer id) {
        saleJpaRepository.deleteById(id);
    }

    @Override
    public int count() {
        List<Sale> saleList = saleJpaRepository.findAll()
                .stream()
                .map(SaleJpaMapper.INSTANCE::toSale)
                .toList();
        return saleList.size();
    }
}
