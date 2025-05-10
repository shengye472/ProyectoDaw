package com.shopflow.persistence.dao.jpa.mapper;

import com.shopflow.domain.model.Detail;
import com.shopflow.domain.model.Sale;
import com.shopflow.persistence.dao.jpa.model.SaleEntity;

import java.util.List;

public class SaleJpaMapper {

    public static SaleJpaMapper INSTANCE = new SaleJpaMapper();

    public SaleEntity toSaleEntity(Sale sale){
        SaleEntity saleEntity = new SaleEntity();
        saleEntity.setId(sale.getId());
        saleEntity.setDate(sale.getDate());
        saleEntity.setTotal(sale.getTotal());
//        List<DetailEntity> detailEntities = sale.getDetails().stream()
//                .map(detail -> DetailJpaMapper.INSTANCE.toDetailEntity(detail))
//                .toList();
//        saleEntity.setDetails(detailEntities);
        return saleEntity;
    }

    public Sale toSale(SaleEntity saleEntity){
        Sale sale = new Sale();
        sale.setId(saleEntity.getId());
        sale.setDate(saleEntity.getDate());
        sale.setTotal(saleEntity.getTotal());
        List<Detail> details = saleEntity.getDetails().stream()
                .map(detail -> DetailJpaMapper.INSTANCE.toDetail(detail))
                .toList();
        sale.setDetails(details);
        return sale;
    }

}
