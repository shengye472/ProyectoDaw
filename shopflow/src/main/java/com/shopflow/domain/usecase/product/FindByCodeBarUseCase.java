package com.shopflow.domain.usecase.product;

import com.shopflow.domain.model.Product;

public interface FindByCodeBarUseCase {

    Product findByCodeBar(String data);
}
