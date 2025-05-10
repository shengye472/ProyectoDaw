package com.shopflow.persistence.dao.jpa.mapper;

import com.shopflow.domain.model.Detail;
import com.shopflow.persistence.dao.jpa.model.DetailEntity;

public class DetailJpaMapper {

    public static DetailJpaMapper INSTANCE = new DetailJpaMapper();

    public DetailEntity toDetailEntity(Detail detail) {
        DetailEntity detailEntity = new DetailEntity();
        detailEntity.setQuantity(detail.getQuantity());
        detailEntity.setSubtotal(detail.getSubtotal());
        detailEntity.setProduct(ProductJpaMapper.INSTANCE.toProductEntity(detail.getProducts()));
        return detailEntity;
    }

    public Detail toDetail(DetailEntity detailEntity) {
        Detail detail = new Detail();
        detail.setQuantity(detailEntity.getQuantity());
        detail.setSubtotal(detailEntity.getSubtotal());
        detail.setProducts(ProductJpaMapper.INSTANCE.toProduct(detailEntity.getProduct()));
        return detail;
    }
}
