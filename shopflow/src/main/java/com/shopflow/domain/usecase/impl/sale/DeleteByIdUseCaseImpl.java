package com.shopflow.domain.usecase.impl.sale;

import com.shopflow.common.annotation.DomainTransactional;
import com.shopflow.common.annotation.DomainUseCase;
import com.shopflow.common.exception.ResourceNotFoundException;
import com.shopflow.domain.service.SaleService;
import com.shopflow.domain.usecase.sale.DeleteByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;

@DomainUseCase
@DomainTransactional
public class DeleteByIdUseCaseImpl implements DeleteByIdUseCase {

    @Autowired
    private SaleService saleService;

    @Override
    public void deleteById(Integer id) {
        if (saleService.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("Sale with id " + id + " not found");
        }
        saleService.deleteById(id);
    }
}
