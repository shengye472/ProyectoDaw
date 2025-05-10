package com.shopflow.persistence.dao.jpa;

import com.shopflow.domain.model.Detail;
import com.shopflow.persistence.dao.DetailDao;
import com.shopflow.persistence.dao.jpa.mapper.DetailJpaMapper;
import com.shopflow.persistence.dao.jpa.model.DetailEntity;
import com.shopflow.persistence.dao.jpa.model.SaleEntity;
import com.shopflow.persistence.dao.jpa.repository.DetailJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DetailDaoImpl implements DetailDao {

    @Autowired
    private DetailJpaRepository detailJpaRepository;

    @Override
    public void save(List<Detail> details, SaleEntity saleEntity) {
            List<DetailEntity> detailEntities = details.stream()
            .map(detail -> {
                DetailEntity detailEntity = DetailJpaMapper.INSTANCE.toDetailEntity(detail);
                detailEntity.setSale(saleEntity);
                return detailEntity;
            })
            .toList();

            detailJpaRepository.saveAll(detailEntities);
    }
}
