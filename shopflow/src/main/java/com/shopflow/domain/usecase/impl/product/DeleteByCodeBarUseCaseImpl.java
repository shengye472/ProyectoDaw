package com.shopflow.domain.usecase.impl.product;

import com.shopflow.common.annotation.DomainTransactional;
import com.shopflow.common.annotation.DomainUseCase;
import com.shopflow.common.exception.ResourceNotFoundException;
import com.shopflow.domain.service.ProductService;
import com.shopflow.domain.usecase.product.DeleteByCodeBarUseCase;
import org.springframework.beans.factory.annotation.Autowired;

@DomainUseCase
@DomainTransactional
public class DeleteByCodeBarUseCaseImpl implements DeleteByCodeBarUseCase {

    @Autowired
    private ProductService productService;

    @Override
    public void deleteByCodeBar(String data) {
        if (productService.findByBarCode(data).isEmpty()) {
            throw new ResourceNotFoundException("Product with codeBar " + data + " not found");
        }
        productService.deleteByCodeBar(data);
    }
}
