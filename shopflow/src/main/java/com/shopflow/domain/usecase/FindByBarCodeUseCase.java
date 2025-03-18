package com.shopflow.domain.usecase;

import com.shopflow.domain.model.Product;

public interface FindByBarCodeUseCase {

    Product findByBarCode(String barCode);
}
