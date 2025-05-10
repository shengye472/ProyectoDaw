package com.shopflow.domain.usecase.impl.sale;

import com.shopflow.common.annotation.DomainTransactional;
import com.shopflow.common.annotation.DomainUseCase;
import com.shopflow.common.exception.ResourceNotFoundException;
import com.shopflow.domain.model.Sale;
import com.shopflow.domain.service.SaleService;
import com.shopflow.domain.usecase.sale.FindByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;

@DomainUseCase
@DomainTransactional
public class FindByIdUseCaseImpl implements FindByIdUseCase {

    @Autowired
    private SaleService saleService;

    @Override
    public Sale findById(Integer id) {
        return saleService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sale with id " + id + " not found"));
    }
}
