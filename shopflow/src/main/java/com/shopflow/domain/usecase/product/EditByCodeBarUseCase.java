package com.shopflow.domain.usecase.product;

import com.shopflow.domain.model.Product;

public interface EditByCodeBarUseCase {
    void editBy(String barCode, Product product);
}
