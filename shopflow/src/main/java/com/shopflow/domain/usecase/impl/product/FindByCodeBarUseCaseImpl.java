package com.shopflow.domain.usecase.impl.product;

import com.shopflow.common.annotation.DomainTransactional;
import com.shopflow.common.annotation.DomainUseCase;
import com.shopflow.common.exception.ResourceNotFoundException;
import com.shopflow.domain.model.Product;
import com.shopflow.domain.service.ProductService;
import com.shopflow.domain.usecase.product.FindByCodeBarUseCase;
import org.springframework.beans.factory.annotation.Autowired;

@DomainUseCase
@DomainTransactional
public class FindByCodeBarUseCaseImpl implements FindByCodeBarUseCase {

    @Autowired
    private ProductService productService;

    @Override
    public Product findByCodeBar(String data) {
        return productService.findByBarCode(data)
                .orElseThrow(() -> new ResourceNotFoundException("Product with codeBar " + data + " not found"));
    }
}
