package com.shopflow.domain.usecase.impl.product;

import com.shopflow.common.annotation.DomainTransactional;
import com.shopflow.common.annotation.DomainUseCase;
import com.shopflow.domain.model.Product;
import com.shopflow.domain.service.ProductService;
import com.shopflow.domain.usecase.common.FindAllUseCase;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DomainUseCase
@DomainTransactional
public class FindAllProductUseCaseImpl implements FindAllUseCase<Product> {

    @Autowired
    private ProductService productService;

    @Override
    public List<Product> findAll() {
        return productService.findAll();
    }

}
