package com.shopflow.persistence.dao.jpa;

import com.shopflow.domain.model.Product;
import com.shopflow.persistence.dao.ProductDao;
import com.shopflow.persistence.dao.jpa.mapper.ProductJpaMapper;
import com.shopflow.persistence.dao.jpa.repository.ProductJpaRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class ProductDaoImpl implements ProductDao {

    private final ProductJpaRepository productJpaRepository;

    public ProductDaoImpl(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public List<Product> findAll(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return productJpaRepository.findAll(pageable)
                .stream()
                .map(ProductJpaMapper.INSTANCE::toProduct)
                .toList();
    }

    @Override
    public Optional<Product> findByBarCode(String barCode) {
        return Optional.ofNullable(productJpaRepository
                .findByBarCode(barCode))
                .map(ProductJpaMapper.INSTANCE::toProduct);
    }

    @Override
    public void save(Product product) {
        productJpaRepository.save(ProductJpaMapper.INSTANCE.toProductEntity(product));

    }

    @Override
    public void deleteByCodeBar(String codeBar) {
        productJpaRepository.deleteByBarCode(codeBar);
    }

    @Override
    public int count() {
        List<Product> productList = productJpaRepository.findAll()
                .stream()
                .map(ProductJpaMapper.INSTANCE::toProduct)
                .toList();

        return productList.size();
    }
}
