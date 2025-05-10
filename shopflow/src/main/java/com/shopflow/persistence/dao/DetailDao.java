package com.shopflow.persistence.dao;

import com.shopflow.domain.model.Detail;
import com.shopflow.persistence.dao.jpa.model.SaleEntity;

import java.util.List;

public interface DetailDao {

    void save(List<Detail> details, SaleEntity saleEntity);
}
