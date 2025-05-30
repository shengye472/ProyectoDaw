package com.shopflow.domain.usecase.impl.sale;

import com.shopflow.common.annotation.DomainTransactional;
import com.shopflow.common.annotation.DomainUseCase;
import com.shopflow.domain.model.Sale;
import com.shopflow.domain.service.SaleService;
import com.shopflow.domain.usecase.common.FindAllUseCase;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DomainUseCase
@DomainTransactional
public class FindAllSaleUseCaseImpl implements FindAllUseCase<Sale> {

    @Autowired
    private SaleService saleService;

    @Override
    public List<Sale> findAll(int page, int pageSize) {
        return saleService.findAll(page, pageSize);
    }

    @Override
    public int count() {
        return saleService.count();
    }
}
