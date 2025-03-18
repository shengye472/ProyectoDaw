package com.shopflow.domain.usecase.impl;

import com.shopflow.common.annotation.DomainTransactional;
import com.shopflow.common.annotation.DomainUseCase;
import com.shopflow.common.exception.ResourceNotFoundException;
import com.shopflow.domain.model.Product;
import com.shopflow.domain.service.ProductService;
import com.shopflow.domain.usecase.FindByBarCodeUseCase;

@DomainUseCase
@DomainTransactional
public class FindByBarCodeUseCaseImpl implements FindByBarCodeUseCase {

    private final ProductService productService;

    public FindByBarCodeUseCaseImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Product findByBarCode(String codeBar) {
        return productService.findByBarCode(codeBar)
                .orElseThrow(() -> new ResourceNotFoundException("Product with codeBar " + codeBar + " not found"));
    }
}
