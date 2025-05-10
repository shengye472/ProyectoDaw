package com.shopflow.persistence.dao.jpa.repository;

import com.shopflow.persistence.dao.jpa.model.DetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailJpaRepository extends JpaRepository<DetailEntity, Integer> {
}
