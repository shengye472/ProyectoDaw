package com.shopflow.domain.usecase;

import com.shopflow.domain.model.Product;

import java.util.List;

public interface FindAllUseCase {
    List<Product> findAll();
}
