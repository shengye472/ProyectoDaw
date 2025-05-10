package com.shopflow.persistence.dao.jpa.repository;

import com.shopflow.persistence.dao.jpa.model.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleJpaRepository extends JpaRepository<SaleEntity,Integer> {

}
