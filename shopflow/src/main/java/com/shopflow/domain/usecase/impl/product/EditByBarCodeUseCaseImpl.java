package com.shopflow.domain.usecase.impl.product;

import com.shopflow.common.annotation.DomainTransactional;
import com.shopflow.common.annotation.DomainUseCase;
import com.shopflow.common.exception.ResourceNotFoundException;
import com.shopflow.domain.model.Product;
import com.shopflow.domain.service.ProductService;
import com.shopflow.domain.usecase.product.EditByCodeBarUseCase;
import org.springframework.beans.factory.annotation.Autowired;

@DomainUseCase
@DomainTransactional
public class EditByBarCodeUseCaseImpl implements EditByCodeBarUseCase {

    @Autowired
    private ProductService productService;

    @Override
    public void editBy(String barCode, Product product) {
        Product result = productService.findByBarCode(barCode)
                .orElseThrow(() -> new ResourceNotFoundException("Product with codeBar " + barCode + " not found"));
        product.setBarCode(barCode);
        product.setId(result.getId());
        productService.save(product);
    }
}
