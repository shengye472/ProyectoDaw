package com.shopflow.domain.usecase.impl;

import com.shopflow.common.annotation.DomainTransactional;
import com.shopflow.common.annotation.DomainUseCase;
import com.shopflow.domain.model.Product;
import com.shopflow.domain.service.ProductService;
import com.shopflow.domain.usecase.FindAllUseCase;

import java.util.List;

@DomainUseCase
@DomainTransactional
public class FindAllUseCaseImpl implements FindAllUseCase {

    private final ProductService productService;

    public FindAllUseCaseImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public List<Product> findAll() {
        return productService.findAll();
    }

}
