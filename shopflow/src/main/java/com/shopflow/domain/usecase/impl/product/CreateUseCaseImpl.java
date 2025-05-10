package com.shopflow.domain.usecase.impl.product;

import com.shopflow.common.annotation.DomainTransactional;
import com.shopflow.common.annotation.DomainUseCase;
import com.shopflow.common.exception.ResourceAlreadyExistsException;
import com.shopflow.domain.model.Product;
import com.shopflow.domain.service.ProductService;
import com.shopflow.domain.usecase.product.CreateProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;

@DomainUseCase
@DomainTransactional
public class CreateUseCaseImpl implements CreateProductUseCase {

    @Autowired
    private ProductService productService;

    @Override
    public void create(Product product) {

        if (productService.findByBarCode(product.getBarCode()).isPresent()){
            throw new ResourceAlreadyExistsException("Product with barcode " + product.getBarCode() + " already exists");
        }
        productService.save(product);
    }
}
