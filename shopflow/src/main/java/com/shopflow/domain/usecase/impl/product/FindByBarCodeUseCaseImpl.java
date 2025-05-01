package com.shopflow.domain.usecase.impl.product;

import com.shopflow.common.annotation.DomainTransactional;
import com.shopflow.common.annotation.DomainUseCase;
import com.shopflow.common.exception.ResourceNotFoundException;
import com.shopflow.domain.model.Product;
import com.shopflow.domain.service.ProductService;
import com.shopflow.domain.usecase.FindByUseCase;

@DomainUseCase
@DomainTransactional
public class FindByBarCodeUseCaseImpl implements FindByUseCase<Product> {

    private final ProductService productService;

    public FindByBarCodeUseCaseImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Product findBy(String data) {
        return productService.findByBarCode(data)
                .orElseThrow(() -> new ResourceNotFoundException("Product with codeBar " + data + " not found"));
    }
}
