package com.shopflow.domain.usecase.sale;

import com.shopflow.domain.model.Sale;

public interface FindByIdUseCase {
    Sale findById(Integer id);
}
