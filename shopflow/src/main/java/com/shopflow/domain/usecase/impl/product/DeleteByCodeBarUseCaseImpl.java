package com.shopflow.domain.usecase.impl.product;

import com.shopflow.common.annotation.DomainTransactional;
import com.shopflow.common.annotation.DomainUseCase;
import com.shopflow.common.exception.ResourceAlreadyExistsException;
import com.shopflow.common.exception.ResourceNotFoundException;
import com.shopflow.domain.model.Product;
import com.shopflow.domain.service.ProductService;
import com.shopflow.domain.usecase.DeleteByUseCase;

@DomainUseCase
@DomainTransactional
public class DeleteByCodeBarUseCaseImpl implements DeleteByUseCase<Product> {

    private final ProductService productService;

    public DeleteByCodeBarUseCaseImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void deleteBy(String data) {
        if (productService.findByBarCode(data).isEmpty()) {
            throw new ResourceNotFoundException("Product with codeBar " + data + " not found");
        }
        productService.deleteByCodeBar(data);
    }
}
